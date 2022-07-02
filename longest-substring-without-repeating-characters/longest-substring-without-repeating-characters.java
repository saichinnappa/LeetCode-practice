class Solution {
    public int lengthOfLongestSubstring(String s) {
        int length = 0, start = 0;
        char[] arr = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            char c = arr[i];
            if(map.containsKey(c)){
                if(start <= map.get(c)){
                    start = map.get(c) + 1;
                }
            }
            map.put(c, i);
            length = Math.max(length, i - start + 1);
        }
        return length;
    }
}