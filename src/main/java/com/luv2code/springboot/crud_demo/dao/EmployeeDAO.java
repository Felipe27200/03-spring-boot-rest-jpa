package com.luv2code.springboot.crud_demo.dao;

import com.luv2code.springboot.crud_demo.entity.Employee;

import java.util.List;

public interface EmployeeDAO
{
    public List<Employee> findAll();

    Employee findById(Long id);

    Employee save(Employee employee);

    void deleteById(Long id);
}