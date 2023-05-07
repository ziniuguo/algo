package leetcode;


public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    ListNode(int[] ints) {
        if (ints == null || ints.length == 0) {
            throw new IllegalArgumentException("You can't use this constructor to instantiate such a ListNode.");
        }
        this.val = ints[0];
        ListNode listNode = this;
        for (int i = 1; i < ints.length; i++) {
            listNode.next = new ListNode();
            listNode = listNode.next;
            listNode.val = ints[i];
        }
    }

    public void printAll() {
        ListNode listNode = this;
        do {
            System.out.println(listNode.val);
            listNode = listNode.next;
        } while (listNode != null);
    }
}
