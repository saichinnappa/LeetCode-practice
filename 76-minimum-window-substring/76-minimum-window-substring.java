class Solution {
    public String minWindow(String s, String t) {
        int tLength = t.length();
        int sLength= s.length();
        if(sLength < tLength)
            return "";
        
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0; i < tLength; i++){
            if(!map.containsKey(t.charAt(i))){
                map.put(t.charAt(i), 0);
            }
            map.put(t.charAt(i), map.get(t.charAt(i)) + 1);
        }
        
        int minLength = Integer.MAX_VALUE;
        int start = 0;
        int result = 0;
        int subStr = 0;
        for(int i = 0; i < sLength; i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                map.put(c, map.get(c) - 1);
                if(map.get(c) == 0){
                    result++;
                }
            }
            
            while(result == map.size()){
                
                int currLength = i - start + 1;
                if(minLength > currLength){
                    minLength = currLength;
                    subStr = start;
                }
                char first = s.charAt(start);
                if(map.containsKey(first)){
                    map.put(first, map.get(first) +1);
                    if(map.get(first)  > 0){
                        result--;
                    }
                    
                }
                start++;
            }
            
        }
        return minLength == Integer.MAX_VALUE ? "" : s.substring(subStr, subStr + minLength);
    }
}