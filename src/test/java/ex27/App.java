/**
 * UCF COP3330 Fall 2021 Assignment 2 Solution
 * Copyright 2021 Austin Mathew
 */

package ex27;

import java.util.Scanner;

public class App {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the first name: ");
        String firstName = input.nextLine();
        System.out.print("Enter the last name: ");
        String lastName = input.nextLine();
        System.out.print("Enter ZIP code: ");
        String zip = input.next();
        System.out.print("Enter the employee ID: ");
        String employeeID = input.next();

        Employee employee = new Employee(firstName, lastName, zip, employeeID);

        String output = employee.validateInput(employee);

        System.out.print(output);

    }

}
