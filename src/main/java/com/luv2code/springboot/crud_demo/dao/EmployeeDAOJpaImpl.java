package com.luv2code.springboot.crud_demo.dao;

import com.luv2code.springboot.crud_demo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO
{
    // Define field for EntityManager
    private final EntityManager entityManager;

    // Set up constructor Injection
    @Autowired
    public EmployeeDAOJpaImpl(EntityManager entityManager)
    {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll()
    {
        // Create a query
        TypedQuery<Employee> query = entityManager.createQuery("from Employee", Employee.class);

        // Execute query and get the list
        List<Employee> employees = query.getResultList();

        if (employees.size() <= 0)
            return null;
        else
        {
            // return the result
            return employees;
        }
    }
}
