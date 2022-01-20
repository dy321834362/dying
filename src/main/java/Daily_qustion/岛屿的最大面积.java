package Daily_qustion;

public class 岛屿的最大面积 {
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    max = Math.max(max, findArea(grid, i, j));
                }
            }
        }
        return max;
    }

    private int findArea(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) return 0;
        if (grid[i][j] == 0 || grid[i][j] == 2)return 0;
        int count = 0;
        if (grid[i][j] == 1){
            grid[i][j] =2;
            count++;
        }
        return count + findArea(grid, i-1, j) + findArea(grid, i+1, j) +
                findArea(grid, i, j-1) + findArea(grid, i, j+1);
    }
}
