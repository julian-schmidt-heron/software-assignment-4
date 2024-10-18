package com.example;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class PrescriptionTest {

    // Test Case 1: Test the addPrescription function with valid first and last names
    @Test
    void testValidNamesForPrescription() throws ParseException {
        // Create valid date format "dd/MM/yy"
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");

        // Test Data 1: Valid first and last name, both at 4 character lower bound
        Prescription prescription1 = new Prescription(1, "John", "Sith", 
            "123 Main St, Suburb, 12345, Country", -3.50f, 90f, -2.00f, 
            dateFormat.parse("01/10/23"), "Dr. Jonathan");

        // Test Data 2: Valid first and last names, both at 15 characters upper bound
        Prescription prescription2 = new Prescription(2, "AlexanderParker", 
            "Christophersons", "123 Main St, Suburb, 12345, Country", 
            -3.50f, 90f, -2.00f, dateFormat.parse("01/10/23"), "Dr. Jonathan");

        // Assert that both prescriptions are successfully added
        assertTrue(prescription1.addPrescription(), "Test Case 1: Valid Names - prescription1 should be added");
        assertTrue(prescription2.addPrescription(), "Test Case 1: Valid Names - prescription2 should be added");
    }

    // Test Case 2: Test the addPrescription function with invalid names
    @Test
    void testAddPrescriptionInvalidNames() throws ParseException {
        // Create valid date format "dd/MM/yy"
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");

        // Test Data 1: Invalid first and last name (exactly 3 characters)
        Prescription prescription1 = new Prescription(3, "Sam", "Tom", 
            "789 Example Road, Area, 6000, Country", -2.0f, 180f, -1.00f, 
            dateFormat.parse("01/10/23"), "Dr. Jonathan");

        // Test Data 2: Invalid first and last name (exactly 16 characters)
        Prescription prescription2 = new Prescription(4, "AlexanderTheGreat", 
            "VeryLongLastName", "789 Example Road, Area, 6000, Country", 
            -2.0f, 180f, -1.00f, dateFormat.parse("01/10/23"), "Dr. Jonathan");

        // Assert that neither prescription is added
        assertFalse(prescription1.addPrescription(), "Test Case 2: Invalid Names - prescription1 should not be added");
        assertFalse(prescription2.addPrescription(), "Test Case 2: Invalid Names - prescription2 should not be added");
    }

    // Test Case 3: Test the addPrescription function with invalid address (less than 20 characters)
    @Test
    void testAddPrescriptionInvalidAddress() throws ParseException {
        // Create valid date format
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");

        // Test Data 1: Address with 19 characters (just below boundary)
        Prescription prescription1 = new Prescription(5, "Alice", "Brown", 
            "1 Main St, City, CA", -3.50f, 90f, -2.00f, dateFormat.parse("20/10/23"), "Dr. Jonathan");

        // Test Data 2: Another invalid address with fewer than 20 characters
        Prescription prescription2 = new Prescription(6, "Alice", "Brown", 
            "Short Address", -3.50f, 90f, -2.00f, dateFormat.parse("20/10/23"), "Dr. Jonathan");

        // Assert that both prescriptions are not added
        assertFalse(prescription1.addPrescription(), "Test Case 3: Invalid Address - prescription1 should not be added");
        assertFalse(prescription2.addPrescription(), "Test Case 3: Invalid Address - prescription2 should not be added");
    }

    // Test Case 4: Test the addPrescription function with valid Axis values
    @Test
    void testAddPrescriptionAxisValidValues() throws ParseException {
        // Create valid date format
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");

        // Test Data 1: Valid Axis value of 0 (just at lower boundary)
        Prescription prescription1 = new Prescription(7, "David", "Leen", 
            "1234 Oak St, City, 2000, Country", 2.5f, 0.00f, -2.0f, 
            dateFormat.parse("12/10/23"), "Dr. Jonathan");

        // Test Data 2: Valid Axis value of 180 (just at upper boundary)
        Prescription prescription2 = new Prescription(8, "David", "Leen", 
            "1234 Oak St, City, 2000, Country", 2.5f, 180f, -2.0f, 
            dateFormat.parse("12/10/23"), "Dr. Jonathan");

        // Assert that both prescriptions are successfully added
        assertTrue(prescription1.addPrescription(), "Test Case 4: Valid Axis - prescription1 should be added");
        assertTrue(prescription2.addPrescription(), "Test Case 4: Valid Axis - prescription2 should be added");
    }

    // Test Case 5: Test the addPrescription function with invalid Axis, Sphere and Cylinder values
    @Test
    void testAddPrescriptionAxisInvalidValues() throws ParseException {
        // Create valid date format
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");

        // Test Data 1: invalid Axis, Sphere and Cylinder values (just below lower boundary)
        Prescription prescription1 = new Prescription(9, "David", "Leen", 
            "1234 Oak St, City, 2000, Country", -21.0f, -1.0f, -5.0f, 
            dateFormat.parse("12/10/23"), "Dr. Jonathan");

        // Test Data 2: invalid Axis, Sphere and Cylinder values (just above upper boundary)
        Prescription prescription2 = new Prescription(10, "David", "Leen", 
            "1234 Oak St, City, 2000, Country", 21.0f, 181.0f, 5.0f, 
            dateFormat.parse("12/10/23"), "Dr. Jonathan");

        // Assert that both prescriptions are not added
        assertFalse(prescription1.addPrescription(), "Test Case 5: Valid Axis - prescription1 should be added");
        assertFalse(prescription2.addPrescription(), "Test Case 5: Valid Axis - prescription2 should be added");
    }



        // Test Case 6: Test the addPrescription function with all valid values to see if a fully valid prescription can be added
    @Test
    void testAddPrescriptionValidCylinderValues() throws ParseException {
        // Create valid date format
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");

        // Test Data 1: All Valid data, including Cylinder value at the lower boundary (-4.00)
        Prescription prescription1 = new Prescription(11, "Fallah", "David", 
            "1234 Oak St, City, 2000, Country", -2.0f, 90f, -4.0f, 
            dateFormat.parse("12/10/23"), "Dr. Jonathan");

        // Test Data 2: All Valid data, including Valid Cylinder value at the upper boundary (+4.00)
        Prescription prescription2 = new Prescription(12, "Fallah", "David", 
            "1234 Oak St, City, 2000, Country", 2.0f, 90f, 4.0f, 
            dateFormat.parse("12/10/23"), "Dr. Jonathan");

        // Assert that both prescriptions are successfully added
        assertTrue(prescription1.addPrescription(), "Test Case 6: Valid Cylinder - prescription1 should be added");
        assertTrue(prescription2.addPrescription(), "Test Case 6: Valid Cylinder - prescription2 should be added");
    }


}
