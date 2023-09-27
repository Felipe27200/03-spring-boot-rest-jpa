package com.luv2code.springboot.crud_demo.rest;

import com.luv2code.springboot.crud_demo.dao.EmployeeDAO;
import com.luv2code.springboot.crud_demo.entity.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController
{
    private EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeRestController(EmployeeDAO employeeDAO)
    {
        this.employeeDAO = employeeDAO;
    }

    // Return a list of Employees
    @GetMapping("/employees")
    public List<Employee> getEmployees()
    {
        return employeeDAO.findAll();
    }
}
