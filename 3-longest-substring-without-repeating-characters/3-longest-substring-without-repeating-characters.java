class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0)
            return 0;
        Map<Character, Integer> map = new  HashMap<>();
        int maxLength = 0;
        int start=0;
        char[] arr= s.toCharArray();
        for(int i = 0; i < arr.length; i++){
            if(map.containsKey(arr[i])){
                if(start <= map.get(arr[i]))
                    start = map.get(arr[i]) + 1;
            }
            maxLength = Math.max(maxLength, i - start + 1);
            map.put(arr[i],i);
        }
        return maxLength;
    }
}