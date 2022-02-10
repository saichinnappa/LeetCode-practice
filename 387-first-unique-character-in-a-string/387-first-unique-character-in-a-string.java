class Solution {
    public int firstUniqChar(String s) {
        int[] count = new int[26];
        char[] sarr = s.toCharArray();
        for(int i = 0; i < sarr.length; i++){
            count[sarr[i] - 'a']++;
        }
        
        for(int i = 0 ; i < sarr.length; i++){
            if(count[s.charAt(i) - 'a'] == 1)
                return i;
        }
        return - 1;
    }
}