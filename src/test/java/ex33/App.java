package ex33;

import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Random rand = new Random();
        Scanner input = new Scanner(System.in);
        System.out.print("What's your question?\n>");
        String ans = input.nextLine();
        System.out.println("");
        switch (rand.nextInt(4)){
            case 0:
                System.out.println("Yes");
                break;
            case 1:
                System.out.println("No");
                break;
            case 2:
                System.out.println("Maybe");
                break;
            case 3:
                System.out.println("Ask again later.");
                break;
        }
    }
}
