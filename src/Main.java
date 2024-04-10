import java.util.Random;
import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);

    public static int wheelSpin() {
        Random random = new Random();
        int spin = random.nextInt(24);
        switch (spin) {
            case 0: case 1: case 2:
                return -1;
            case 3: case 4: case 5: case 6:
                return 500;
            case 7: case 8:
                return 550;
            case 9: case 10: case 11: case 12:
                return 600;
            case 13: case 14: case 15:
                return 650;
            case 16: case 17: case 18:
                return 700;
            case 19: case 20:
                return 800;
            case 21: case 22:
                return 900;
            case 23:
                return 2500;

        }
        return spin;
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
            int spinVal = wheelSpin();
            if (spinVal == -1) {
                System.out.println("Lose a turn");
                System.out.println();
            } else {
                System.out.println(spinVal);
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
}