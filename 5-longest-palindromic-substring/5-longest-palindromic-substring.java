class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        
        char[] arr = s.toCharArray();
        int length = 0;
        int start = 0;
        
        for(int i = 0; i < n; i++){
            dp[i][i] = true;
            length = 1;
            start = i;
        }
        
        for(int i = 0; i < n - 1; i++){
            if(arr[i] == arr[i + 1]){
                dp[i][i + 1] = true;
                length = 2;
                start = i;
            }
        }
        
        
        for(int i = 3; i <= n ; i++){
            for(int j = 0; j <= n - i; j++){
                int k = j + i - 1;
                if(arr[j] == arr[k] && dp[j + 1][k - 1]){
                    dp[j][k] = true;
                    length = i;
                    start = j;
                }
            }
        }
        return s.substring(start, start + length);
    }
}