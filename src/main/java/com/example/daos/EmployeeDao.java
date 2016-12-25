package com.example.daos;

import com.example.models.Employee;
import com.example.utils.DerbyConnectionManager;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by chinmay_dutta on 12/23/16.
 */
@Repository
public class EmployeeDao {

    private static final String queryString = "Select * from APP.EMPLOYEE where id = ?";
    private static final String selectAll = "Select * from APP.EMPLOYEE";
    public static final String insertRecords = "INSERT INTO APP.EMPLOYEE (ID, NAME, AGE) VALUES (?, ?, ?)";


    public Employee getEmployee(Integer id) {
        ResultSet rs = null;
        Employee emp = new Employee();
        try {
            Connection con = DerbyConnectionManager.getConnection();
            PreparedStatement pstmt = con.prepareStatement(queryString);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            rs.next();
            emp.setId(rs.getInt("ID"));
            emp.setAge(rs.getInt("AGE"));
            emp.setName(rs.getString("NAME"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return emp;

    }

    public Employee insertEmployee(Employee emp) {
        try {
            Connection con = DerbyConnectionManager.getConnection();
            PreparedStatement pstmt = con.prepareStatement(insertRecords);
            pstmt.setInt(1, emp.getId());
            pstmt.setString(2, emp.getName());
            pstmt.setInt(3, emp.getAge());
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return emp;

    }


    public List<Employee> getEmployees() {

        List<Employee> employees = new ArrayList<>();

        try {
            Connection con = DerbyConnectionManager.getConnection();
            PreparedStatement pstmt = con.prepareStatement(selectAll);
            pstmt.executeQuery();
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Employee emp = new Employee();
                emp.setId(rs.getInt("ID"));
                emp.setAge(rs.getInt("AGE"));
                emp.setName(rs.getString("NAME"));
                employees.add(emp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employees;

    }


}
