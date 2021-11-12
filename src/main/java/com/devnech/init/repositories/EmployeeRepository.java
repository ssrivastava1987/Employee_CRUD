package com.devnech.init.repositories;

import com.devnech.init.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Author: shubhamsrivastava
 **/
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Employee getById(String employeeId);

    Employee deleteById(String employeeId);

    List<Employee> findByName(String employeeName);
}
