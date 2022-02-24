class Solution {
    public String minWindow(String s, String t) {
        if(t.length() > s.length()) return "";
        char[] sarr = s.toCharArray();
        char[] tarr = t.toCharArray();
        int subStrStart = 0;
        int start = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < tarr.length; i++){
            map.put(tarr[i], map.getOrDefault(tarr[i], 0)  + 1);
        }
        
        int match = 0;
        int minLength = 0;
        
        for(int i = 0; i < sarr.length; i++){
            if(map.containsKey(sarr[i])){
                map.put(sarr[i], map.get(sarr[i]) - 1);
                if(map.get(sarr[i]) == 0){
                    match++;
                }
            }
            
            while(match == map.size()){
                if(minLength == 0)
                    minLength = i - start + 1;
                if(minLength > i - start + 1){
                    minLength = i - start + 1;
                subStrStart = start;
                }
                    
                if(map.containsKey(sarr[start])){
                    map.put(sarr[start], map.get(sarr[start]) + 1);
                    if(map.get(sarr[start]) > 0){
                        match--;
                    }
                }
                start++;
            }
        }

        
        return minLength == 0 ? "" : s.substring(subStrStart, subStrStart + minLength);
    }
}