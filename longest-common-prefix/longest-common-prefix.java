class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0)
            return "";
        if(strs.length == 1)
            return strs[0];
        
        Arrays.sort(strs);
        int count = 0;
        String lastString = strs[strs.length - 1];
        int lastStringSize = lastString.length();
        int minSize = Math.min(lastStringSize, strs[0].length());
        for(int i = 0; i < minSize; i++){
            if(i <= minSize && strs[0].charAt(i) == lastString.charAt(i))
                count++;
            else
                break;
        }
        
        return strs[0].substring(0, count);
    }
}