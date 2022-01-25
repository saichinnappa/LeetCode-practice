class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() <= 1) return s.length();
        
        int result = 0;
        int start = 0;
        
        Map<Character, Integer> map = new HashMap();
        for(int i = 0; i< s.length(); i ++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                if(start <= map.get(c))
                    start = map.get(c) + 1;
            }
            map.put(c, i);
            result = Math.max(result, i - start + 1);
                
        }
        return result;
    }
    
//     public int lengthOfLongestSubstring(String s) {
        
//         Map<Character, Integer> map= new HashMap<>();
//         int start=0, len=0;
        
//         // abba
//         for(int i=0; i<s.length(); i++) {
//             char c = s.charAt(i);
//             if (map.containsKey(c)) {
//                 if (map.get(c) >= start) 
//                     start = map.get(c) + 1;
//             }
//             len = Math.max(len, i-start+1);
//             map.put(c, i);
//         }
        
//         return len;
//     }
}