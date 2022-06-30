class Solution {
    public List<Integer> findAnagrams(String s, String p) {
     
        List<Integer> result = new ArrayList<Integer>();
        
        int sLength = s.length();
        int pLength = p.length();
        
        int[] sarr = new int[26];
        int[] parr = new int[26];
        
        for(int i = 0; i < p.length(); i++){
            parr[p.charAt(i) - 'a']++;
        }
        
        int idx = 0;
        for(int j = 0; j < s.length(); j++){
            sarr[s.charAt(j) - 'a'] ++;
            if(j >= p.length()){
                sarr[s.charAt(idx) - 'a'] --;
                idx++;
            }
            
            if(Arrays.equals(sarr, parr)){
                result.add(j - pLength + 1);
            }
        }
        return result;
        
//         Map<Character, Integer> countMap = new HashMap<>();
//         for(int i = 0; i < p.length(); i++){
//             char c = p.charAt(i);
//             countMap.putIfAbsent(c, 0);
//             countMap.put(c, countMap.get(c) + 1); 
//         }

//         int pLength = p.length();
        
//         for(int i = 0; i <= s.length() - pLength; i++){
//             int[] counter = new int[26];
//             for(int j = i; j < i + pLength; j++){
//                 counter[s.charAt(j) - 'a']++;
//             }
//             int length = 0;
//             for(int k = 0; k < counter.length; k++){
//                 if(counter[k] != 0){
//                     char c = (char)(k + 'a');
//                     if(countMap.containsKey(c) && countMap.get(c) == counter[k]){
//                         length += countMap.get(c);
//                         if(length == pLength){
//                             result.add(i);
//                             break;
//                         }
//                     }
//                 }
//             }

//         }
        
//         return result;
    }
}