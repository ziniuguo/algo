package leetcode;

public class leetcode1721 {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode node1 = FindNode1(head, k);
        ListNode node2 = FindNode2(head, k);
        int node1val = node1.val;
        node1.val = node2.val;
        node2.val = node1val;
        return head;
    }

    public ListNode FindNode1(ListNode head, int k) {
//        ListNode ans = head;
//        for (int i = 1; i < k; i++) {
//            ans = ans.next;
//        }
//        return ans;
        for (int i = 1; i < k; i++) {
            head = head.next;
        }
        return head;
    }

    public ListNode FindNode2(ListNode head, int k) {
        ListNode pt1 = head;
        for (int i = 1; i < k; i++) {
            pt1 = pt1.next;
        }

        while (pt1.next != null) {
            pt1 = pt1.next;
            head = head.next;
        }
        return head;
    }
}
