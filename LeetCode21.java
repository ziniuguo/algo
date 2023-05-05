package leetcode;

public class leetcode21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode ans = new ListNode(Math.max(list1.val, list2.val), null);
        ListNode head = ans;
        while (list1 != null || list2 != null) {
            if (list1 == null) {
                ans.next = list2;
                list2 = list2.next;
                ans = ans.next;
            } else if (list2 == null) {
                ans.next = list1;
                list1 = list1.next;
                ans = ans.next;
            } else {
                if (list1.val>= list2.val) {
                    ans.next = list2;
                    list2 = list2.next;
                    ans = ans.next;
                } else {
                    ans.next = list1;
                    list1 = list1.next;
                    ans = ans.next;
                }
            }
        }
        return head.next;
    }
}
