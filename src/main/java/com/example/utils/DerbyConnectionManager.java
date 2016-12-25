package com.example.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * Created by chinmay_dutta on 12/24/16.
 */
public class DerbyConnectionManager {
    public static final String driverName = "org.apache.derby.jdbc.EmbeddedDriver";
    public static String protocol = "jdbc:derby:";

    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName(driverName).newInstance();
            con = DriverManager.getConnection(protocol + "APP");

        } catch (Exception e) {
            System.out.print(e);
            e.printStackTrace();
        }


        return con;

    }
}
