package com.example;

import com.example.models.Employee;
import com.example.utils.DerbyConnectionManager;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by chinmay_dutta on 12/24/16.
 */
@Component
public class Startup implements ApplicationListener<ContextRefreshedEvent>  {

    public static final String empTable = "CREATE TABLE APP.EMPLOYEE ( ID INT NOT NULL, NAME VARCHAR(100) NOT NULL, AGE INT NOT NULL)";
    public static final String insertRecords = "INSERT INTO APP.EMPLOYEE (ID, NAME, AGE) VALUES (?, ?, ?)";



    // Create the employee table and insert some records there
    @Override
    public void onApplicationEvent(final ContextRefreshedEvent event) {

        Employee sonali = new Employee();
        Employee ayaansh = new Employee();
        Employee chinmay = new Employee();
        sonali.setId(1);
        sonali.setName("SONALI");
        sonali.setAge(32);

        ayaansh.setId(2);
        ayaansh.setName("AYAANSH");
        ayaansh.setAge(1);

        chinmay.setId(3);
        chinmay.setName("CHINMAY");
        chinmay.setAge(35);

        List<Employee> empList = new ArrayList<>();
        empList.add(sonali);
        empList.add(ayaansh);
        empList.add(chinmay);


        try {
            Connection con = DerbyConnectionManager.getConnection();
            PreparedStatement pstmt = con.prepareStatement(empTable);
            //pstmt.executeUpdate();
            PreparedStatement pstmt1 = con.prepareStatement(insertRecords);

          for(Employee emp : empList){
              pstmt1.setInt(1,emp.getId());
              pstmt1.setString(2,emp.getName());
              pstmt1.setInt(3,emp.getAge());
              pstmt1.executeUpdate();
          }


        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
