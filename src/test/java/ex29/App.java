/**
 * UCF COP3330 Fall 2021 Assignment 2 Solution
 * Copyright 2021 Austin Mathew
 */

package ex29;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean valid;
        double rate=0.0;
        do{
            System.out.print("What is the rate of return? ");
            String num = input.next();
            valid = false;

                valid = checker(num);

            if(!valid){
                rate = strToDble(num);
                if(rate==0){
                    valid = true;
                    System.out.println("0 is not a viable rate of return.");
                }
            }
        }while(valid);

        int years = (int) Math.ceil(yearCalc(rate));

        System.out.printf("It will take %d years to double your initial investment.", years);

    }

    private static double yearCalc(double rate){
        return 72/rate;
    }

    private static double strToDble(String num) {
        int r = 0;
        for(int i=0; i<num.length(); i++){
            r*=10;
            r+= num.charAt(i)-48;
        }
        return r;
    }
    private static boolean checker(String num){
        boolean valid = false;
        int len = num.length();
        for(int i=0; i<len; i++)
            if (num.charAt(i) < 48 || num.charAt(i) > 57) {
                valid = true;
                break;
            }
        if(valid){
            System.out.println("Sorry. That's not a valid input.");
        }
        return valid;
    }

}
