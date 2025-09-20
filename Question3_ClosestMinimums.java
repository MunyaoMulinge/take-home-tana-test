import java.util.*;

public class Question3_ClosestMinimums {

    // Find distance between two closest minimum values
    public static int findClosestMinimumsDistance(int[] arr) {
        // Find the minimum value first
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }

        // Now find closest distance between minimums
        int closestDistance = Integer.MAX_VALUE;
        int lastMinPos = -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == min) {
                if (lastMinPos != -1) {
                    int dist = i - lastMinPos;
                    if (dist < closestDistance) {
                        closestDistance = dist;
                    }
                }
                lastMinPos = i;
            }
        }

        return closestDistance;
    }

    public static void main(String[] args) {
        // Test with example from problem
        int[] test1 = {1, 2, 3, 1, 4, 5, 2};
        int result = findClosestMinimumsDistance(test1);
        System.out.println("Result: " + result + " (should be 3)");

        // Try some other cases
        int[] test2 = {5, 1, 3, 1, 2};
        System.out.println("Test 2: " + findClosestMinimumsDistance(test2) + " (should be 2)");

        // Adjacent minimums
        int[] test3 = {3, 1, 1, 4, 5};
        System.out.println("Adjacent: " + findClosestMinimumsDistance(test3) + " (should be 1)");

        // Multiple minimums
        int[] test4 = {1, 3, 1, 2, 1, 4};
        System.out.println("Multiple: " + findClosestMinimumsDistance(test4) + " (should be 2)");

        // All same values
        int[] test5 = {5, 5, 5, 5};
        System.out.println("All same: " + findClosestMinimumsDistance(test5));
    }
}