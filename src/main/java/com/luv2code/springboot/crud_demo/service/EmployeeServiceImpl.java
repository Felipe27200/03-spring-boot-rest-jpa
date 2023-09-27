package com.luv2code.springboot.crud_demo.service;

import com.luv2code.springboot.crud_demo.dao.EmployeeDAO;
import com.luv2code.springboot.crud_demo.entity.Employee;
import jakarta.transaction.Transactional;
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
    public EmployeeServiceImpl(EmployeeDAO employeeDAO)
    {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public List<Employee> findAll()
    {
        return employeeDAO.findAll();
    }

    @Override
    public Employee findById(Long id) {
        return employeeDAO.findById(id);
    }

    @Override
    /*
    * +--------------------------+
    * | MANAGE THE TRANSACTIONAL |
    * +--------------------------+
    * */
    @Transactional
    public Employee save(Employee employee) {
        return employeeDAO.save(employee);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        employeeDAO.deleteById(id);
    }
}
