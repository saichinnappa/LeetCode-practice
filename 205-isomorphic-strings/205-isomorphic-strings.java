class Solution {
    public boolean isIsomorphic(String s1, String t1) {
        Map<Character,Character> map= new HashMap();
        Set<Character> valueSet = new HashSet();
        for(int i = 0; i < s1.length(); i++){
            char s = s1.charAt(i);
            char t = t1.charAt(i);
            if(!map.containsKey(s)){
                if(valueSet.contains(t))
                    return false;
                map.put(s, t);
                valueSet.add(t);
            
            } else{
                if(map.get(s) != t)
                    return false;
            }
        }
        return true;
    }
}