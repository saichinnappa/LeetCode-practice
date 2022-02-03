class Solution {
    public int countSubstrings(String s) {
        if(s.length() <= 1)
            return s.length();
        int result = 0;
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        
        for(int i = 0; i < s.length(); i++){
            dp[i][i] = true;
            result++;
        }
        
        for(int i = 0; i < s.length() - 1; i++){
            if(s.charAt(i) == s.charAt(i+1)){
                dp[i][i+1] = true;
                result++;
            }
        }
        
        for(int k = 3; k <= n; k++){
            System.out.println("k-> "+k);
            for(int i = 0; i < n - k + 1; i++){
                int j = i + k - 1;

                if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1]){
                    dp[i][j] = true;
                    result++;
                }
            }
        }
        
        return result;
    }
}