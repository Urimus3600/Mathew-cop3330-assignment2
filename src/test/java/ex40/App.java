/**
 * UCF COP3330 Fall 2021 Assignment 2 Solution
 * Copyright 2021 Austin Mathew
 */

package ex40;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Employee[] employees = new Employee[6];
        Employee[] searchResults = new Employee[6] ;
        employees[0] = new Employee("John", "Johnson", "Manager", "2016-12-31");
        employees[1] = new Employee("Tou", "Xiong", "Software Engineer", "2016-10-05");
        employees[2] = new Employee("Michaela", "Michaelson", "District Manager", "2015-12-19");
        employees[3] = new Employee("Jake","Jacobson","Programmer","");
        employees[4] = new Employee("Jacquelyn","Jackson","DBA","");
        employees[5] = new Employee("Sally","Webber","Web Developer","2015-12-18");

        System.out.print("Enter a search string: ");
        String search = input.next();
        int srchResultsLen = find(employees, search, searchResults);

        tableMaker(searchResults, srchResultsLen);

    }

    private static void tableMaker(Employee[] searchResults, int len) {
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
        for (int i = 0; i < len; i++) {
            Employee search = searchResults[i];
            String name = search.getFirstName() + " " + search.getLastName();
            System.out.printf("%-20s| %-19s| %-15s\n", name, search.getPosition(), search.getDate());
        }
    }

    public static int find(Employee[] employees, String search, Employee[] searchResults) {
        int counter=0;
        int lenEmploy = employees.length;
        int lenSrch = search.length();
        int place=0;
        for(int i=0; i<lenEmploy; i++ ){
            if(place == lenSrch){
                searchResults[counter++] = employees[i];
                place=0;
            }

            else if((employees[i].getLastName().charAt(place) == search.charAt(place)) || (employees[i].getFirstName().charAt(place) == search.charAt(place))) {
                i--;
                place++;
            }
            else{
                place = 0;
            }
        }

        return counter;
    }
}
