import java.util.*;

public class Question4_ThreeMostCommon {

    // Find three most common words in a sentence, return them alphabetically
    public static String[] getThreeMostCommonWords(String sentence) {
        if (sentence == null || sentence.trim().length() == 0) {
            return new String[0];
        }

        // Split into words and count them
        String[] words = sentence.toLowerCase().split(" ");
        HashMap<String, Integer> counts = new HashMap<>();

        for (String word : words) {
            word = word.trim();
            if (!word.isEmpty()) {
                if (counts.containsKey(word)) {
                    counts.put(word, counts.get(word) + 1);
                } else {
                    counts.put(word, 1);
                }
            }
        }

        // Find the top 3 by frequency
        List<String> topWords = new ArrayList<>();

        // This is a bit hacky but works - find max 3 times
        for (int round = 0; round < 3; round++) {
            String maxWord = null;
            int maxCount = 0;

            for (String word : counts.keySet()) {
                if (!topWords.contains(word) && counts.get(word) > maxCount) {
                    maxCount = counts.get(word);
                    maxWord = word;
                }
            }

            if (maxWord != null) {
                topWords.add(maxWord);
            }
        }

        // Convert to array and sort alphabetically
        String[] result = topWords.toArray(new String[0]);
        Arrays.sort(result);

        return result;
    }

    public static void main(String[] args) {
        // Main test case
        String test1 = "hi there care to discuss algorithm basis or how to solve algorithm or";
        String[] result = getThreeMostCommonWords(test1);
        System.out.println("Result: " + Arrays.toString(result));
        System.out.println("Expected: [algorithm, or, to]");

        // Try another one
        String test2 = "the quick brown fox jumps over the lazy dog the";
        String[] result2 = getThreeMostCommonWords(test2);
        System.out.println("Test 2: " + Arrays.toString(result2));

        // Less than 3 words
        String test3 = "hello world hello";
        String[] result3 = getThreeMostCommonWords(test3);
        System.out.println("Test 3: " + Arrays.toString(result3));

        // All different words
        String test4 = "apple banana cherry date";
        String[] result4 = getThreeMostCommonWords(test4);
        System.out.println("All different: " + Arrays.toString(result4));
    }
}