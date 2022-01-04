class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
        if(p.length() > s.length())
            return new ArrayList();
        
        List<Integer> result = new ArrayList();
        char[] sMap = new char[26];
        char[] pMap = new char[26];
        
        for(int i = 0; i< p.length(); i++){
            pMap[p.charAt(i) - 'a']++;
        }
        
        for(int i = 0; i < s.length(); i++){
        
            
            sMap[s.charAt(i) - 'a']++;
            
            if(i >= p.length()){
                sMap[s.charAt(i - p.length()) - 'a']--;
            }
            
            // sMap[s.charAt(i + p.length()) -'a']++;
            // sMap[s.charAt(i) - 'a']--;
            
            if(Arrays.equals(sMap, pMap)){
                result.add(i - p.length() + 1);
            }
            
        }
        
        // if(matches(pMap, sMap)){
        //     result.add(s.length() - p.length());
        // }
        
        
        return result;
        
        
    }
    
    
    boolean matches(char[] pMap, char[] sMap){
        for(int i = 0; i< pMap.length; i++){
            if(pMap[i] != sMap[i])
                return false;
        }
        return true;
    }
    
}