class Solution {
    public String longestPalindrome(String s) {
        if(s.length() == 1)
            return s;
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        char[] arr = s.toCharArray();
        
        int start = 0;
        int maxLength = 0;
        
        for(int i = 0; i < arr.length; i++){
            dp[i][i] = true;
            start = i;
            maxLength = 1;
        }
        
        for(int i = 0; i < arr.length - 1; i++){
            if(arr[i] == arr[i + 1]){
                dp[i][i+1] = true;
                start = i;
                maxLength = 2;
            }
        }
        
        for(int k = 3; k <= n; k++){
            for(int i = 0; i < n - k + 1; i++){
                int j = i + k - 1;
                if(j < n && arr[i] == arr[j] && dp[ i + 1][j - 1]){
                    dp[i][j] = true;
                    if(maxLength < k){
                        maxLength = k;
                        start = i;
                    }
                }
            }
        }
        
        return s.substring(start, start + maxLength);
        
    }
}