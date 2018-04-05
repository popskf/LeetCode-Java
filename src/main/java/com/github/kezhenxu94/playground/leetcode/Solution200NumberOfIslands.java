package com.github.kezhenxu94.playground.leetcode;

/**
 * 200. Number of Islands
 *
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 *
 * Example 1:
 *
 * 11110
 * 11010
 * 11000
 * 00000
 * Answer: 1
 *
 * Example 2:
 *
 * 11000
 * 11000
 * 00100
 * 00011
 * Answer: 3
 *
 * [Tags] Union Find. Breadth-first Search. Depth-first Search
 *
 * @author Ke Zhenxu
 */
public class Solution200NumberOfIslands {

    enum Direction {
        N, S, W, E;
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    backtracking(grid, visited, i, j, Direction.E);
                    result++;
                }
            }
        }
        return result;
    }

    private void backtracking(char[][] grid, boolean[][] visited, int row, int col, Direction direction) {
        visited[row][col] = true;
        int rowCount = grid.length;
        int colCount = grid[0].length;
        if (row + 1 < rowCount && !visited[row + 1][col] && grid[row + 1][col] == '1' && direction != Direction.N)
            backtracking(grid, visited, row + 1, col, Direction.S);
        if (row - 1 >= 0 && !visited[row - 1][col] && grid[row - 1][col] == '1' && direction != Direction.S)
            backtracking(grid, visited, row - 1, col, Direction.N);
        if (col + 1 < colCount && !visited[row][col + 1] && grid[row][col + 1] == '1' && direction != Direction.W)
            backtracking(grid, visited, row, col + 1, Direction.E);
        if (col - 1 >= 0 && !visited[row][col - 1] && grid[row][col - 1] == '1' && direction != Direction.E)
            backtracking(grid, visited, row, col - 1, Direction.W);
        grid[row][col] = '0';
    }
}
