class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote.length() >magazine.length())
            return false;
        Map<Character, Integer> charCount = new HashMap<Character, Integer>();
        for(int i = 0; i < magazine.length(); i++){
            char c = magazine.charAt(i);
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }
        
        for(int i = 0; i < ransomNote.length();i++){
            char c = ransomNote.charAt(i);
            if(!charCount.containsKey(c))
                return false;
            else{
                charCount.put(c, charCount.get(c) - 1);
                if(charCount.get(c) < 0)
                    return false;
            }
                
        }
        return true;
    }
}