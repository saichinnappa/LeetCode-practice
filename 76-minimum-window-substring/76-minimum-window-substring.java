class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < t.length())
            return "";
        char[] sarr = s.toCharArray();
        char[] tarr = t.toCharArray();
        
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < tarr.length; i++){
            map.putIfAbsent(tarr[i], 0);
            map.put(tarr[i], map.get(tarr[i]) + 1);
        }
        
        int result = 0;
        int minLength = Integer.MAX_VALUE;
        int start = 0;
        int subStr = 0;
        for(int i = 0; i < sarr.length; i++){
            char c = sarr[i];
            if(map.containsKey(c)){
                map.put(c, map.get(c) - 1);
                if(map.get(c) == 0){
                    result++;
                }
            }
            while(result == map.size()){
                int currLength = i - start + 1;
                System.out.println(currLength);
                if(minLength > currLength){
                    minLength = currLength;
                    subStr = start;
                }
                
                char startChar = sarr[start];
                if(map.containsKey(startChar)){
                    map.put(startChar, map.get(startChar) + 1);
                    if(map.get(startChar) > 0)
                        result--;
                }
                start++;
            }
            
        }
        return minLength == Integer.MAX_VALUE ?  "" : s.substring(subStr, subStr + minLength);
    }
}