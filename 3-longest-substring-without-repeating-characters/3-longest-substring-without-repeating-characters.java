class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char[] arr = s.toCharArray();
        int maxLength = 0;
        int start = 0;
        for(int i = 0; i < arr.length; i++){
            if(map.containsKey(arr[i])){
                if(start <= map.get(arr[i]))
                    start = map.get(arr[i]) + 1;
            }
            map.put(arr[i], i);
            maxLength = Math.max(maxLength, i - start + 1);
        }
        return maxLength;
    }
}