package com.luv2code.springboot.crud_demo.dao;

import com.luv2code.springboot.crud_demo.entity.Employee;
import com.sun.jdi.IntegerType;
import org.springframework.data.jpa.repository.JpaRepository;

/*
* +----------------------------+
* | JPA WITH COMMONS FUNCTIONS |
* +----------------------------+
*
* JPA has some commons methods for the persistence
* with the DB, so for using that methods we need
* extends its interface to make use of them.
*
* Define the first Generic type as Employee to refers to
* the entity and the second generic type refers to the
* type of the primary key of the entity.
* */
public interface EmployeeRepository extends JpaRepository<Employee, Long>
{
    // That's it... We don't need to write more code.

    /*
    * +-----------------------------+
    * | JPA offers the CRUD METHODS |
    * +-----------------------------+
    * */
}
