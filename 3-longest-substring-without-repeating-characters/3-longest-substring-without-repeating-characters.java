class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        if(s.length() <= 1)
            return s.length();
        
        char[] arr = s.toCharArray();
        
        int max = 0;
        int start = 0;
        Map<Character, Integer> map = new HashMap();
        
        for(int i = 0 ; i < arr.length; i++){
            if(map.containsKey(arr[i])){
                if(start <= map.get(arr[i]))
                    start = map.get(arr[i]) + 1;
            }
            max = Math.max(max, i - start + 1);
            map.put(arr[i], i);
        }
        
        return max;
        
    }
}