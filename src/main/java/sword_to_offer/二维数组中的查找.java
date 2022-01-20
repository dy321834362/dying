package sword_to_offer;

public class 二维数组中的查找 {
    public static void main(String[] args) {

    }
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int row = 0;
        int col = matrix.length == 0 ? 0 : matrix[0].length-1;
        while(row < matrix.length && col >= 0) {
            if (matrix[row][col] > target) {
                col--;
            }else if (matrix[row][col] < target) {
                row++;
            } else {
                return true;
            }
        }
        return false;
    }
}
