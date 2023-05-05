package leetcode;

import java.util.ArrayList;

public class LeetCode23 {
    public static void main(String[] args) {
        ListNode[] listNodes = new ListNode[] {
            null
        };
        ListNode result = mergeKLists(listNodes);
        result.printAll();
    }
    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode ans = new ListNode(114514);
        ListNode ans2ret = ans;
        ArrayList<ListNode> pointerList =
                new ArrayList<>(lists.length);
        // initialise pointer list
        for (ListNode header : lists) {
            if (header != null) {
                // skip [[1,2], [3,4], []] condition
                pointerList.add(header);
            }
        }
        // multiple pointer solution
        while (pointerList.size() > 0) {
            int currMin = Integer.MAX_VALUE;
            int currIdxToMove = 0;
            for (int i = 0; i < pointerList.size(); i++) {
                if (pointerList.get(i).val < currMin) {
                    currIdxToMove = i;
                    currMin = pointerList.get(i).val;
                }
            }
            ListNode currPointer = pointerList.get(currIdxToMove);
            // add to ans
            ans.next = new ListNode(currPointer.val);
            ans = ans.next;
            // update pointerList
            if (currPointer.next == null) {
                // no next pointer, remove from list
                pointerList.remove(currIdxToMove);
            } else {
                // have next pointer, replace old one
                pointerList.set(currIdxToMove, currPointer.next);
            }
        }
        return ans2ret.next;
    }
}


// 1 2 3
// val=1 linked list
// next=element2

// element2.val =1
 // O(n logn)