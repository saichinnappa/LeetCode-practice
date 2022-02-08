class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s2.length() < s1.length())
            return false;
        Map<Character, Integer> map = new HashMap();
        char[] s1arr = s1.toCharArray();
        char[] s2arr = s2.toCharArray();
        for(int i = 0; i < s1arr.length; i++){
            if(!map.containsKey(s1arr[i])){
                map.put(s1arr[i], 0);
            } 
            map.put(s1arr[i], map.get(s1arr[i]) + 1);
        }
        
        int start = 0;
        int match = 0;
        for(int end = 0; end < s2arr.length; end++){
            if(map.containsKey(s2arr[end])){
                map.put(s2arr[end], map.get(s2arr[end]) - 1);
                if(map.get(s2arr[end]) == 0){
                    
                    match++;
                }
            }
            
            if(match == map.size())
                return true;
            
            if(end - start >= s1.length() - 1){
                char leftChar = s2arr[start];
                start++;
                
                if(map.containsKey(leftChar)){
                    if(map.get(leftChar) == 0)
                        match--;
                    map.put(leftChar, map.get(leftChar) + 1);
                }
                
            }
            
        }
        
        return false;
    }
}