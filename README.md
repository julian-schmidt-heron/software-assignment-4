# Software Assignment 4 — EyeClear (Individual)
I am Julian Schmidt-Heron, and am in my third year of my Bachelor of Data Science (Professional) degree at RMIT University.
s4002485 is my RMIT student GitHub account. Commits from that account represent my individual contributions (Julian Schmidt-Heron).

**Student:** Julian Schmidt-Heron (RMIT, s4002485)  
**Course:** Software Engineering Fundamentals
**Assessment:** Assignment 4 (Individual) — Unit tests, Java implementation, user stories, video demonstration  
**Grade:** 23 / 25

---

## Overview

This repository contains my individual submission for *Assignment 4* of Software Engineering Fundamentals at RMIT. The task was to implement and test two functions (`addPrescription` and `addRemark`) for the EyeClear website, write user stories + acceptance criteria, and produce a short demonstration video.

The purpose of the assignment was to practice:
- writing **unit tests** (JUnit 5) and test cases,  
- implementing small Java components with clear requirements,  
- using **Git/GitHub** for version control, and  
- producing a short recorded demo explaining the implementation and tests.

---

## What’s in this repo

- `src/main/java/com/example/Prescription.java` — Java implementation of the `Prescription` class with `addPrescription` and `addRemark`.  
- `src/test/java/com/example/PrescriptionTest.java` — JUnit test cases for `addPrescription`.  
- `src/test/java/com/example/RemarkTest.java` — JUnit test cases for `addRemark`.  
- `prescription.txt` — sample output file created by the program (shows added prescriptions).  
- `remark.txt` — sample output file for remarks.  
- `pom.xml` — Maven build file used for compiling and running tests.  
- `Assessment 4 (Individual).pdf` — the assignment report submitted (includes test case table, user stories, acceptance criteria, and explanation).  
- `Software Assignment 4.mp4` — 4-minute recorded demo (720p) showing:  
  - a 30s explanation and run-through of each function (`addPrescription` and `addRemark`),  
  - 30s explanation for unit tests for each function,  
  - a 1-minute run of the unit tests and the updated TXT files, and  
  - a 30s view showing the project on GitHub.  

---

## How to run locally

1. Clone the repo (or download ZIP) and open in your Java IDE (IntelliJ / Eclipse) or use command-line Maven:  
   ```bash
   mvn test
