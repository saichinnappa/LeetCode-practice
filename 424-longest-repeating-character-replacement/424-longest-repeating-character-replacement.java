class Solution {
    public int characterReplacement(String s, int k) {
            
        char[] arr = s.toCharArray();
        int max = 0;
        int maxCount = 0;
        int[] count = new int[26];
        int start = 0;
        
        for(int i = 0; i< arr.length; i++){
            maxCount = Math.max(maxCount, ++count[arr[i] - 'A']);
            if((i - start + 1) - maxCount <= k){
                max = Math.max(max, i - start + 1);
            } else{
                count[arr[start] - 'A']--;
                start++;
                
            }
        }
        return max;
    }
    
}