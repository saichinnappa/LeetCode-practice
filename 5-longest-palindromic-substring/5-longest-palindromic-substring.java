class Solution {
    public String longestPalindrome(String s) {
        int length = s.length();
        boolean[][] dp = new boolean[length][length];
        int start = 0;
        int end = 0;
        
        char[] arr = s.toCharArray();
        
        for(int i = 0; i < arr.length; i++){
            dp[i][i] = true;
            start = i;
            end = 1;
        }
        
        for(int i = 0; i < arr.length - 1; i++){
            if((i+1) < arr.length && arr[i] == arr[i+1]){
                dp[i][i+1] = true;
                start = i;
                end = 2;
            }
        }
        
        for(int k = 3; k <= length; k++){
            for(int i = 0; i <= length - k; i++){
                int j = i + k - 1;

                if(arr[i] == arr[j] && dp[i + 1][j - 1]){
                    dp[i][j] = true;
                    // if(k > end){
                        start = i;
                        end  = k;
                    // }
                }
            }
        }
    
        return s.substring(start, end+start);
    }
}