class Solution {
    public String minWindow(String s, String t) {
        if(s.equals(t))
            return s;
        char[] sarr = s.toCharArray();
        char[] tarr = t.toCharArray();
        int sLength = s.length();
        int tLength = t.length();
        int start = 0;
        String result = "";
        int length = sLength + 1;
        int substr = 0;
        
        Map<Character, Integer> charCount = new HashMap();
        for(char c : tarr){
            if(!charCount.containsKey(c)){
                charCount.put(c, 1);
            } else{
                charCount.put(c, charCount.get(c) + 1);
            }
        }
        
        int match = 0;
        for(int end = 0; end < sarr.length; end++){
            if(charCount.containsKey(sarr[end])){
                charCount.put(sarr[end], charCount.get(sarr[end]) - 1);
                if(charCount.get(sarr[end]) >= 0){
                    match++;
                }    
            }
            while(match == tLength){
                if(length > end - start + 1){
                    length = end - start + 1;
                    substr = start;
                }
                
                char leftChar = sarr[start];
                start++;
                if(charCount.containsKey(leftChar)){
                    if(charCount.get(leftChar) == 0)
                        match--;
                    charCount.put(leftChar, charCount.get(leftChar) + 1);
                }
                
            }
        }
        
        return length > s.length() ? "" : s.substring(substr, length + substr);
    }
}