/**
 * UCF COP3330 Fall 2021 Assignment 2 Solution
 * Copyright 2021 Austin Mathew
 */

package ex35;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();

        ArrayList<String> names = new ArrayList<String>();

        int counter=0;
        String name;
        do{
            System.out.print("Enter a name: ");
            name = input.nextLine();
            if(!name.equals(""))
                names.add(name);
            counter++;
        }while(!name.equals(""));

        int winner = rand.nextInt(counter-1);
        System.out.println("The winner is... " + names.get(winner) + ".");
    }
}
