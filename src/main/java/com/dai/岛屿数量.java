package com.dai;

public class 岛屿数量 {
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    findIslands(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void findIslands(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) return;
        if (grid[i][j] == '0') return;
        grid[i][j] = 0;
        findIslands(grid, i-1, j);
        findIslands(grid, i+1, j);
        findIslands(grid, i, j-1);
        findIslands(grid, i, j+1);
    }

    public static void main(String[] args) {
        char[][] ch = {{'1','1','0','0','0'}, {'1','1','0','0','0'}, {'0','0','1','0','0'},{'0','0','0','1','1'}};
        int i = new 岛屿数量().numIslands(ch);
        System.out.println(i);
    }
}
