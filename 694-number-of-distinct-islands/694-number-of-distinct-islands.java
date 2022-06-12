class Solution {
    int[][] grid;
    public int numDistinctIslands(int[][] grid) {
        if(grid.length == 0 || grid == null) return 0;
        this.grid = grid;
        
        Set<Set<String>> set = new HashSet<>();
        int m = grid.length;
        int n = grid[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    Set<String> result = dfs(i, j, i, j, new HashSet<>());
                    set.add(result);
                }
            }
        }
        return set.size();
    }
    
    
    private Set<String> dfs(int i, int j, int row, int col, Set<String> set){
    if (i >= 0 && i < grid.length && j >= 0 && j < grid[i].length && grid[i][j] == 1) {
        
            grid[i][j] = 0;
            String temp = (i - row) + "," + (j - col);
            set.add(temp);

            dfs(i - 1, j, row, col, set);
            dfs(i + 1, j, row, col, set);
            dfs(i, j - 1, row, col , set);
            dfs(i, j + 1, row, col, set);
        }
        return set;
    }
    
}