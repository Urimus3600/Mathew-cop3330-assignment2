package ex30;

public class App {
    public static void main(String[] args) {
        for(int i=1; i<13; i++){
            for(int j=1; j<13; j++){
                System.out.printf("%5d", j*i);
            }
            System.out.println("");
        }
    }
}
