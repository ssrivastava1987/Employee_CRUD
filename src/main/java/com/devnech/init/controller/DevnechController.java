package com.devnech.init.controller;

import com.devnech.init.entity.Employee;
import com.devnech.init.service.DevnechService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Author: shubhamsrivastava
 **/
@RestController
@RequestMapping("/v1/devnech/employees")
public class DevnechController {

    @Autowired
    DevnechService devnechService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getAllEmployees(){
        List<Employee> employees = devnechService.getAllEmployees();
        return new ResponseEntity<String>(employees.toString(), HttpStatus.OK);

    }

    @GetMapping(path = "/employee/{employeeId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getEmployee(@PathVariable(value = "employeeId") String employeeId){
        Employee employee = devnechService.getEmployee(employeeId);
        return Objects.nonNull(employee) ? employee.toString() : null;
    }

    @GetMapping(path = "/employee", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getEmployeeByName(@RequestParam(value = "employeeName") String employeeName){
        List<Employee> employees = devnechService.getEmployeeByName(employeeName);
        return Objects.nonNull(employees) ? employees.toString() : new ArrayList<Employee>().toString();
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public String create(@RequestBody Employee employee){
        Employee savedEmployee = devnechService.create(employee);
        return savedEmployee.toString();
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public String update(@RequestBody Employee employee){
        Employee savedEmployee = devnechService.update(employee);
        return savedEmployee.toString();
    }

    @DeleteMapping(path="/{employeeId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String delete(@PathVariable(value = "employeeId") String employeeId){
        String savedEmployee = devnechService.delete(employeeId);
        return savedEmployee;
    }


}
