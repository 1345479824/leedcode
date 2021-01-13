package leedcode;

public class LeedCode200 {
    public int res = 0;
    public boolean isVisited[][];
    public void dfs(char[][] grid, int row, int col, int m, int n){
        if (row < 0 || col < 0 || row == m || col == n || isVisited[row][col] || grid[row][col] == '0'){
            return;
        }
        isVisited[row][col] = true;
        dfs(grid, row - 1, col, m, n);
        dfs(grid, row, col - 1, m, n);
        dfs(grid, row + 1, col, m, n);
        dfs(grid, row, col + 1, m, n);
    }

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        isVisited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++){
                if (!isVisited[i][j] && grid[i][j] == '1'){
                    res++;
                    dfs(grid, i, j, m, n);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LeedCode200 leedCode200 = new LeedCode200();
        char grid[][] = new char[][]{
                {'1','1','1'},
                {'0','1','0'},
                {'1','1','1'},
        };
        System.out.println(leedCode200.numIslands(grid));
    }
}
