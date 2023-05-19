package leetcode;

import java.util.LinkedList;
import java.util.List;

public class LeetCode54 {
    public static List<Integer> spiralOrder(int[][] matrix) {
        int x = 0;
        int y = 0;
        int xMin = 0;
        int yMin = 0;
        int xMax = matrix.length - 1;
        int yMax = matrix[0].length - 1;

        // init x and y coordinate
        LinkedList<Integer> results = new LinkedList<>();

        while (true) {
            // move right
            if (yMin > yMax) {
                break;
            }
            for (y = yMin; y <= yMax; y++) {
                results.add(matrix[x][y]);
            }
            // update xMin, fix y
            xMin++; y--;
            // move down
            if (xMin > xMax) {
                break;
            }
            for (x = xMin; x <= xMax; x++) {
                results.add(matrix[x][y]);
            }
            // update yMax, fix x
            yMax--; x--;
            // move left
            if (yMin > yMax) {
                break;
            }
            for (y = yMax; y >= yMin; y--) {
                results.add(matrix[x][y]);
            }
            // update xMax, fix y
            xMax--; y++;
            // move up
            if (xMin > xMax) {
                break;
            }
            for (x = xMax; x >= xMin; x--) {
                results.add(matrix[x][y]);
            }
            // update yMin, fix x
            yMin++; x++;
        }

        return results;
    }

    public static void main(String[] args) {
        int[][] matrixIn = new int[][]{
                new int[]{1, 2, 3, 4},
                new int[]{5, 6, 7, 8},
                new int[]{9, 10, 11, 12}
        };
        List<Integer> resultOut = spiralOrder(matrixIn);
        resultOut.forEach(System.out::println);
    }
}
