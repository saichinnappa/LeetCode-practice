class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        int[] input = new int[26];
        for(int i = 0; i < s.length(); i++){
            input[s.charAt(i) - 'a']++;
            input[t.charAt(i) - 'a']--;
        }
        
        for(int n : input){
            if(n != 0)
                return false;
        }
        return true;        
    }
}