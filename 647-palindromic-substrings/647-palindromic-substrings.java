class Solution {
    public int countSubstrings(String s) {
        int length = s.length();
        if(length < 2)
            return length;
        int result = 0;
        boolean[][] dp = new boolean[length][length];
        
        char[] arr = s.toCharArray();
        
        for(int i = 0; i < length; i++){
            dp[i][i] = true;
            result++;
        }
        
        for(int i = 0; i < length - 1; i++){
            if(arr[i] == arr[ i+ 1]){
                dp[i][i+1] = true;
                result++;
            }
        }
        
        for(int k = 3; k <= length; k++){
            for(int i = 0; i <= length - k; i++){
                int j = i + k - 1;
                if(arr[i] == arr[j] && dp[i+1][j - 1]){
                    dp[i][j] = true;
                    result++;
                }
            }
        }
        return result;
    }
}