package com.luv2code.springboot.crud_demo.rest;

import com.luv2code.springboot.crud_demo.entity.Employee;
import com.luv2code.springboot.crud_demo.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController
{
    private EmployeeService employeeService;

    /*
     * +--------------------+
     * | INJECT THE SERVICE |
     * +--------------------+
     *
     * Now we will inject the service
     * in the controller, to define
     * the business login inside the
     * service and instead in the controller.
     * */
    @Autowired
    public EmployeeRestController(EmployeeService employeeService)
    {
        this.employeeService = employeeService;
    }

    // Return a list of Employees
    @GetMapping("/employees")
    public List<Employee> getEmployees()
    {
        return employeeService.findAll();
    }

    // Add mapping for GET employee
    @GetMapping("/employees/{employeeId}") // If we use @PathVariable for default
    public Employee getEmployee(@PathVariable Long employeeId) // the name of the param must match with the parameter
    {
        Employee employee = employeeService.findById(employeeId);

        if (employee == null)
            throw new RuntimeException("Not find Employee with the id: " + employeeId);

        return employee;
    }
}
