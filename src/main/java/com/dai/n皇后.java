package com.dai;

import java.util.*;

public class n皇后 {
    List<List<String>> list = new ArrayList<>();
    Deque<String> tmp = new LinkedList<>();

    public List<List<String>> solveNQueens(int n) {
        int[][] plate = new int[n][n];
        solveNQueens(n, plate, 0);
        return list;
    }

    private void solveNQueens(int n, int[][] plate, int i) {
        if (i == n) {
            list.add(new LinkedList<>(tmp));
            return;
        }
        for (int j = 0; j < plate[0].length; j++) {
            if (plate[i][j] == 1) continue;
            tmp.offerLast(setString(j, n));
            List<int[]> change = changePlate(plate, i, j);
            solveNQueens(n, plate, i+1);
            changePlateBack(plate, change);
            tmp.removeLast();
        }
    }

    private void changePlateBack(int[][] plate, List<int[]> change) {
        for (int[] arr : change) {
            plate[arr[0]][arr[1]] = 0;
        }
    }

    private List<int[]> changePlate(int[][] plate, int i, int j) {
        List<int[]> l = new ArrayList<>();
        int[][] arr = {{1,1}, {1,-1}, {1,0}};
        int row = 0 ;
        int col = 0 ;
        for (int k = 0; k < arr.length; k++) {
            row = i + arr[k][0];
            col = j + arr[k][1];
            while (row >= 0 && col >= 0 && row <= plate.length-1 && col <= plate[0].length-1) {
                if (plate[row][col] == 0) {
                    plate[row][col] = 1;
                    l.add(new int[]{row, col});
                }
                row += arr[k][0];
                col += arr[k][1];
            }
        }
        return l;
    }

    private String setString(int j, int n) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (i == j) {
                s.append("Q");
            } else {
                s.append(".");
            }
        }
        return s.toString();
    }

    public static void main(String[] args) {
        new n皇后().solveNQueens(4);
    }
}
