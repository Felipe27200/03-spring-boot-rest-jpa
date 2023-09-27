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
    private EntityManager entityManager;

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

    @Override
    public Employee findById(Long id) {
        Employee employee = entityManager.find(Employee.class, id);

        return employee;
    }

    /*
    * So you can see we don't use the @Transactional
    * because all this code will be handled at Service Layer.
    *
    * The DAO doesn't handle the transactional.
    * */
    @Override
    public Employee save(Employee employee)
    {
        /*
        * +---------------------------+
        * | CREATE OR UPDATE A RECORD |
        * +---------------------------+
        *
        * The merge() method will create the employee if
        * the id of the entity is zero or update if the id
        * match with someone in the DB.
        *
        * Then it returns the employee from the DB.
        * */
        Employee createdEmployee = entityManager.merge(employee);

        return createdEmployee;
    }

    @Override
    public void deleteById(Long id)
    {
        Employee employee = this.findById(id);

        entityManager.remove(employee);
    }

}
