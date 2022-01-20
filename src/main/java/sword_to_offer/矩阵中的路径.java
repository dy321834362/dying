package sword_to_offer;

public class 矩阵中的路径 {
    public static void main(String[] args) {

    }
    public boolean exist(char[][] board, String word) {
        if (word.length() == 0){
            return false;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(exist(board, word,i ,j, 0)) return true;
            }
        }
        return false;
    }

    private boolean exist(char[][] board, String word, int i, int j, int k) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(k)) {
            return false;
        }
        if (k == word.length() - 1) return true;
        board[i][j] = ' ';
        boolean b = exist(board, word,i+1 ,j, k+1) || exist(board, word,i-1 ,j, k+1) ||
                exist(board, word,i ,j+1, k+1) || exist(board, word,i ,j-1, k+1);
        board[i][j] = word.charAt(k);
        return b;
    }
}
