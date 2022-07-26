class Solution {
    public int mostWordsFound(String[] sentences) {
        int maxLength = 0;
        for(String s : sentences){
            maxLength = Math.max(maxLength, s.split(" ").length);
        }
        
        return maxLength;
    }
}