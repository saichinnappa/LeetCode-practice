class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        char[] arr = s.toCharArray();
        int start = 0;
        int result = 0;
        
        Map<Character, Integer> map = new HashMap();
        
        for(int i = 0; i < arr.length; i++){
            if(map.containsKey(arr[i])){
                if(map.get(arr[i]) >= start){
                    start = map.get(arr[i]) + 1;
                }
            }
            map.put(arr[i], i);
            result = Math.max(result, i - start + 1);
        }
        
        return result;
    }
}