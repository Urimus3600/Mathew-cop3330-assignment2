/**
 * UCF COP3330 Fall 2021 Assignment 2 Solution
 * Copyright 2021 Austin Mathew
 */

package ex24;

import java.util.Locale;
import java.util.Scanner;

public class App {

    public static boolean isAnagram(String first, String second){
        int x = first.length();
        int y = second.length();
        if(x != y){
            return false;
        }
        int counter=0;
        boolean[] used= new boolean[20];

        for(int i=0; i<x; i++){
            char hold = first.charAt(i);

            for(int j=0; j<y; j++){
                if(hold == second.charAt(j) && !used[j]){
                    counter++;
                    used[j] = true;
                }
            }
        }
        return counter == x;
    }

    public static void main(String[] args){

        Scanner input = new Scanner(System.in);

        System.out.print("Enter two strings and I'll tell you if they're anagrams:\n");
        System.out.print("Enter the first string: ");
        String First = input.next();
        String first = First.toLowerCase(Locale.ROOT);
        System.out.print("Enter the second string: ");
        String Second = input.next();
        String second = Second.toLowerCase(Locale.ROOT);

        if(isAnagram(first, second)){
            System.out.print("\""+ First + "\" and \"" + Second + "\" are anagrams.");
        }
        else{
            System.out.print("\""+ First + "\" and \"" + Second + "\" are not anagrams.");
        }

    }


}
