package com.luv2code.springboot.crud_demo.service;

import com.luv2code.springboot.crud_demo.dao.EmployeeDAO;
import com.luv2code.springboot.crud_demo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
* Add an extra layer to manage business
* logic, so with the annotation Spring can
* access and use it.
* */
@Service
public class EmployeeServiceImpl implements EmployeeService
{
    private EmployeeDAO employeeDAO;

    @Autowired
    private EmployeeServiceImpl(EmployeeDAO employeeDAO)
    {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public List<Employee> findAll()
    {
        return employeeDAO.findAll();
    }
}
