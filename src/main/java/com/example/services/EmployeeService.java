package com.example.services;

import com.example.daos.EmployeeDao;
import com.example.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by chinmay_dutta on 12/23/16.
 */
@Service
public class EmployeeService {

    @Autowired
    private EmployeeDao empDao;

    public Employee getEmployee(Integer id) {
        return empDao.getEmployee(id);
    }

    public Employee createEmployee(Employee employee) {
        return empDao.insertEmployee(employee);
    }

    public List<Employee> getEmployees() {
        return empDao.getEmployees();
    }

}
