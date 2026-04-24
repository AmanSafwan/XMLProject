package com.mycompany.xmlproject;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.*;
import java.sql.*;

public class XMLImport {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/globaltech";
        String user = "root";
        String password = "";

        try {
            // CONNECT DB
            Connection conn = DriverManager.getConnection(url, user, password);

            // READ XML FILE
            File file = new File("employees.xml");

            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(file);

            doc.getDocumentElement().normalize();

            NodeList nodeList = doc.getElementsByTagName("Employee");

            for (int i = 0; i < nodeList.getLength(); i++) {

                Node node = nodeList.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {

                    Element e = (Element) node;

                    int id = Integer.parseInt(e.getElementsByTagName("emp_id").item(0).getTextContent());
                    String name = e.getElementsByTagName("emp_name").item(0).getTextContent();
                    String email = e.getElementsByTagName("email").item(0).getTextContent();
                    int dept = Integer.parseInt(e.getElementsByTagName("dept_id").item(0).getTextContent());
                    String job = e.getElementsByTagName("job_title").item(0).getTextContent();
                    String date = e.getElementsByTagName("hire_date").item(0).getTextContent();
                    String status = e.getElementsByTagName("status").item(0).getTextContent();

                    String sql = "INSERT INTO Employee (emp_id, emp_name, email, dept_id, job_title, hire_date, status) VALUES (?, ?, ?, ?, ?, ?, ?)";

                    PreparedStatement ps = conn.prepareStatement(sql);
                    ps.setInt(1, id);
                    ps.setString(2, name);
                    ps.setString(3, email);
                    ps.setInt(4, dept);
                    ps.setString(5, job);
                    ps.setString(6, date);
                    ps.setString(7, status);

                    ps.executeUpdate();
                }
            }

            conn.close();

            System.out.println("XML Import Successful!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}