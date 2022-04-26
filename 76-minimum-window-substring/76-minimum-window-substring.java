class Solution {
    public String minWindow(String s, String t) {
        int sLength = s.length();
        int tLength = t.length();
        if(tLength > sLength)
            return "";
        char[] sarr = s.toCharArray();
        char[] tarr = t.toCharArray();
        Map<Character, Integer> charMap = new HashMap<Character, Integer>();
        int start = 0;
        int subStr = 0;
        int minLength = Integer.MAX_VALUE;
        int total = 0;
        
        for(char c : tarr){
            if(charMap.containsKey(c))
                charMap.put(c, charMap.get(c) + 1);
            else
                charMap.put(c, 1);
        }
        
        
        for(int i = 0; i < sarr.length; i++){
            if(charMap.containsKey(sarr[i])){
                charMap.put(sarr[i], charMap.get(sarr[i]) - 1);
                if(charMap.get(sarr[i]) == 0){
                    total++;
                }
            }
            
            while(charMap.size() == total){
                
                int end = i;
                int length = end - start + 1;
                if(minLength > length){
                    minLength = length;
                    subStr = start;
                }
                // minLength = Math.min(minLength, length);
                
                if(charMap.containsKey(sarr[start])){
                    if(charMap.get(sarr[start]) == 0)
                        total--;
                    charMap.put(sarr[start], charMap.get(sarr[start]) + 1);
                }
                start++;
            }
        }
        
        return minLength == Integer.MAX_VALUE ? "" : s.substring(subStr, subStr + minLength);
    }
}