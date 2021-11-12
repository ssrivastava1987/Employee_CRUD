package com.devnech.init.service.impl;

import com.devnech.init.common.DevnechCommon;
import com.devnech.init.entity.Employee;
import com.devnech.init.repositories.EmployeeRepository;
import com.devnech.init.service.DevnechService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 * Author: shubhamsrivastava
 **/
@Service
public class DevnechServiceImpl implements DevnechService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployee(String employeeId) {
        return employeeRepository.getById(employeeId);
    }

    @Override
    public Employee create(Employee employee) {
        employee.setId(UUID.randomUUID().toString());
        employee.setCreatedBy("SYSTEM");
        employee.setModifiedBy("SYSTEM");
        employee.setCreatedDate(new Date());
        employee.setModifiedDate(new Date());
        return employeeRepository.save(employee);
    }

    @Override
    public Employee update(Employee employee) {
        Employee emp = employeeRepository.getById(employee.getId());
        Employee updateEmployee = null;
        if(Objects.nonNull(emp)) {
            updateEmployee = DevnechCommon.compareAndUpdate(emp, employee);
        }
        return employeeRepository.save(updateEmployee);
    }

    @Override
    public String delete(String employeeId) {
        Employee emp = employeeRepository.getById(employeeId);
        String deleted = null;
        if(Objects.nonNull(emp)) {
            employeeRepository.delete(emp);
            deleted = "Successfully Deleted";
        } else {
            deleted = "Nothing to Delete";
        }
        return deleted;
    }

    @Override
    public List<Employee> getEmployeeByName(String employeeName) {
        return employeeRepository.findByName(employeeName);
    }
}
