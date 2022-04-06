class Solution {
    int result = 0;
    public int uniquePaths(int m, int n) {
        
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++){
            dp[i][0] = 1;
        }
        
        for(int i = 0; i < n; i++){
            dp[0][i] = 1;
        }
        
        
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n ; j++){
                dp[i][j] = dp[i - 1][j] + dp[i][j -1];
            }
        }
        
        
        return dp[m-1][n-1];
        
        
        
//         Deque<int[]> queue = new LinkedList<>();
//         queue.offer(new int[]{0,0});
//         while(!queue.isEmpty()){
//             int[] first = queue.poll();
//             if(first[0] == m - 1 && first[1] == n - 1)
//                 result++;
//             List<int[]> neighbors = getNeighbors(first[0], first[1], m, n);
//             if(neighbors.size() > 0){
//                 for(int[] neigh : neighbors){
//                     queue.offer(neigh);
//                 }    
//             }
            
//         }
        // return result;
    }
    
    
    void dfs(int row, int col, int m, int n){
        if(row < 0 || row > m || col > n || col < 0){
            return;
        }
        if(row == m -1 && col == n - 1)
            result++;
        dfs(row + 1, col, m, n);
        dfs(row, col + 1, m, n);
    }
    
    
    List<int[]> getNeighbors(int row,  int col, int m, int n){
        
        int[][] directions = {{0, 1}, {1,0}};
        List<int[]> neighbors = new ArrayList<>();
        
        for(int[] dir : directions){
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            if(newRow < m && newRow > -1 && newCol < n && newCol > -1){
                neighbors.add(new int[]{newRow, newCol});
            }    
        }
        return neighbors;
    }
}