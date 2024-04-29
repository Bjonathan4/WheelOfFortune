import java.util.*;

public class PhraseGenerator {
    private static final Map<String, List<String>> categoriesAndPhrases = new HashMap<>();

    static {
        categoriesAndPhrases.put("Movie", Arrays.asList("The Godfather", "The Shawshank Redemption", "Forrest Gump"));
        categoriesAndPhrases.put("Song", Arrays.asList("Bohemian Rhapsody", "Imagine", "Hey Jude"));
        categoriesAndPhrases.put("Country", Arrays.asList("United States", "Canada", "Australia"));
    }

    public String[] generateCategoryAndPhrase() {
        Random random = new Random();
        List<String> categories = new ArrayList<>(categoriesAndPhrases.keySet());
        String randomCategory = categories.get(random.nextInt(categories.size()));
        List<String> phrases = categoriesAndPhrases.get(randomCategory);
        String randomPhrase = phrases.get(random.nextInt(phrases.size()));
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
