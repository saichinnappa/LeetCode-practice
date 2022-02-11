class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;
        Map<Character, Integer> charCount = new HashMap();
        int start = 0;
        
        for(int i = 0; i < s1.length(); i++){
            char c = s1.charAt(i);
            if(!charCount.containsKey(c))
                charCount.put(c, 0);
            charCount.put(c, charCount.get(c) + 1);
        }
        int match = 0;
        
        for(int end = 0; end < s2.length(); end++){
            char c = s2.charAt(end);
            if(charCount.containsKey(c)){
                charCount.put(c, charCount.get(c) - 1);
                if(charCount.get(c) == 0)
                    match++;
            }
            
            if(match == charCount.size())
                return true;
            
            if(end - start + 1 >= s1.length()){
                char leftChar = s2.charAt(start);
                start++;
                if(charCount.containsKey(leftChar)){
                    
                    if(charCount.get(leftChar) == 0)
                        match--;
                    
                    charCount.put(leftChar, charCount.get(leftChar) + 1);
                }
            }
        }
        
        return false;
        
    }
}