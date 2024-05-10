import java.util.List;

public class BoardUpdate {

    /**
     * This function updates the board after every letter guess to reflect
     * the correct placements of the letter in question.
     * @param letter The letter guessed by the user
     * @param partialPhrase The incomplete version of fullPhrase
     * @param fullPhrase The completed puzzle
     * @return An updated version of partialPhrase with correctly guessed letters
     */
    public static String boardUpdate(char letter, String partialPhrase, String fullPhrase) {
        int charCount = 0;
        // Creates a copy of fullPhrase
        String newFullPhrase = fullPhrase.toLowerCase();
        // Creates an empty String
        String newPartialPhrase = "";
        // A string version of letter
        String letterString = String.valueOf(letter);

        // Iterates through newFullPhrase to reconstruct partialPhrase with new letters
        for (int i = 0; i < newFullPhrase.length(); i++) {
            char position = newFullPhrase.charAt(i);
            char partialPosition = partialPhrase.charAt(i);
            if (letter == position) {
                newPartialPhrase += letterString;
                charCount += 1;
            } else if (position == ' ') {
                newPartialPhrase += " ";
            } else if (partialPosition != '_' && partialPosition != ' ') {
                newPartialPhrase += partialPosition;
            } else {
                newPartialPhrase += "_";
            }
        }
        partialPhrase = newPartialPhrase;

        // Prints how many times the letter appeared; returns the new partialPhrase
        if (charCount == 1) {
            System.out.printf("There is %d %s.", charCount, letter);
        } else {
            System.out.printf("There are %d %s's.", charCount, letter);
        }
        return partialPhrase;
    }

    /**
     * Updates the user's score after a successful letter guess
     * @param spinVal The value of a random wheel spin
     * @param userScore The user's current score
     * @param letter The letter guessed by the user
     * @param fullPhrase The completed puzzle
     * @return The user's updated score
     */
    public static int scoreUpdate(int spinVal, int userScore, char letter, String fullPhrase) {
        List<Character> vowels = Main.vowelList();
        if (!vowels.contains(letter)) {
            // Score determination for consonants
            int charCount = 0;
            String newFullPhrase = fullPhrase.toLowerCase();
            for (int i = 0; i < newFullPhrase.length(); i++) {
                if (newFullPhrase.charAt(i) == letter) {
                    charCount += 1;
                }
            }
            userScore += (spinVal * charCount);
        } else {
            // Score determination for vowels
            userScore -= 250;
        }
    System.out.println();

    // Prints user's new score and returns it
    System.out.printf("Current Score: $%d", userScore);
    System.out.println();
    return userScore;
    }
}