package com.devnech.init.service;

import com.devnech.init.entity.Employee;

import java.util.List;

/**
 * Author: shubhamsrivastava
 **/
public interface DevnechService {
    List<Employee> getAllEmployees();

    Employee getEmployee(String employeeId);

    Employee create(Employee employee);

    Employee update(Employee employee);

    String delete(String employeeId);

    List<Employee> getEmployeeByName(String employeeName);
}
