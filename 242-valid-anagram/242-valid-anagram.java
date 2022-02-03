class Solution {
    public boolean isAnagram(String s, String t) {
        
        //Approach 1 - Sorting
        // char[] sArr = s.toCharArray();
        // Arrays.sort(sArr);
        // char[] tArr = t.toCharArray();
        // Arrays.sort(tArr);
        // String s1 = new String(sArr);
        // String s2 = new String(tArr);
        // return s1.equals(s2);
        
        // Approach 2 - Counter
        if(s.length() != t.length())
            return false;
        int[] counter = new int[26];
        for(int i = 0 ; i < s.length(); i++){
            counter[s.charAt(i) - 'a']++;
        }
        for(int j = 0; j < t.length(); j++){
            counter[t.charAt(j) - 'a']--;
        }
        
        for(int i = 0; i< counter.length; i++){
            if(counter[i] > 0)
                return false;
        }
        
        return true;
    }
}