package io.catroll.algo;

public class LeetCode83 {
    /*Given the head of a sorted linked list,
    delete all duplicates such that each element appears only once.
    Return the linked list sorted as well.*/
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {return null;}
        ListNode node1 = head;
        ListNode node2 = head.next;
        while (node2 != null) {
            if (node1.val == node2.val) {
                // dup
                node1.next = node2.next;
            } else {
                node1 = node2;
            }
            node2 = node2.next;
        }
        return head;
    }
}
