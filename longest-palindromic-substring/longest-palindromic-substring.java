class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int maxLength = 0;
        int start = 0;
        char[] arr = s.toCharArray();
        
        for(int i = 0; i < n; i++){
            dp[i][i] = true;
            start = i;
            maxLength = 1;
        }
        
        for(int i = 0; i < n - 1; i++){
            if(arr[i] == arr[i + 1]){
                dp[i][i + 1] = true;
                start = i;
                maxLength = 2;
            }
        }
        
        
        for(int k = 3; k <= n; k++){
            for(int i = 0; i < n - k + 1; i++){
                int j = i + k - 1;
                if(arr[i] == arr[j] && dp[i + 1][j - 1]){
                    dp[i][j] = true;
                    start = i;
                    maxLength = k;
                }
            }
        }
        
        
        
        return s.substring(start, start + maxLength);
        
    }
}