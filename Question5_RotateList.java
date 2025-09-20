import java.util.*;

public class Question5_RotateList {

    // Simple node for linked list
    static class ListNode {
        String data;
        ListNode next;

        ListNode(String data) {
            this.data = data;
            this.next = null;
        }
    }

    // Rotate linked list to the right by n positions
    public static ListNode rotateRight(ListNode head, int n) {
        if (head == null || n == 0) {
            return head;
        }

        // First find the length and last node
        int len = 1;
        ListNode last = head;
        while (last.next != null) {
            last = last.next;
            len++;
        }

        // If n is bigger than length, we only need to rotate by n % len
        n = n % len;
        if (n == 0) {
            return head;
        }

        // Find where to break the list
        // We need to go (len - n) steps from head to find the new tail
        ListNode newTail = head;
        for (int i = 0; i < len - n - 1; i++) {
            newTail = newTail.next;
        }

        // The new head is right after the new tail
        ListNode newHead = newTail.next;

        // Break the list and reconnect
        newTail.next = null;
        last.next = head;

        return newHead;
    }

    // Helper to create list from array
    public static ListNode createList(String[] values) {
        if (values.length == 0) return null;

        ListNode head = new ListNode(values[0]);
        ListNode current = head;

        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
        }

        return head;
    }

    // Helper to print the list
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.data);
            if (current.next != null) {
                System.out.print("->");
            }
            current = current.next;
        }
        System.out.println("->null");
    }

    public static void main(String[] args) {
        // Main test case from problem
        String[] test1 = {"ID_A01", "ID_A02", "ID_A03", "ID_A04", "ID_A05", "ID_A06"};
        ListNode list1 = createList(test1);

        System.out.println("Original:");
        printList(list1);

        ListNode rotated = rotateRight(list1, 2);
        System.out.println("Rotated by 2:");
        printList(rotated);
        System.out.println("Should be: ID_A05->ID_A06->ID_A01->ID_A02->ID_A03->ID_A04->null");
        System.out.println();

        // Another test
        String[] test2 = {"A", "B", "C", "D"};
        ListNode list2 = createList(test2);
        System.out.println("Test 2 original:");
        printList(list2);

        ListNode rotated2 = rotateRight(list2, 1);
        System.out.println("Rotated by 1:");
        printList(rotated2);
        System.out.println();

        // Edge case - rotate by full length
        String[] test3 = {"X", "Y", "Z"};
        ListNode list3 = createList(test3);
        System.out.println("Full rotation test:");
        printList(list3);

        ListNode rotated3 = rotateRight(list3, 3);
        System.out.println("After rotating by 3:");
        printList(rotated3);
    }
}