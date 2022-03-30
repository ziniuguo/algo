package leetcode;

import java.util.ArrayList;


public class leetcode133 {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        if (node.neighbors == null) {
            return new Node(node.val, null);
        }
        ArrayList<Node> nl = new ArrayList<>();
        nl = createNew(node, nl);
        ArrayList<Node> oldLs = new ArrayList<>();
        oldLs = genOldLs(node, oldLs);
        ArrayList<Node> ansls;
        ansls = connect(nl, oldLs);
        return ansls.get(0);

    }

    public ArrayList<Node> createNew(Node node, ArrayList<Node> ans) {
        Node nNode = new Node(node.val, null);
        ans.add(nNode);
        for (Node i : node.neighbors) {
            // check if i in ans
            int status = 0;
            for (Node j : ans) {
                if (i.val == j.val) {
                    status = 1;
                    break;
                }
            }

            if (status == 0) {
                ans = createNew(i, ans);
            }
        }
        return ans;
    }

    public ArrayList<Node> genOldLs(Node oldNode, ArrayList<Node> oldLs) {
        oldLs.add(oldNode);
        for (Node i : oldNode.neighbors) {
            int status = 0;
            for (Node j : oldLs) {
                if (i.val == j.val) {
                    status = 1;
                    break;
                }
            }

            if (status == 0) {
                oldLs = genOldLs(i, oldLs);
            }
        }
        System.out.println(oldLs.get(0).neighbors);
        return oldLs;
    }

    public ArrayList<Node> connect(ArrayList<Node> ls, ArrayList<Node> oldLs) {
        for (int i = 0; i < ls.size(); i++) {
            for (Node j : oldLs) {
                if (ls.get(i).val == j.val) {
                    // add neighbours
                    ArrayList<Node> nb = new ArrayList<>();
                    if (j.neighbors != null) {
                        for (Node n : j.neighbors) {
                            for (Node nn : ls) {
                                if (n.val == nn.val) {
                                    nb.add(nn);
                                }
                            }
                        }
                    }
                    ls.get(i).neighbors = nb;

                }
            }
        }
        return ls;
    }

}
