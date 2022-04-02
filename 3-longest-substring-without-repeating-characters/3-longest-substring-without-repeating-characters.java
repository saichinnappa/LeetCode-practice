class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0)
            return 0;
        int length = 0;
        int start = 0;
        char[] arr = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            if(map.containsKey(arr[i])){
                if(map.get(arr[i]) >= start){
                    start = map.get(arr[i]) + 1;
                }
            }
            map.put(arr[i], i);
            length = Math.max(length, i - start + 1);
        }
        return length;
    }
}