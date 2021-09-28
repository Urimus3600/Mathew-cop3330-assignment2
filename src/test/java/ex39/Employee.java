/**
 * UCF COP3330 Fall 2021 Assignment 2 Solution
 * Copyright 2021 Austin Mathew
 */

package ex39;

public class Employee {
    private String firstName;
    private String lastName;
    private String position;
    private String date;

    Employee(String firstName, String lastName, String position, String date){
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.date = date;
    }

    public Employee() {
        firstName = "";
        lastName = "";
        position = "";
        date = "";
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getPosition() {
        return position;
    }

    public String getDate() {
        return date;
    }
}
