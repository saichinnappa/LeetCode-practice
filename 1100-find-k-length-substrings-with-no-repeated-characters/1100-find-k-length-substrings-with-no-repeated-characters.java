class Solution {
    Set<String> set = new HashSet<>();
    int count = 0;
    public int numKLenSubstrNoRepeats(String s, int k) {
        if(s.length() == 0 || s.length() < k)
            return 0;
        
        int start = 0;
        Set<Character> currentWindow = new HashSet<>();
        for(int end = 0; end < s.length(); end++){
            if(currentWindow.contains(s.charAt(end))){
                currentWindow.remove(s.charAt(start++));
                end--;
                // start++;
            }else{
                currentWindow.add(s.charAt(end));
            }
            // String subStr = s.substring(start, end + 1);
            if(currentWindow.size() == k){
                // System.out.println(subStr);
                // set.add(subStr);
                count += 1;
                currentWindow.remove(s.charAt(start++));
            }
            
        }
        return count;
    }
}