/**
 * UCF COP3330 Fall 2021 Assignment 2 Solution
 * Copyright 2021 Austin Mathew
 */

package ex37;

import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String alpha = alphabet();
        String num = numbers();
        String special = specialChar();
        String password = "";
        System.out.print("What's the minimum length? ");
        int let = input.nextInt();
        System.out.print("How many special characters? ");
        int spec = input.nextInt();
        System.out.print("How many numbers? ");
        int dig = input.nextInt();
        if(let<((spec+dig)*2)){
            let = spec+dig;
        }
        else{
            let = let - spec - dig;
        }
        password += randomAddLetters(let, alpha);
        password += randomAdd(spec, special, 32);
        password += randomAdd(dig, num, 10);

        password = mix(password);

        System.out.println("Your password is " + password);

    }

    private static String mix(String password) {
        String passwordMix= "";
        Random rand = new Random();
        int len = password.length();
        boolean[] used = new boolean[len];
        for(int i=0; i< len; i++){
            String useful = "";
            int start=0;
            for(int j=0; j<len; j++) {
                if (!used[j]) {
                    useful += password.charAt(j);
                }
            }
            int hold = rand.nextInt(useful.length());
            passwordMix += useful.charAt(hold);
            for(int j=0; j< len; j++){
                if(password.charAt(j) == useful.charAt(hold)){
                    used[j]= true;
                }
            }
            }
        return passwordMix;
    }

    private static String randomAdd(int num, String special, int numOf ) {
        Random rand = new Random();
        String password = "";
        for (int i = 0; i < num; i++){
                password += special.charAt(rand.nextInt(numOf));
            }
        return password;
    }

    private static String randomAddLetters(int let, String alpha) {
        Random rand = new Random();
        String password= "";
        for (int i = 0; i < let; i++){
            if(rand.nextBoolean()){
                password += alpha.toLowerCase(Locale.ROOT).charAt(rand.nextInt(26));
            }
            else{
                password += alpha.charAt(rand.nextInt(26));
            }
        }
        return password;
    }

    private static String specialChar() {
        String special = "";
        for(int i=33; i<127; i++){
            if(i<48 || (i>57 && i<65) || (i>90 && i<97) || i>122){
                special += (char) i;
            }

        }
        return special;
    }

    private static String numbers() {
        String num = "";
        for(int i =0; i<10; i++){
            num += i;
        }
        return num;
    }

    private static String alphabet() {
        String alpha = "";
        for(int i = 65; i<91; i++){
            alpha += (char) i;
        }
        return alpha;
    }
}


