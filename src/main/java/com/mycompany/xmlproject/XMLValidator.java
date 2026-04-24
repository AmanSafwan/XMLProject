package com.mycompany.xmlproject;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;

public class XMLValidator {

    public static void main(String[] args) {

        try {
            // =========================
            // 1. FILE PATH
            // =========================
            File xsdFile = new File("employee.xsd");
            File xmlFile = new File("employees.xml");

            System.out.println("XSD Path: " + xsdFile.getAbsolutePath());
            System.out.println("XML Path: " + xmlFile.getAbsolutePath());

            // =========================
            // 2. CREATE SCHEMA FACTORY
            // =========================
            SchemaFactory factory =
                    SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

            // =========================
            // 3. LOAD XSD
            // =========================
            Schema schema = factory.newSchema(xsdFile);

            // =========================
            // 4. CREATE VALIDATOR
            // =========================
            Validator validator = schema.newValidator();

            // =========================
            // 5. VALIDATE XML
            // =========================
            validator.validate(new StreamSource(xmlFile));

            System.out.println("✅ XML is VALID according to XSD");

        } catch (Exception e) {
            System.out.println("❌ XML is NOT valid according to XSD");
            System.out.println("Error: " + e.getMessage());
        }
    }
}