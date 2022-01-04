class Solution {
    public int characterReplacement(String s, int k) {
        // if(k == 0)
        //     return 0;
        
        char[] arr = s.toCharArray();
        char[] count = new char[26];
        Map<Character, Integer> map = new HashMap();
        int result = 0, maxCount = 0, startWindow = 0;
        
        for(int i = 0; i < arr.length; i++){
            count[arr[i] - 'A']++;
            // map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            maxCount = Math.max(maxCount, count[arr[i] - 'A']);
            if((i - startWindow + 1 - maxCount) > k){
                count[arr[startWindow] - 'A']--;
                // map.put(arr[startWindow], map.get(arr[startWindow]) - 1);
                startWindow++;
            }
            result = Math.max(result, i - startWindow + 1);
        }
        
        
        return result;
    }
}