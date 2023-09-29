package com.luv2code.springboot.crud_demo.service;

import com.luv2code.springboot.crud_demo.dao.EmployeeRepository;
import com.luv2code.springboot.crud_demo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/*
* Add an extra layer to manage business
* logic, so with the annotation Spring can
* access and use it.
* */
@Service
public class EmployeeServiceImpl implements EmployeeService
{
    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository)
    {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll()
    {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(Long id)
    {
        /*
        * Different pattern instead of having to check
        * for null, that is the purpose of Optional<>.
        * */
        Optional<Employee> result = this.employeeRepository.findById(id);

        Employee employee = null;

        /*
        * If the value in result is different to null
        * this method will return true, the other shape, return false.
        * */
        if (result.isPresent())
        {
            // Return the value assigned to the Optional<>
            employee = result.get();
        }
        else
            throw new RuntimeException("Did not find the id: " + id);

        return employee;
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteById(Long id) {
        employeeRepository.deleteById(id);
    }
}
