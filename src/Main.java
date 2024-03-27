import java.util.*;

public class Main {
    private static final Map<String, List<String>> categoriesAndPhrases = new HashMap<>();

    // Initialize categories and phrases
    static {
        categoriesAndPhrases.put("Movie", Arrays.asList("The Godfather", "The Shawshank Redemption", "Forrest Gump"));
        categoriesAndPhrases.put("Song", Arrays.asList("Bohemian Rhapsody", "Imagine", "Hey Jude"));
        categoriesAndPhrases.put("Country", Arrays.asList("United States", "Canada", "Australia"));
        // Add more categories and phrases as needed
    }

    public static void main(String[] args) {
        // Generate a random category and phrase
        String[] categoryAndPhrase = generateCategoryAndPhrase();
        String category = categoryAndPhrase[0];
        String phrase = categoryAndPhrase[1];

        System.out.println("Category: " + category);
        System.out.println("Phrase: " + phrase);

        // Generate blank squares corresponding to number of letters per word
        String blankPhrase = generateBlankPhrase(phrase);

        System.out.println("Blank Phrase: " + blankPhrase);
    }

    // Function to generate a random category and phrase
    public static String[] generateCategoryAndPhrase() {
        Random random = new Random();
        List<String> categories = new ArrayList<>(categoriesAndPhrases.keySet());
        String randomCategory = categories.get(random.nextInt(categories.size()));
        List<String> phrases = categoriesAndPhrases.get(randomCategory);
        String randomPhrase = phrases.get(random.nextInt(phrases.size()));
        return new String[]{randomCategory, randomPhrase};
    }

    // Function to generate blank squares corresponding to number of letters per word
    public static String generateBlankPhrase(String phrase) {
        StringBuilder blankPhraseBuilder = new StringBuilder();
        for (char c : phrase.toCharArray()) {
            if (Character.isLetter(c)) {
                blankPhraseBuilder.append("_");
            } else if (Character.isWhitespace(c)) {
                blankPhraseBuilder.append(" ");
            } else {
                blankPhraseBuilder.append(c);
            }
        }
        return blankPhraseBuilder.toString();
    }
}