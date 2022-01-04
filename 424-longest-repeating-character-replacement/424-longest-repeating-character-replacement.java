class Solution {
    public int characterReplacement(String s, int k) {
        int startWindow = 0;
        char[] count = new char[26];
        int result = 0;
        int maxCount = 0;
        for(int i = 0; i< s.length(); i++){
            count[s.charAt(i) - 'A']++;
            maxCount = Math.max(maxCount, count[s.charAt(i) - 'A']);
            // maxCount = 
            int uniqueChars = (i - startWindow + 1) - maxCount;
            
            if(uniqueChars > k){
                count[s.charAt(startWindow) - 'A']--;
                startWindow++;
            }
            result = Math.max(result, i - startWindow + 1);
        }
        return result;
    }
}