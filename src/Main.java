public class Main {
    public static void main(String[] args) {
        PhraseGenerator phraseGenerator = new PhraseGenerator();

        // Generate a random category and phrase
        String[] categoryAndPhrase = phraseGenerator.generateCategoryAndPhrase();
        String category = categoryAndPhrase[0];
        String phrase = categoryAndPhrase[1];

        System.out.println("Category: " + category);
        System.out.println("Phrase: " + phrase);

        // Generate blank squares corresponding to number of letters per word
        String blankPhrase = phraseGenerator.generateBlankPhrase(phrase);

        System.out.println("Blank Phrase: " + blankPhrase);
    }
}