package leetcode;

public class leetcode48 {
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        int layer = (len + 1) / 2;
        int count = 0;
        for (int i = 0; i <= layer - 1; i++) {
            for (int j = count; j <= len - 2; j++) {
                rotateMatrix(matrix, i, j);
            }
            len -= 1;
            count += 1;
        }
    }
    public void rotateMatrix(int[][] matrix, int i, int j) {
        int len = matrix.length;
        int temp = matrix[j][len - 1 - i];
        matrix[j][len - 1 - i] = matrix[i][j];
        int temp2 = matrix[len - 1 - i][len - 1 - j];
        matrix[len - 1 - i][len - 1 - j] = temp;
        temp = matrix[len - 1 - j][i];
        matrix[len - 1 - j][i] = temp2;
        matrix[i][j] = temp;
    }

    public static void main(String[] args) {
        System.out.println(5/2);
    }
}
//
//          Input
//        [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
//        Output
//        [[14,15,2,5],[4,13,8,1],[12,3,6,9],[16,7,10,11]]
//        Expected
//        [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
