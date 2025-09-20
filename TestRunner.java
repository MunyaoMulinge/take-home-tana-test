public class TestRunner {

    public static void main(String[] args) {
        System.out.println("=== Running all tests ===\n");

        System.out.println("Question 1 - Longest String:");
        Question1_GetLongestString.main(args);
        System.out.println();

        System.out.println("Question 2 - First Unique Product:");
        Question2_firstUniqueProduct.main(args);
        System.out.println();

        System.out.println("Question 3 - Closest Minimums:");
        Question3_ClosestMinimums.main(args);
        System.out.println();

        System.out.println("Question 4 - Three Most Common:");
        Question4_ThreeMostCommon.main(args);
        System.out.println();

        System.out.println("Question 5 - Rotate List:");
        Question5_RotateList.main(args);

        System.out.println("\nDone!");
    }
}