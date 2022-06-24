class Solution {
    public int longestPalindrome(String s) {
        if(s.length() == 1)
            return 1;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        char[] arr = s.toCharArray();
        for(int i = 0; i < arr.length; i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        
        int length = 0;
        int odd = 0;
        for(Map.Entry<Character, Integer> entry : map.entrySet()){
             length += (entry.getValue() / 2) * 2;
        }

        
        if(length < s.length())
            length++;
        
        return length;
    }
}