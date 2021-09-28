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
    public static void tableMaker(Employee[] employees) {
        System.out.printf("%-20s| %-19s| %-15s\n", "Name","Position", "Separation Date");
        for(int i=0; i<20; i++){
            System.out.print("-");
        }
        System.out.print("|");
        for(int i=0; i<20; i++)
            System.out.print("-");

        System.out.print("|");
        for(int i=0; i<16; i++){
            System.out.print("-");
        }
        System.out.println();
        for (int i = 0, employeesLength = employees.length; i < employeesLength; i++) {
            Employee employee = employees[i];
            String name = employee.getFirstName() + " " + employee.getLastName();
            System.out.printf("%-20s| %-19s| %-15s\n", name, employee.getPosition(), employee.getDate());
        }
    }

    public static void sortByLast(Employee[] employees) {
        Employee hold;
        int len = employees.length;
        int place=0;
        for(int i=0; i<len; i++){
            for(int j=0;j<len-1; j++){
                if(employees[j].getLastName().charAt(place) > employees[j+1].getLastName().charAt(place)){
                    hold = employees[j];
                    employees[j]=employees[j+1];
                    employees[j+1]=hold;
                    place=0;
                }
                else if(employees[j].getLastName().charAt(place) == employees[j+1].getLastName().charAt(place)){
                    j--;
                    place++;
                }
            }
        }
    }
}
