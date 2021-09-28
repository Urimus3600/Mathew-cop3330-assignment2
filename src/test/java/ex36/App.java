/**
 * UCF COP3330 Fall 2021 Assignment 2 Solution
 * Copyright 2021 Austin Mathew
 */

package ex36;

import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Math;

public class App {
    public static void main(String[] args) {
        ArrayList<Double> values = new ArrayList<Double>();

        int elements = fillArray(values);

        double avg = average(values, elements);
        double min = minimum(values, elements);
        double max = maximum(values, elements);
        double std = standardDev( avg, values, elements);

        output(avg, min, max, std, values, elements);
    }

    private static void output(double avg, double min, double max, double std, ArrayList<Double> values, int elements) {
        System.out.printf("Numbers: " + values.get(0));
        for(int i=1; i<elements; i++) {
            System.out.print(", " + values.get(i));
        }
        System.out.println();
        System.out.println("The average is " + avg);
        System.out.println("The minimum is "+ min);
        System.out.println("The maximum is "+ max);
        System.out.printf("The standard deviation is " + (Math.round(std*100)/100.0));
    }

    private static double standardDev(double avg, ArrayList<Double> values, int elements) {
        double sumDiff=0;
        for(int i=0; i<elements; i++){
            sumDiff += Math.pow((values.get(i)-avg),2);
        }
        sumDiff /= elements;
        sumDiff = Math.sqrt(sumDiff);
        return sumDiff;
    }

    private static double maximum(ArrayList<Double> values, int elements) {
        double max= values.get(0);
        for(int i=1;i<elements;i++){
            if(max<values.get(i))
                max = values.get(i);
        }
        return max;
    }

    private static double minimum(ArrayList<Double> values, int elements) {
        double min= values.get(0);
        for(int i=1;i<elements;i++){
            if(min>values.get(i))
                min = values.get(i);
        }
        return min;
    }

    private static double average(ArrayList<Double> values, int elements) {
        double avg = 0;
        for(int i=0; i<elements; i++){
            avg += values.get(i);
        }
        return avg/ (double) elements;
    }

    private static int fillArray(ArrayList<Double> values) {
        Scanner input = new Scanner(System.in);
        int elements=0;
        String name="";
        boolean valid;
        while(!name.equals("done")){
            System.out.print("Enter a number: ");
            name = input.nextLine();
            valid = checker(name);
            if(!valid){
                int hold = strToInt(name);
                if(hold>=0){
                    values.add((double) hold);
                    elements++;
                }
                else{
                    System.out.println("Number cannot be negative.");
                }
            }
        }
        return elements;
    }

    private static int strToInt(String num) {
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
        if(valid && !num.equals("done")){
            System.out.println("Sorry. That's not a valid input.");
        }
        return valid;
    }
}
