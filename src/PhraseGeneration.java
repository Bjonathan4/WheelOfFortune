//This Class is written by Bravo Burora

import java.util.*;

public class PhraseGeneration {
    // Define a map to store categories (e.g., Movie, Song, Country) and corresponding phrases
    private static final Map<String, List<String>> categoriesAndPhrases = new HashMap<>();
    // Fill out the map with specified groups and the related phrases.
    static {
        categoriesAndPhrases.put("Movie", Arrays.asList("The Godfather", "The Shawshank Redemption", "Hotel Rwanda","The Family Plan"));
        categoriesAndPhrases.put("Song", Arrays.asList("Like That", "Hot Line Bling", "Hello","Not Like Us "));
        categoriesAndPhrases.put("Country", Arrays.asList("United States", "Canada", "Rwanda","Kenya"));
    }
    //Method for creating a random category and phrase pair
    public String generateCategoryAndPhrase() {
        Random random = new Random();
        // Get all categories from the map
        List<String> categories = new ArrayList<>(categoriesAndPhrases.keySet());
        //Select a random category from the list of categories
        String randomCategory = categories.get(random.nextInt(categories.size()));
        //get the list of phrases associated with the randomly selected category
        List<String> phrases = categoriesAndPhrases.get(randomCategory);
        //Select a random phrase from the list of phrases associated with the selected category
        String randomPhrase = phrases.get(random.nextInt(phrases.size()));
        System.out.println("Category: " + randomCategory);
        //Return the random category and phrase as an array
        return randomPhrase;
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
