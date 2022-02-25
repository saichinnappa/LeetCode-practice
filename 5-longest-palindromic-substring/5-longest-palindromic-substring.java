class Solution {
    public String longestPalindrome(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        
        char[] arr = s.toCharArray();
        int length = 0;
        int start = 0;
        
        for(int i = 0; i < arr.length; i++){
            dp[i][i] = true;
            length = 1;
            start = i;
        }
        
        for(int i = 0; i < arr.length - 1; i++){
            if(arr[i] == arr[i + 1]){
                dp[i][i + 1] = true;
                length = 2;
                start = i;
            }
        }
        
        
        for(int i = 3; i <= s.length() ; i++){
            for(int j = 0; j <= s.length() - i; j++){
                int k = j + i - 1;
                if(s.charAt(j) == s.charAt(k) && dp[j + 1][k - 1]){
                    dp[j][k] = true;
                    length = i;
                    start = j;
                }
            }
        }
        return s.substring(start, start + length);
    }
}