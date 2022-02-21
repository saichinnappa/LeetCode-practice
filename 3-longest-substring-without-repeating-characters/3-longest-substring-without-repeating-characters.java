class Solution {
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        if(s.length() == 0)
            return result;
        char[] arr = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        int start = 0;
        for(int i = 0 ;i < arr.length; i++){
            if(map.containsKey(arr[i])){
                if(start <= map.get(arr[i]))
                    start = map.get(arr[i]) + 1;
            }
            map.put(arr[i], i);
            result = Math.max(result, i - start + 1);
        }
        return result;
    }
}