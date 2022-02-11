class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;
    
        Map<Character, Integer> charCount = new HashMap();
        char[] s1arr = s1.toCharArray();
        char[] s2arr = s2.toCharArray();
        
        for(char c : s1arr){
            if(!charCount.containsKey(c))
                charCount.put(c, 0);
            charCount.put(c, charCount.get(c) + 1);
        }
        
        int match = 0;
        int start = 0;
        
        for(int end = 0; end < s2arr.length; end++){
            char c = s2arr[end];
            if(charCount.get(c) != null){
                charCount.put(c, charCount.get(c) - 1);
                if(charCount.get(c) == 0)
                    match++;
            }
            // System.out.println(match);
            if(match == charCount.size())
                return true;
            
            if(end - start + 1 >= s1arr.length){
                
                // System.out.println((end - start + 1) +" | "+s2.substring(start, end + 1));
                char leftChar = s2arr[start];
                start++;
                if(charCount.get(leftChar) != null){
                    if(charCount.get(leftChar) == 0)
                        match--;
                    charCount.put(leftChar, charCount.get(leftChar) + 1);
                }
                
               
                
            }
            
            
        }
        return false;
        
    }
}