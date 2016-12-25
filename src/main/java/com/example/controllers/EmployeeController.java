package com.example.controllers;


import com.example.models.Employee;
import com.example.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chinmay_dutta on 12/23/16.
 */
@RestController
@RequestMapping("/demoApp")
public class EmployeeController {

    @Autowired
    EmployeeService empService;
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Employee getEmployee(@PathVariable("id") Integer id)  {
        return empService.getEmployee(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createEmployee(@RequestBody Employee employee)  {
        System.out.println("Post got invoked" + employee);
        empService.createEmployee(employee);

    }

    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    public List<Employee> getListOfEmployees()  {
        System.out.println("Post got invoked");
       return empService.getEmployees();
    }


}
