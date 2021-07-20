package com.tregulov.spring.rest.controller;

import com.tregulov.spring.rest.entity.Employee;
import com.tregulov.spring.rest.exception_handling.EmployeeIncorrectData;
import com.tregulov.spring.rest.exception_handling.NoSuchEmployeeException;
import com.tregulov.spring.rest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRESTController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        List<Employee> allEmployees = employeeService.getAllEmployees();
        return  allEmployees;
    }
    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id){
        Employee employee = employeeService.getEmployee(id);
        if (employee==null){
            throw new NoSuchEmployeeException("Employee with ID ("+id+") not found");
        }
        return employee;
    }

}
