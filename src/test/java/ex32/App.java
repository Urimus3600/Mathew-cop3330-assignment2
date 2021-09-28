/**
 * UCF COP3330 Fall 2021 Assignment 2 Solution
 * Copyright 2021 Austin Mathew
 */

package ex32;

import java.util.Locale;
import java.util.Scanner;
import java.lang.Math;
import java.util.Random;

public class App {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();
        int guess=0, value=0;
        char ans;
        System.out.println("Let's Play Guess a Number!");
        do {
            boolean valid;
            String sizeNum;
            do{
            System.out.print("Enter the difficulty leve (1, 2, or 3): ");
            sizeNum = input.next();
            valid = checker(sizeNum);
            if (valid) {
                System.out.println("Please enter a number.");
            }
            }while(valid);

            int size = (int) Math.pow(10,strToInt(sizeNum));

            value = rand.nextInt(size)+1;
            int tries =0;
            System.out.print("I've got my number what's your guess? ");

            while(guess!=value){
                tries++;
                String Guess = input.next();
                valid = checker(Guess);
                if(!valid){
                    guess = strToInt(Guess);
                    if(guess > value){
                        System.out.print("Too high. ");
                    }
                    else if(guess < value){
                        System.out.print("Too low. ");
                    }
                }
                if(guess!=value){
                    System.out.print("Guess again: ");
                }
            }
            System.out.printf("You got it in %d guesses!\n\n", tries);
            System.out.print("Do you wish to play again (Y/N)? ");
            ans = input.next().toUpperCase(Locale.ROOT).charAt(0);
        }while(ans=='Y');
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
