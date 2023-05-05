package leetcode;

public class Leetcode24 {
    // 1 2 3 4 5 6 7 8

    // 2 1 3 4 5 6 7 8
    // 2 1 4 3 5 6 7 8

    // 2 1 4 3 6 5 7 8
    public ListNode swapPairs(ListNode head) {
        if (head == null) {return null;}
        if (head.next == null) {return head;}
        // swap first two nodes
        ListNode secondNode = head.next;
        head.next = secondNode.next;
        secondNode.next = head;
        // create while loop
        ListNode prevNode = head;
        ListNode node1 = head.next;
        if (node1 == null) {return secondNode;}
        ListNode node2 = node1.next;
        if (node2 == null) {return secondNode;}
        ListNode nextNode = node2.next;
        while (true) {
            // swapping process
            prevNode.next = node2;
            node2.next = node1;
            node1.next = nextNode;
            // renaming and checking process
            prevNode = node1;
            node1 = nextNode;
            if (node1 == null) {break;}
            node2 = node1.next;
            if (node2 == null) {break;}
            nextNode = node2.next;
        }
        return secondNode;
    }
}
