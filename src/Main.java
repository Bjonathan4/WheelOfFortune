import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;


public class Main {
    static Scanner scan = new Scanner(System.in);
    static PhraseGeneration phraseGeneration = new PhraseGeneration();
    static List<Character> vowelList() {
        List<Character> vowels = new ArrayList<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        return vowels;
    }

    public static String letterChoice(int userScore) {
        while (true) {
            System.out.println("Would you like to guess a consonant or vowel? (enter c or v): ");
            String choice = scan.nextLine();
            if (choice.toLowerCase().startsWith("c")) {
                return choice;
            } else if (choice.toLowerCase().startsWith("v")) {
                if (userScore < 250){
                    System.out.println("Error: not enough money to buy a vowel");
                } else {
                    return choice;
                }
            } else {
                System.out.println("error, c or v not seen. Please try again");
            }
        }
    }

    public static char guessLetter(String choice){
        List<Character> vowels = vowelList();
        while (true) {
            if (choice.toLowerCase().startsWith("c")){
                System.out.println("Please enter a consonant");
                char letter = scan.next().charAt(0);
                if (!vowels.contains(letter)){
                    return letter;
                } else {
                    System.out.println("Error, incorrect letter type, try again!");
                }
            } else if (choice.toLowerCase().startsWith("v")){
                System.out.println("Please enter a vowel");
                char letter = scan.next().charAt(0);
                if (vowels.contains(letter)){
                    return letter;
                } else{
                    System.out.println("Error, incorrect letter type, try again!");
                }
            }
        }
    }

    public static int solver(String fullPhrase, String partialPhrase, int guesses) {
        System.out.println(partialPhrase);
        scan.nextLine();
        System.out.println("Would you like to Solve? (y or n)");
        String solving = scan.nextLine();
        if (solving.toLowerCase().startsWith("y")) {
            System.out.println("Please enter your guess for full phrase:");
            String choice = scan.nextLine();
            if (choice.equalsIgnoreCase(fullPhrase)) {
                return 1;
            } else if (guesses > 0) {
                return 2;
            } else {
                return 3;
            }
        } else {
            return 4;
        }
    }

    public static void main(String[] args) {
        //activates functions for category and phrase
        System.out.println("Welcome to Wheel of Fortune!");
        String fullPhrase = phraseGeneration.generateCategoryAndPhrase();
        String partialPhrase = phraseGeneration.generateBlankPhrase(fullPhrase);
        System.out.println(partialPhrase);
        int userScore = 0;
        int guesses = 2;
        boolean flag = true;
        while (flag) {
            String choice = letterChoice(userScore);
            if (choice.equalsIgnoreCase("c")){
                int spinVal = WheelSpin.wheelVal();
                if (spinVal == -1) {
                    // Bankrupt spin: resets userScore to 0
                    System.out.println("Bankrupt!");
                    userScore = 0;
                    System.out.println("Current score: $0");
                    scan.nextLine();
                    System.out.println("\n\n\n\n\n\n\n");
                } else {
                    System.out.println("$" + spinVal);
                    char letter = guessLetter(choice);
                    partialPhrase = BoardUpdate.boardUpdate(letter, partialPhrase,fullPhrase);
                    userScore = BoardUpdate.scoreUpdate(spinVal, userScore, letter, fullPhrase);
                    int winState = solver(fullPhrase, partialPhrase, guesses);
                    if (winState == 1) {
                        System.out.println("You Win!");
                        flag = false;
                    } else if (winState == 2) {
                        System.out.println("Incorrect, Try Again!");
                        guesses = guesses - 1;
                    } else if (winState == 3) {
                        System.out.println("You Lose!");
                        flag = false;
                    } else if (winState == 4){
                        System.out.println("Next Round!");
                    }
                }
            } else {
                char letter = guessLetter(choice);
                partialPhrase = BoardUpdate.boardUpdate(letter, partialPhrase,fullPhrase);
                userScore = BoardUpdate.scoreUpdate(0, userScore, letter, fullPhrase);
                int winState = solver(fullPhrase, partialPhrase, guesses);
                if (winState == 1) {
                    System.out.println("You Win!");
                    flag = false;
                } else if (winState == 2) {
                    System.out.println("Incorrect, Try Again!");
                    guesses = guesses - 1;
                } else if (winState == 3) {
                    System.out.println("You Lose!");
                    flag = false;
                } else if (winState == 4) {
                    System.out.println("Next Round!");
                }
            }
        }
    }
}