/**
 * UCF COP3330 Fall 2021 Assignment 2 Solution
 * Copyright 2021 Austin Mathew
 */
package ex26;

import java.util.Scanner;
import java.lang.Math;


public class App {

    public static int payOff(double b, double i, double p){
        i /= 36500;
        return (int) Math.ceil(-(1.0/30.0) * Math.log(1 + b/p * (1 - Math.pow(1 + i, 30))) / Math.log(1 + i));

    }

    public static void main(String[] args){

        Scanner input = new Scanner(System.in);
        System.out.print("What is your balance? ");
        double balance = input.nextDouble();
        System.out.print("What is the APR on the card (as a percent)? ");
        double APR = input.nextDouble();
        System.out.print("What is the monthly payment you can make? ");
        double monthPay = input.nextDouble();

        int months = payOff(balance, APR, monthPay);

        System.out.print("It will take you "+ months +" months to pay off this card.");

    }

}
