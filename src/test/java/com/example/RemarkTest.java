package com.example;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class RemarkTest {
    
    // Create a sample prescription for testing
    Prescription prescription = new Prescription(1, "John", "Does", "Glasses", 
                                                 1.0f, 2.0f, 3.0f, new Date(0), "Dr. Smith");

    //Test Case 1: Test with valid remark length
    @Test
    public void testValidRemarkLength() {
    
        // Lower bound remark - 6 words
        assertTrue(prescription.addRemark("This is a valid remark test.", "client"));
    
        // Upper bound remark - 20 words
        assertTrue(prescription.addRemark("This is a long valid remark which includes exactly twenty words for testing purposes to ensure it works as expected.", "optometrist"));
    }



    //Test Case 2: Test with invalid remark length
    @Test
    public void testInvalidRemarkLength() {

        // Just under Lower bound remark - 5 words
        assertFalse(prescription.addRemark("Five words, not long enough.", "client"));

        // Just over Upper bound remark - 21 words
        assertFalse(prescription.addRemark("This remark has exactly twenty one words which makes it invalid as per the rules for adding remarks in the system.", "optometrist"));
    }



    //Test Case 3: Test for valid capital letter at the start of remark
    @Test
    public void testValidCapitalLetterAtStart() {

        // Valid capital letter at the start
        assertTrue(prescription.addRemark("This is considered a valid remark.", "client"));

        // Another valid remark with a capital letter
        assertTrue(prescription.addRemark("Valid remark again with capital start.", "optometrist"));
    }



    //Test Case 4: Test for no capital letter at the start (invalid)
    @Test
    public void testInvalidCapitalLetterAtStart() {

        // No capital letter at the start
        assertFalse(prescription.addRemark("this remark should not be valid.", "client"));

        // Another invalid remark without capital
        assertFalse(prescription.addRemark("remark not starting with capital letter.", "optometrist"));
    }

    //Test Case 5: Check for valid category
    @Test
    public void testValidCategory() {

        // Valid category: "client"
        assertTrue(prescription.addRemark("This is a valid remark for the client.", "client"));

        // Valid category: "optometrist"
        assertTrue(prescription.addRemark("This is a valid remark for the optometrist.", "optometrist"));
    }

    //Test Case 6: Test for invalid category
    @Test
    public void testInvalidCategory() {

        // Invalid category: "admin"
        assertFalse(prescription.addRemark("This is an invalid category remark.", "admin"));

        // Invalid category: "staff"
        assertFalse(prescription.addRemark("This is another invalid category remark.", "staff"));
    }

}