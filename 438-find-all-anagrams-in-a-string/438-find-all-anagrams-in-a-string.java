class Solution {
    public List<Integer> findAnagrams(String s, String p) {
     
        List<Integer> result = new ArrayList<Integer>();
        
        Map<Character, Integer> countMap = new HashMap<>();
        for(int i = 0; i < p.length(); i++){
            char c = p.charAt(i);
            countMap.putIfAbsent(c, 0);
            countMap.put(c, countMap.get(c) + 1); 
        }

        int pLength = p.length();
        
        for(int i = 0; i <= s.length() - pLength; i++){
            int[] counter = new int[26];
            for(int j = i; j < i + pLength; j++){
                counter[s.charAt(j) - 'a']++;
            }
            int length = 0;
            for(int k = 0; k < counter.length; k++){
                if(counter[k] != 0){
                    char c = (char)(k + 'a');
                    if(countMap.containsKey(c) && countMap.get(c) == counter[k]){
                        length += countMap.get(c);
                        if(length == pLength){
                            result.add(i);
                            break;
                        }
                    }
                }
            }

        }
        
        return result;
    }
}