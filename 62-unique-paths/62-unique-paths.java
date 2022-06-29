class Solution {
    public int uniquePaths(int m, int n) {
        if(m == 1 || n == 1)
            return 1;
        
        int[][] dp = new int[m][n];
        for(int[] arr : dp)
            Arrays.fill(arr, 1);
        System.out.println(Arrays.deepToString(dp));
        for(int i = 1; i < m; i++){
            for(int j =1; j < n; j++){
                dp[i][j] = dp[i][j - 1]  + dp[i-1][j];
            }
        }

        return dp[m -1][n -1];
        
        // Deque<int[]> queue = new LinkedList<>();
        // queue.offer(new int[]{0, 0});
        // int result = 0;
        // int[][] directions = {{0,1}, {1,0}};
        // while(!queue.isEmpty()){
        //     int[] first = queue.poll();
        //     for(int[] d: directions){
        //         int newRow = first[0] + d[0];
        //         int newCol = first[1] + d[1];
        //         if(newRow < m && newCol < n){
        //             if(newRow == m -1 && newCol == n -1)
        //                 result++;
        //             else
        //                 queue.offer(new int[]{newRow, newCol});
        //         }
        //     }
        // }
        // return result;
    }
}