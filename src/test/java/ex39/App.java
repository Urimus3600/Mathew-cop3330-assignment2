/**
 * UCF COP3330 Fall 2021 Assignment 2 Solution
 * Copyright 2021 Austin Mathew
 */

package ex39;

public class App {
    public static void main(String[] args) {
        Employee[] employees = new Employee[6];
        employees[0] = new Employee("John", "Johnson", "Manager", "2016-12-31");
        employees[1] = new Employee("Tou", "Xiong", "Software Engineer", "2016-10-05");
        employees[2] = new Employee("Michaela", "Michaelson", "District Manager", "2015-12-19");
        employees[3] = new Employee("Jake","Jacobson","Programmer","");
        employees[4] = new Employee("Jacquelyn","Jackson","DBA","");
        employees[5] = new Employee("Sally","Webber","Web Developer","2015-12-18");
        sortByLast(employees);
        tableMaker(employees);
    }

    private static void tableMaker(Employee[] employees) {
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

    private static void sortByLast(Employee[] employees) {
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
