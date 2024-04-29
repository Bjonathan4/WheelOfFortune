import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);

    public static void updateBoard(int spinVal, int userScore, char letter,
                                   String partialPhrase, String fullPhrase) {
        int charCount = 0;
        //String[] fullPhraseArray = {};
        for (int i = 0; i < fullPhrase.length(); i++) {
            if (fullPhrase.indexOf(letter) == letter) {

            }
        }
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
        int userScore = 0;
        int guesses = 2;
        boolean flag = true;
        while (flag) {
            int spinVal = Randomization.wheelVal();
            if (spinVal == -1) {
                System.out.println("Bankrupt!");
                userScore = 0;
                System.out.println("Current score: $0");
                scan.nextLine();
                System.out.println("\n\n\n\n\n\n\n");
            } else {
                System.out.println("$" + spinVal);
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