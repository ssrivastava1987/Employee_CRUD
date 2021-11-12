package com.devnech.init.common;

import com.devnech.init.entity.Employee;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Objects;

/**
 * Author: shubhamsrivastava
 **/
@Component
public class DevnechCommon {
    public static Employee compareAndUpdate(Employee emp, Employee employee) {

        if(Objects.nonNull(employee.getAge())) {
            emp.setAge(employee.getAge());
        }

        if(Objects.nonNull(employee.getCity())) {
            emp.setCity(employee.getCity());
        }

        if(Objects.nonNull(employee.getDepartment())) {
            emp.setDepartment(employee.getDepartment());
        }

        if(Objects.nonNull(employee.getEmail())) {
            emp.setEmail(employee.getEmail());
        }

        if(Objects.nonNull(employee.getPhone())) {
            emp.setPhone(employee.getPhone());
        }

        if(Objects.nonNull(employee.getSalary())) {
            emp.setSalary(employee.getSalary());
        }

        emp.setModifiedBy("SYSTEM");
        emp.setModifiedDate(new Date());

        return emp;

    }
}
