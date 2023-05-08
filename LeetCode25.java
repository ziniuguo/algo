package leetcode;

public class LeetCode25 {
    public static void main(String[] args) {
//        testReverseEntireList();
        ListNode ans = reverseKGroup(
                new ListNode(
                        new int[]{1, 2, 3, 4, 5}
                ), 1
        );
        ans.printAll();
    }

    /* ========== answer starts here ========== */
    public static ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) {
            return head;
        }
        ListNode toReturn = head;

        for (int i = 1; i <= k - 1; i++) {
            if (toReturn == null || toReturn.next == null) {
                return head;
            }
            toReturn = toReturn.next;
        }

        ListNode prevHead = new ListNode(114514);
        ListNode currHead = head;
        ListNode toCut;
        ListNode nextHead;

        outer:
        while (true) {
            toCut = currHead;
            for (int i = 1; i <= k - 1; i++) {
                if (toCut == null || toCut.next == null) {
                    prevHead.next = currHead;
                    break outer;
                }
                toCut = toCut.next;
            }
            nextHead = toCut.next;
            toCut.next = null;
            reverseEntireList(currHead);
            prevHead.next = toCut;
            prevHead = currHead;
            currHead = nextHead;
        }
        return toReturn;
    }

    private static void reverseEntireList(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode newHead = head;
        ListNode oldHead = head.next;
        newHead.next = null;
        while (oldHead != null) {
            // temp
            ListNode temp = oldHead.next;
            // reverse
            oldHead.next = newHead;
            // update
            newHead = oldHead;
            oldHead = temp;
        }
    }

    /* ========== answer starts here ========== */

    private static ListNode nonVoidReverseEntireList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode newHead = head;
        ListNode oldHead = head.next;
        newHead.next = null;
        while (oldHead != null) {
            // temp
            ListNode temp = oldHead.next;
            // reverse
            oldHead.next = newHead;
            // update
            newHead = oldHead;
            oldHead = temp;
        }
        return newHead;
    }


    private static void testReverseEntireList() {
        System.out.println("========== test start ==========");
        ListNode newHead = nonVoidReverseEntireList(null);
        System.out.println("newHead is null: " + (newHead == null));
        newHead = nonVoidReverseEntireList(new ListNode(new int[]{1}));
        newHead.printAll();
        newHead = nonVoidReverseEntireList(new ListNode(new int[]{1, 2}));
        newHead.printAll();
        newHead = nonVoidReverseEntireList(new ListNode(new int[]{1, 2, 3, 4, 5}));
        newHead.printAll();
        System.out.println("========== test done ==========");
    }
}
