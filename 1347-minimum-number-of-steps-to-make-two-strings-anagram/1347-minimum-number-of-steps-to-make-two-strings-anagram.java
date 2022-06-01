class Solution {
    public int minSteps(String s, String t) {
        if(s.equals(t))
            return 0;
        int[] sarr = new int[26];
     for(char c : s.toCharArray()){
            sarr[c - 'a']++;
        }
        
        for(char c : t.toCharArray()){
            if(sarr[c - 'a'] > 0)
                sarr[c - 'a']--;
        }
        
        int result = 0;
        for(int i = 0; i < sarr.length; i++){
            result += sarr[i];
        }
        
        return result;
    }
}