import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;


public class Main {
    static Scanner scan = new Scanner(System.in);
    static PhraseGeneration phraseGeneration = new PhraseGeneration();

    /**
     * Generates a list of all vowels
     * @return List of char's of all vowels
     */
    static List<Character> vowelList() {
        List<Character> vowels = new ArrayList<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        return vowels;
    }

    /**
     * asks user if they want to guess a consonant or buy a vowel
     * @param userScore int of player's current score
     * @return string of choice, either a c or a v
     */
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

    /**
     * allows the user to guess a letter
     * @param choice string of choice from letter choice, either c or v
     * @return char of their guessed letter
     */
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

    /**
     * Allows a user to attempt to solve the puzzle based off what has been revealed so far
     * @param fullPhrase String of the Full Phrase
     * @param partialPhrase String of the partial phrase
     * @param guesses an int of remaining guesses
     * @return int of the win state (1, 2, 3, or 4)
     */
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

    /**
     * Writes the user's score to a file
     * @param scoreFile String of the file path
     * @param userScore int of the user's score
     */
    public static void scoreWriter(String scoreFile, int userScore){
        String score = "Your Score was: $" + userScore;
        try {
            Files.write(Paths.get(scoreFile), score.getBytes());
        } catch (IOException ex) {
            System.out.println("File cannot be opened for writing!");
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
        String scoreFile = "data/score.txt";
        boolean flag = true;
        while (flag) {
            String choice = letterChoice(userScore);
            if (choice.equalsIgnoreCase("c")){
                //consonant version of the loop
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
                    // if statement continues game based off result of solver
                    if (winState == 1) {
                        System.out.println("You Win!");
                        scoreWriter(scoreFile, userScore);
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
                // Vowel version of the loop
                char letter = guessLetter(choice);
                partialPhrase = BoardUpdate.boardUpdate(letter, partialPhrase,fullPhrase);
                userScore = BoardUpdate.scoreUpdate(0, userScore, letter, fullPhrase);
                int winState = solver(fullPhrase, partialPhrase, guesses);
                // if statement continues game based off result of solver
                if (winState == 1) {
                    System.out.println("You Win!");
                    scoreWriter(scoreFile, userScore);
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