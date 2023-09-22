package io.catroll.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class LeetCode834 {

    List<Integer>[] graph;
    int[] count;
    int[] res;
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        // init
        graph = new List[n];
        count = new int[n];
        res = new int[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge: edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        // dfs
        dfs(0, -1); // find res[0] 写-1或者0都行
        dfs2(0, -1); // find the rest
        return res;
    }

    private void dfs(int root, int prev) {
        for (int neighbour : graph[root]) {
            if (neighbour == prev) {
                // 为什么有prev？你不能往回去搜dfs。
                continue;
            }
            // post order
            dfs(neighbour, root);
            res[root] += res[neighbour] + count[neighbour];
            count[root] += count[neighbour];
        }
        count[root] += 1;
    }

    private void dfs2(int root, int prev) {
        for (int neighbour : graph[root]) {
            if (neighbour == prev) {
                continue;
            }
            // pre order
            res[neighbour] = res[root] - count[neighbour] + count.length - count[neighbour];
            dfs2(neighbour, root);
        }
    }

    public int[] sumOfDistancesInTreeBrutal(int n, int[][] edges) {
        // 遍历所有点
        graph = new List[n];
        res = new int[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge: edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        for (int node = 0; node < graph.length; node++) {
            dfsBrutal(node, -1, node); // 这里就写-1，因为是第一个node，所有neighbour都不会和-1相等。
            Arrays.fill(count, 0);
        }
        return res;
    }

    private void dfsBrutal(int root, int prev, int index) {
        count[root] = prev == -1 ? 0 : count[prev] + 1; // increase weight
        res[index] = res[index] + count[root];
        for (int neighbour : graph[root]) {
            if (neighbour == prev) {
                // 为什么有prev？你不能往回去搜dfs。
                continue;
            }
            // post order
            dfsBrutal(neighbour, root, index);
        }
    }
}
