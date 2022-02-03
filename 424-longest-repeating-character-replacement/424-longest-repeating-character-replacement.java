class Solution {
    public int characterReplacement(String s, int k) {
        
        int max = 0;
        char[] arr = s.toCharArray();
        int[] count = new int[26];
        int start = 0;
        int maxCount = 0;
        
        for(int i = 0; i < arr.length; i++){
            
            maxCount = Math.max(maxCount, ++count[arr[i] - 'A']); //increment the count of the current character in the counter
            if((i - start + 1) - maxCount <= k){
                System.out.println(arr[i]+"->"+count[arr[i]-'A']);
                max = Math.max(max, i - start + 1);
            } else{
          
                count[arr[start] - 'A']--;
                      start++;
            }
            
            
        }
        
        return max;
    }
}