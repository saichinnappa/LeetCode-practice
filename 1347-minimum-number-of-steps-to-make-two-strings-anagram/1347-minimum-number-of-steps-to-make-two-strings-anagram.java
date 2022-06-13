class Solution {
    public int minSteps(String s, String t) {
     
        int[] charCount = new int[26];
        for(int i = 0; i < s.length(); i++){
            charCount[s.charAt(i) - 'a']++;
            charCount[t.charAt(i) - 'a']--;
        }
        
        int result = 0;
        for(int c : charCount){
            if(c < 0)
                result += Math.abs(c);
        }
        
        return result;
    }
}