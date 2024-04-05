import java.util.Random;
import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);

    // Wheel Spin Function
    public static int[] randomArray(int size) {
        Random random = new Random();
        int[] a = new int[size];
        for (int i = 0; i < a.length; i++) {
            a[i] = random.nextInt(100);
        }
        return a;
    }
    public static int solver(String fullPhrase, String partialPhrase, int guesses){
        System.out.println(partialPhrase);
        System.out.println("Please enter your guess for full phrase:");
        String choice = scan.nextLine();
        if (choice.equalsIgnoreCase(fullPhrase)) {
            return 1;
        } else if (guesses > 0) {
            return 2;
        } else {
            return 3;
        }


    }
    public static void main(String[] args) {
        //activates functions for category and phrase
        System.out.println("Welcome to wheel of fortune!");
        int guesses = 2;
        boolean flag = true;
        while (flag) {
            int winState = solver("oh yeah", "oh ____", guesses);
            if (winState == 1) {
                System.out.println("You Win!");
                flag = false;
            } else if (winState == 2) {
                System.out.println("Incorrect, Try Again!");
                guesses = guesses - 1;
            } else if (winState == 3) {
                System.out.println("You Lose!");
                flag = false;
            }
        }
    }
}