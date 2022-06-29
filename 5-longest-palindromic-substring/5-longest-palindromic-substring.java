class Solution {
    public String longestPalindrome(String s) {
        int length = s.length();
        if(length == 1)
            return s;
        boolean[][] dp = new boolean[length][length];
        int start = -1;
        int size = -1;
        for(int i = 0; i < length; i++){
            dp[i][i] = true;
            start = i;
            size = 1;
        }
        
        for(int i = 0; i < length - 1; i++){
            if(s.charAt(i) == s.charAt(i + 1)){
                dp[i][i + 1] = true;
                start = i;
                size = 2;
            }
        }
        
        for(int k = 3; k <= length; k++){
            for(int i = 0; i < length - k + 1; i++){
                int j = k  + i - 1;
                // System.out.println(i+"--"+j+" "+ k);
                if(s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]){
                    dp[i][j] = true;
                    if(size < k){
                        start = i;
                        size = k;
                    }
                }
            }
        }
        // System.out.println(start+" "+ size);
        return size == -1 ? "" : s.substring(start, start + size);
    }
}