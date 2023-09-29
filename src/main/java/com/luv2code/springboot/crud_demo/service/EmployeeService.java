package com.luv2code.springboot.crud_demo.service;

import com.luv2code.springboot.crud_demo.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService
{
    List<Employee> findAll();

    Employee findById(Long id);

    Employee save(Employee employee);

    void deleteById(Long id);
}
