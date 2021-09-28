/**
 * UCF COP3330 Fall 2021 Assignment 2 Solution
 * Copyright 2021 Austin Mathew
 */

package ex38;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a list of numbers, separated by spaces: ");
        String numbers = input.nextLine();
        ArrayList<Integer> values = new ArrayList<Integer>();
        ArrayList<Integer> evens = new ArrayList<Integer>();
        convertStrToArray(values, numbers);
        sortEvens(evens, values);
        System.out.print("The even numbers are");
        for (Integer even : evens) {
            System.out.printf(" %d", even);
        }
        System.out.print(".");
    }

    private static void sortEvens(ArrayList<Integer> evens, ArrayList<Integer> values) {
        for(int i=0; i<values.size(); i++){
            if((values.get(i)%2) == 0)
                evens.add(values.get(i));
        }
    }

    private static void convertStrToArray(ArrayList<Integer> values, String numbers) {
        int hold=0;
        int len = numbers.length();
        for(int i=0; i<len; i++){
            if(numbers.charAt(i)>='0' && numbers.charAt(i)<='9'){
                hold*=10;
                hold +=(int) numbers.charAt(i) - 48;
            }
            else{
                values.add(hold);
                hold = 0;
            }
        }
        values.add(hold);
    }
}
