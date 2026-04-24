package com.mycompany.xmlproject;

import java.sql.*;
import java.io.FileWriter;

public class XMLProject {

    public static void main(String[] args) {

        // ==============================
        // DATABASE CONFIG
        // ==============================
        String url = "jdbc:mysql://localhost:3306/globaltech";
        String user = "root";
        String password = "";

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        FileWriter writer = null;

        try {
            // ==============================
            // 1. CONNECT TO DATABASE
            // ==============================
            conn = DriverManager.getConnection(url, user, password);

            // ==============================
            // 2. QUERY DATA
            // ==============================
            String sql = "SELECT * FROM Employee";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            // ==============================
            // 3. CREATE XML FILE
            // ==============================
            writer = new FileWriter("employees.xml");

            writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
            writer.write("<Employees>\n");

            // ==============================
            // 4. LOOP RESULT → XML FORMAT
            // ==============================
            while (rs.next()) {

                writer.write("  <Employee>\n");
                writer.write("    <emp_id>" + rs.getInt("emp_id") + "</emp_id>\n");
                writer.write("    <emp_name>" + rs.getString("emp_name") + "</emp_name>\n");
                writer.write("    <email>" + rs.getString("email") + "</email>\n");
                writer.write("    <dept_id>" + rs.getInt("dept_id") + "</dept_id>\n");
                writer.write("    <job_title>" + rs.getString("job_title") + "</job_title>\n");
                writer.write("    <hire_date>" + rs.getDate("hire_date") + "</hire_date>\n");
                writer.write("    <status>" + rs.getString("status") + "</status>\n");
                writer.write("  </Employee>\n");

            }

            writer.write("</Employees>");

            // ==============================
            // 5. CLOSE EVERYTHING
            // ==============================
            writer.close();
            rs.close();
            stmt.close();
            conn.close();

            System.out.println("XML Export Successful! File generated: employees.xml");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}