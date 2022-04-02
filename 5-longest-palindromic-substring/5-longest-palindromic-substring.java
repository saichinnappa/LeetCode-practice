class Solution {
    public String longestPalindrome(String s) {
        if(s.length() == 1)
            return s;
        int n = s.length();
        char[] arr = s.toCharArray();
        boolean[][] dp = new boolean[n][n];
        int start = 0;
        int length = 0;
        //length 1
        for(int i = 0; i < arr.length; i++){
            dp[i][i] = true;
            start = i;
            length = 1;
        }
        
        //length 2;
        for(int i = 0; i < arr.length - 1; i++){
            if(arr[i] == arr[i + 1]){
                dp[i][i + 1] = true;
                start = i;
                length = 2;
            }
        }
        
        //length >= 3
        for(int k = 3; k <= n ; k++){
            for(int i = 0 ; i < n - k + 1; i++){
                int j = i + k - 1;
                if(arr[i] == arr[j] && dp[i + 1][j - 1]){
                    dp[i][j] = true;
                    start = i;
                    length = k;
                }
            }
        }
        
        return s.substring(start, start + length);
    }
}