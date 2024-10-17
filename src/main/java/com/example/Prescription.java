package com.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public final class Prescription {
    private final int prescID;
    private final String firstName;
    private final String lastName;
    private final String address;
    private final float sphere;
    private final float axis;
    private final float cylinder;
    private final Date examinationDate;
    private final String optometrist;
    private ArrayList<String> postRemarks = new ArrayList<>();

    // Constructor
    public Prescription(int prescID, String firstName, String lastName, String address, float sphere, 
                        float axis, float cylinder, Date examinationDate, String optometrist) {
        this.prescID = prescID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.sphere = sphere;
        this.axis = axis;
        this.cylinder = cylinder;
        this.examinationDate = examinationDate;
        this.optometrist = optometrist;
        this.postRemarks = new ArrayList<>(); // Initialize the remarks list
    }

    // Method to add a prescription
    @SuppressWarnings("CallToPrintStackTrace")
    public boolean addPrescription() {    
        if (!validatePrescription()) {
            return false;
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
        String formattedDate = dateFormat.format(examinationDate);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("prescription.txt", true))) {
            writer.write("Prescription ID: " + prescID + ", Name: " + firstName + " " + lastName + 
                         ", Address: " + address + ", Sphere: " + sphere + ", Axis: " + axis + 
                         ", Cylinder: " + cylinder + ", Examination Date: " + formattedDate + 
                         ", Optometrist: " + optometrist + "\n");
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

     
        // Validate prescription data before adding
    private boolean validatePrescription() {
        // Condition 1: First and Last Name should have a minimum of 4 characters and a maximum of 15 characters
        if (firstName == null || lastName == null || 
            firstName.length() < 4 || firstName.length() > 15 || 
            lastName.length() < 4 || lastName.length() > 15) {
            return false; // Name length requirement not met
        }

        // Condition 2: Address must have a minimum of 20 characters
        if (address == null || address.length() < 20) {
            return false; // Address length requirement not met
        }

        // Condition 3: Sphere must be between -20.00 and +20.00
        if (sphere < -20.00 || sphere > 20.00) {
            return false; // Sphere value requirement not met
        }

        // Condition 3: Cylinder must be between -4.00 and +4.00
        if (cylinder < -4.00 || cylinder > 4.00) {
            return false; // Cylinder value requirement not met
        }

        // Condition 3: Axis must be between 0 and 180
        if (axis < 0 || axis > 180) {
            return false; // Axis value requirement not met
        }

        // Condition 4: The examination date should be valid in DD/MM/YY format
        //This is handled in the "public boolean addPrescription()" method above

        // Condition 5: Optometrist's name should have a minimum of 8 characters and a maximum of 25 characters
        if (optometrist == null || optometrist.length() < 8 || optometrist.length() > 25) {
            return false; // Optometrist name length requirement not met
        }

        // All conditions met
        return true;
    }
    



    // Method to add a remark
    @SuppressWarnings("CallToPrintStackTrace")
    public boolean addRemark(String remark, String type) {
        if (!validateRemark(remark, type)) {
            return false;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("remark.txt", true))) {
            writer.write("Remark Type: " + type + ", Remark: " + remark + "\n");
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        postRemarks.add(remark);
        return true;
    }

    // Validate the remark before adding
    private boolean validateRemark(String remark, String type) {
        // Condition 1: Check if the remark text has a minimum of 6 words and a maximum of 20 words.
        String[] words = remark.trim().split("\\s+"); // Split the remark into words by spaces.
        if (words.length < 6 || words.length > 20) {
            return false; // Remark doesn't meet the word count criteria.
        }
    
        // Check if the first word's first character is an uppercase letter.
        if (!Character.isUpperCase(words[0].charAt(0))) {
            return false; // First character of the first word is not uppercase.
        }
    
        // Condition 2: Validate the type is either "client" or "optometrist".
        if (!type.equals("client") && !type.equals("optometrist")) {
            return false; // Type is not valid.
        }
        /*
        // Ensure that no more than 2 remarks exist for the prescription.
        if (((ArrayList<String>) this.remarks).size() >= 2) {
            return false; // Maximum of 2 remarks already added.
        }
        */
        return true; // All conditions are met.
    }
    

    public ArrayList<String> getPostRemarks() {
        return postRemarks;
    }
}
