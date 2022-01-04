class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int np = p.length(), ns = s.length();
        if(np > ns)
            return new ArrayList();
        
        List<Integer> result = new ArrayList();
        char[] sMap = new char[26];
        char[] pMap = new char[26];
        
        for(int i = 0; i< np; i++){
            pMap[p.charAt(i) - 'a']++;
        }
        
        for(int i = 0; i < ns; i++){
        
            
            sMap[s.charAt(i) - 'a']++;
            
            if(i >= np){
                sMap[s.charAt(i - np) - 'a']--;
            }
            
            // sMap[s.charAt(i + p.length()) -'a']++;
            // sMap[s.charAt(i) - 'a']--;
            
            if(Arrays.equals(sMap, pMap)){
                result.add(i - np + 1);
            }
            
        }
        
        // if(matches(pMap, sMap)){
        //     result.add(s.length() - p.length());
        // }
        
        
        return result;
        
        
    }
    
    
    // boolean matches(char[] pMap, char[] sMap){
    //     for(int i = 0; i< pMap.length; i++){
    //         if(pMap[i] != sMap[i])
    //             return false;
    //     }
    //     return true;
    // }
    
}