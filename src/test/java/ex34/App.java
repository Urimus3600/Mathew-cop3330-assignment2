package ex34;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] names = {"John Smith","Jackie Jackson","Chris Jones","Amanda Cullen","Jeremy Goodwin"};
        int nameNum = 5;

        printNames(nameNum, names);
        System.out.print("\nEnter an employee name to remove: ");
        String name = input.nextLine();
        System.out.println("");
        nameNum = removeName(nameNum, names, name);
        printNames(nameNum, names);
    }

    private static int removeName(int nameNum, String[] names, String name) {
        for(int i=0; i<nameNum; i++){
            if(names[i].equals(name)){
                names[i]="";
                nameNum--;
                for(int j=i; j<nameNum; j++){
                    names[j] = names[j+1];
                }
            }
        }
        return nameNum;
    }

    private static void printNames(int nameNum, String[] names){
        System.out.printf("There are %d employees:\n", nameNum);
        for(int i=0; i<nameNum; i++)
            System.out.println(names[i]);
    }
}
