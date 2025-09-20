import java.util.*;

public class Question2_firstUniqueProduct {

    // Find first product that appears exactly once in the array
    public static String firstUniqueProduct(String[] products) {
        if (products == null || products.length == 0) {
            return null;
        }

        // Count how many times each product appears
        HashMap<String, Integer> counts = new HashMap<>();

        for (String product : products) {
            if (product != null) {
                if (counts.containsKey(product)) {
                    counts.put(product, counts.get(product) + 1);
                } else {
                    counts.put(product, 1);
                }
            }
        }

        // Go through original array to find first unique one
        for (String product : products) {
            if (product != null && counts.get(product) == 1) {
                return product;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        // Main test case
        String[] test1 = {"Apple", "Computer", "Apple", "Bag"};
        String result = firstUniqueProduct(test1);
        System.out.println("Result: " + result);
        System.out.println("Should be: Computer");

        // Try another case
        String[] test2 = {"A", "B", "A", "C", "B"};
        String result2 = firstUniqueProduct(test2);
        System.out.println("Test 2: " + result2 + " (should be C)");

        // No unique products
        String[] test3 = {"A", "B", "A", "B"};
        String result3 = firstUniqueProduct(test3);
        System.out.println("No unique: " + result3);

        // All unique
        String[] test4 = {"X", "Y", "Z"};
        String result4 = firstUniqueProduct(test4);
        System.out.println("All unique: " + result4 + " (should be X)");
    }
}