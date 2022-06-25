class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() <= 1){
            return s.length();
        }
        int length = 0;
        int start = 0;
        char[] arr = s.toCharArray();
        Map<Character, Integer> charMap = new HashMap<Character, Integer>();
        for(int i = 0; i < arr.length; i++){
            if(charMap.containsKey(arr[i])){
                if(start <= charMap.get(arr[i])){
                    start = charMap.get(arr[i]) + 1;
                }
            }
            length = Math.max(length, (i - start) + 1);
            charMap.put(arr[i], i);
        }
        
        return length;
    }
}