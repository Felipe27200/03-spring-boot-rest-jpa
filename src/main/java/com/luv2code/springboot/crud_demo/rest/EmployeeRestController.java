package com.luv2code.springboot.crud_demo.rest;

import com.luv2code.springboot.crud_demo.entity.Employee;
import com.luv2code.springboot.crud_demo.service.EmployeeService;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    // Add an Employee
    @PostMapping("/employees")
    /*
    * +-------------------------------------+
    * | OBTAIN THE JSON BODY IN THE REQUEST |
    * +-------------------------------------+
    *
    * With the @RequestBody we can get the JSON type
    * information bind to the request.
    * */
    public Employee addEmployee(@RequestBody Employee theEmployee)
    {
        // Set the employee to zero to force the creation of a new.
        theEmployee.setId(0L);

        Employee dbEmployee = employeeService.save(theEmployee);

        return dbEmployee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee)
    {
        Employee dbEmployee = employeeService.save(theEmployee);

        return dbEmployee;
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable Long employeeId)
    {
        Employee employee = employeeService.findById(employeeId);

        if (employee == null)
            throw new RuntimeException("Employee ID Not Found: " + employeeId);

        employeeService.deleteById(employee.getId());

        return "Employee deleted: \n" + employee.toString();
    }
}
