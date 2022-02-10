class Solution {
    public String minWindow(String s, String t) {
        if(t.length() > s.length())
            return "";
        Map<Character, Integer> map = new HashMap();
        char[] sarr = s.toCharArray();
        char[] tarr = t.toCharArray();
        for(char c : tarr){
            if(!map.containsKey(c)){
                map.put(c, 0);
            }
            map.put(c,map.get(c)+1);
        }
        int match = 0;
        int minLength = Integer.MAX_VALUE;
        int start = 0;
        int subStrStart = 0;
        for(int i = 0; i < sarr.length; i++){
            char c = sarr[i];
            if(map.containsKey(c)){
                map.put(c, map.get(c) - 1);
                if(map.get(c) >= 0){
                    match++;
                }
            }
            
            while(match == t.length()){
                if(minLength > i - start + 1){
                    minLength = i - start + 1;
                    subStrStart = start;
                }
                char leftChar = sarr[start];
                start++;
                if(map.containsKey(leftChar)){
                    if(map.get(leftChar) == 0){
                        match--;
                    }
                    map.put(leftChar, map.get(leftChar) + 1);
                }
                
            }
            
        }
        
    
        
        return minLength  > s.length() ? "" : s.substring(subStrStart, subStrStart+minLength);
    }
}