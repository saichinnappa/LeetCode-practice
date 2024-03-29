class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        int row = 0;
        int col = 0;
        int max = 0;
        
        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[i].length; j++){
                if(nums1[i - 1] == nums2[j - 1]){
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    if(max < dp[i][j]){
                        max = dp[i][j];
                        row = i;
                        col = j;
                    }
                }
            }
        }
        
//         int startRow = row;
//         int startCol = col;
//         int newMax = max;
//         while(newMax != 1){
//             newMax--;
//             startRow--;
//             startCol--;
//         }
        
//         System.out.println((startRow - 1)+" "+(row - 1));
        
        return max;
        
    }
}