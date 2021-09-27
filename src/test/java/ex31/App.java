/**
 * UCF COP3330 Fall 2021 Assignment 2 Solution
 * Copyright 2021 Austin Mathew
 */

package ex31;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        boolean valid;
        String Beat,Age;
        int beat=0, age=0;
        do {
            valid = false;
            System.out.print("Enter your Resting Pulse: ");
            Beat = input.next();
            valid = checker(Beat);

            if(!valid){
                beat = strToInt(Beat);
                if(beat<=0){
                    valid = true;
                }
            }
            if(valid){
                System.out.println("Please enter a valid pulse.");
            }
        }while(valid);

        do {
            valid = false;
            System.out.print("Enter your Age: ");
            Age = input.next();
            valid = checker(Age);

            if(!valid){
                age = strToInt(Age);
                if(age<=0){
                    valid = true;
                }
            }
            if(valid){
                System.out.println("Please enter a valid age.");
            }
        }while(valid);

        tableMaker(beat,age);


    }

    private static void tableMaker(int beat, int age) {
        System.out.printf("Resting Pulse: %d    Age: %d\n", beat, age);
        System.out.printf("%-13s| %-7s\n", "Intensity", "Rate");
        for(int i=0; i<13; i++) System.out.print("_");
        System.out.print("|");
        for(int i=0; i<8; i++) System.out.print("_");
        System.out.println("");
        for(int i=55; i<100; i+=5){
            System.out.printf("%d%-11s| %-4dbpm\n",i,"%", karvonen(i,age,beat));
        }
    }

    private static int karvonen(int intensity, int age, int beat){
        double i = intensity/100.0;
        return (int) Math.round((((220-age)-beat)*i)+beat);
    }

    private static boolean checker(String num){
        boolean valid = false;
        int len = num.length();
        for(int i=0; i<len; i++)
            if (num.charAt(i) < 48 || num.charAt(i) > 57) {
                valid = true;
                break;
            }
        return valid;
    }

    private static int strToInt(String num) {
        int r = 0;
        for(int i=0; i<num.length(); i++){
            r*=10;
            r+= num.charAt(i)-48;
        }
        return r;
    }
}
