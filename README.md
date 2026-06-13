# Smart Exam System (OOP)

A console-based Smart Exam System developed in Java using Object-Oriented Programming principles and File Handling.

## Features

* Student Registration
* Student Login Authentication
* Multiple Choice Questions (MCQs)
* Automated Exam Conduct
* Negative Marking System
* Percentage-Based Grading
* One Attempt Per Student
* Result Storage and Retrieval
* Persistent Data Using Text Files

## Technologies Used

* Java
* Object-Oriented Programming (OOP)
* File Handling
* Collections Framework (ArrayList)
* Exception Handling

## Project Structure

```text
src/
├── User.java
├── Student.java
├── Question.java
├── Result.java
├── FileManager.java
├── AuthenticationService.java
├── ExamService.java
└── Main.java
```

## OOP Concepts Implemented

### Encapsulation

Private fields with public getters.

### Inheritance

Student class inherits from User.

### Abstraction

Services are separated into AuthenticationService and ExamService.

### Composition

Main class coordinates AuthenticationService, ExamService, and FileManager.

## Exam Rules

* Correct Answer = +4 Marks
* Wrong Answer = -5 Marks
* Skipped Question = 0 Marks
* Students can attempt the exam only once.
* Previous results are displayed if the student logs in again.

## UML Class Diagram

The UML diagram is available in the `diagrams` folder.

## Future Improvements

* Admin Panel
* Question Management Interface
* Database Integration
* Timer-Based Exams
* Randomized Question Order
* Exam Analytics Dashboard

## Huzaifa Imtiaz

Developed as an Object-Oriented Programming project in Java.
