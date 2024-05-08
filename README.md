import java.util.*;

public class PhraseGenerator {
    // Define a map to store categories (e.g., Movie, Song, Country) and corresponding phrases
    private static final Map<String, List<String>> categoriesAndPhrases = new HashMap<>();
    // Fill out the map with specified groups and the related phrases.
    static {
        categoriesAndPhrases.put("Movie", Arrays.asList("The Godfather", "The Shawshank Redemption", "Hotel Rwanda","The family plan"));
        categoriesAndPhrases.put("Song", Arrays.asList("like that", "Hot line bling", "Hello","Not like us "));
        categoriesAndPhrases.put("Country", Arrays.asList("United States", "Canada", "Rwanda","Kenya"));
    }
    //Method for creating a random category and phrase pair
    public String[] generateCategoryAndPhrase() {
        Random random = new Random();
        // Get all categories from the map
        List<String> categories = new ArrayList<>(categoriesAndPhrases.keySet());
        //Select a random category from the list of categories
        String randomCategory = categories.get(random.nextInt(categories.size()));
        //get the list of phrases associated with the randomly selected category
        List<String> phrases = categoriesAndPhrases.get(randomCategory);
        //Select a random phrase from the list of phrases associated with the selected category
        String randomPhrase = phrases.get(random.nextInt(phrases.size()));
        //Return the random category and phrase as an array
        return new String[]{randomCategory, randomPhrase};
    }

    public String generateBlankPhrase(String phrase) {
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
