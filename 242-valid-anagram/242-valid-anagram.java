class Solution {
    public boolean isAnagram(String s, String t) {
        
        //Approach 1 - Sorting
        char[] sArr = s.toCharArray();
        Arrays.sort(sArr);
        char[] tArr = t.toCharArray();
        Arrays.sort(tArr);
        String s1 = new String(sArr);
        String s2 = new String(tArr);
        return s1.equals(s2);
        
    }
}