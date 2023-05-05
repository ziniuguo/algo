package leetcode;

public class LeetCode19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode first = head;
        ListNode second = head;
        for (int i = 0; i < n; i++) {
            if (first.next == null) {
                return second.next;
            }
            first = first.next;
        }
        while (first.next != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return head;
    }
}
