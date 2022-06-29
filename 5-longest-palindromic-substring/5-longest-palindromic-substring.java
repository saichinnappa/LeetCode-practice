class Solution {
    public String longestPalindrome(String s) {
        int length = s.length();
        if(length == 1)
            return s;
        char[] arr = s.toCharArray();
        int maxLength= 0;
        int start = 0;
        boolean[][] dp = new boolean[length][length];
        
        for(int i = 0; i < arr.length; i++){
            dp[i][i] = true;
            maxLength = 1;
            start = i;
        }
        
        for(int i = 0; i < arr.length - 1; i++){
            if(arr[i] == arr[i+1]){
                dp[i][i+1] = true;
                maxLength = 2;
                start = i;
            }
        }
        
        for(int k = 3;k <= length; k++){
            for(int i = 0; i < length -k + 1; i++){
                int j = k + i - 1;
                if(arr[i] == arr[j] && dp[i+1][j-1]){
                    dp[i][j] = true;
                    maxLength = k;
                    start = i;
                }
            }
        }
        
        return s.substring(start, start + maxLength);
    }
}