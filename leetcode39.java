package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class leetcode39 {
    private class myNode {

        int val;
        ArrayList<myNode> children;

        myNode parent;

        myNode(int val) {
            this.val = val;
            this.children = new ArrayList<>();
        }
    }

    class Solution {
        List<List<Integer>> ansList = new ArrayList<>();
        public List<List<Integer>> combinationSum(int[] candidates, int target) {

            myNode rootNode = new myNode(target);
            System.out.println(rootNode.children);
            treeSetup(rootNode, candidates);
            for (myNode i: rootNode.children) {
                System.out.println(i.val);
            }
            return ansList;
        }

        public void treeSetup (myNode root, int[] candidates) {
            for (int i: candidates) {
                if (i <= root.val) {
                    myNode child = new myNode(root.val - i);
                    root.children.add(child);
                    child.parent = root;

                    if (child.val == 0) {
                        ArrayList<Integer> currAns = new ArrayList<>();
                        while (child.parent != null) {
                            currAns.add(child.parent.val - child.val);
                            child = child.parent;
                        }
                        Collections.sort(currAns);
                        if (!ansList.contains(currAns)) {
                            ansList.add(currAns);

                        }
                    }
                }
            }
            for (myNode child: root.children) {
                treeSetup(child, candidates);
            }
        }
    }

}