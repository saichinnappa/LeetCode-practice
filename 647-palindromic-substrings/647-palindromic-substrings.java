class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        int l = s.length();
        if(l == 1)
            return 1;
        boolean[][] dp = new boolean[l][l];
        
        for(int i = 0; i < l; i++){
            dp[i][i] = true;
            count++;
        }
        
        for(int i = 0; i < l - 1; i++){
            if(s.charAt(i) == s.charAt(i + 1)){
                dp[i][i + 1] = true;
                count++;
            }
        }
        
        for(int k = 3; k <= l; k++){
            for(int i = 0; i < l - k + 1; i++){
                int j = i + k - 1;
                if(s.charAt(i) == s.charAt(j) && dp[i+1][j - 1]){
                    dp[i][j] = true;
                    count++;
                }
            }
        }
        
        return count;
    }
}