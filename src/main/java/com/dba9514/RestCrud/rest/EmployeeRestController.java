package com.dba9514.RestCrud.rest;

import com.dba9514.RestCrud.entity.Employee;
import com.dba9514.RestCrud.service.EmployeeService;
import org.hibernate.query.NativeQuery;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    //Coupled to the service layer.
    private EmployeeService employeeService;
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    //Post Mapping for creating a new employee
    //==CREATE==
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee) {
        //Setting ID to 0 to force a CREATE.
        employee.setId(0);

        //Saving and returning the employee object to display to the front-end.
        return employeeService.save(employee);
    }

    //GET Mapping for returning all employees
    //==READ==
    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    //GET Mapping for returning specific employee by ID via path variable.
    //==READ==
    @GetMapping("/employees/{employeeId}")
    public Employee findById(@PathVariable int employeeId) {
        Employee employee = employeeService.findById(employeeId);
        if (employee == null)
            throw new RuntimeException("Employee id of " + employeeId + " not found!");
        else
            return employee;
    }

    //Put Mapping for updating an employee
    //==UPDATE==
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {

        return employeeService.save(employee);
    }

    //DELETE Mapping for deleting an employee by ID
    //==DELETE==
    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable Integer employeeId) {
        Employee tempEmployee = employeeService.findById(employeeId);

        if (tempEmployee == null) {
            throw new RuntimeException("Employee does not exist with ID: " + employeeId + "!");
        }
        employeeService.deleteById(employeeId);

        return "Deleted employee with ID: " + employeeId;

    }


}
