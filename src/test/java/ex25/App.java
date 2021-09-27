/**
 * UCF COP3330 Fall 2021 Assignment 2 Solution
 * Copyright 2021 Austin Mathew
 */

package ex25;

import java.util.Scanner;

public class App {

    public static int passwordValidator(String password){
        int charNum=0, numNum=0, specialNum=0;
        int len = password.length();
        for(int i=0; i<len; i++){
            char hold = password.charAt(i);
            if(hold>47 && hold< 58){
                numNum++;
            }
            else if((hold>64 && hold<91) || (hold>96 && hold<123)){
                charNum++;
            }
            else{
                specialNum++;
            }
        }
        if((charNum>0) && (numNum>0) && (specialNum>0) && (len>7)){
            return 5;
        }
        else if(charNum>0 && numNum>0 && len>7){
            return 4;
        }
        else if(charNum>0 && numNum==0 && specialNum==0 && len<8){
            return 2;
        }
        else if(charNum==0 && numNum>0 && specialNum==0 && len<8){
            return 1;
        }
        else{
            return 3;
        }
    }
    public static void main(String[] args){
        String password;
        Scanner input = new Scanner(System.in);

        do{
            password = input.next();
            int strength;
            if(password.length()>0) {
                strength = passwordValidator(password);

                String Strength = "";
                if (strength == 5) {
                    Strength = "very strong ";
                } else if (strength == 4) {
                    Strength = "strong ";
                } else if (strength == 3) {
                    Strength = "moderate ";
                } else if (strength == 2) {
                    Strength = "weak ";
                } else if (strength == 1) {
                    Strength = "very weak ";
                }
                System.out.println("The password '" + password + "' is a " + Strength + "password.\n");
            }
        }while(password.length()!=0);
    }
}
