import java.util.*;

public class Question1_GetLongestString {

    // Find the longest string that doesn't have repeated consecutive chars
    // and only uses valid characters
    public static String getLongestString(String characters, String[] strings) {
        if (characters == null || strings == null) {
            return null;
        }

        String longest = null;
        int maxLen = 0;

        for (String s : strings) {
            if (s == null) continue;

            if (isValid(s, characters) && s.length() > maxLen) {
                maxLen = s.length();
                longest = s;
            }
        }

        return longest;
    }

    // Check if string is valid - no consecutive same chars and only valid chars
    private static boolean isValid(String str, String validChars) {
        if (str.length() == 0) return true;

        // Check each character
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            // Make sure character is in our valid set
            if (validChars.indexOf(c) == -1) {
                return false;
            }

            // Check for consecutive duplicates
            if (i > 0 && str.charAt(i-1) == c) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        // Test with the example from the problem
        String chars = "ABCD";
        String[] testStrings = {"AABCDA", "ABCDZADC", "ABCDBCA", "ABCDABDCA"};

        String result = getLongestString(chars, testStrings);
        System.out.println("Result: " + result);
        System.out.println("Expected: ABCDABDCA");

        // Quick test with some other cases
        String[] test2 = {"ABC", "ABCD", "ABCDA"};
        String result2 = getLongestString("ABCD", test2);
        System.out.println("Test 2: " + result2);

        // Edge case - empty array
        String result3 = getLongestString("ABC", new String[]{});
        System.out.println("Empty array test: " + result3);
    }
}