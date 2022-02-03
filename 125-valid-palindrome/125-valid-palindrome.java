class Solution {
    public boolean isPalindrome(String s) {
        if(s.trim().length() == 0)
            return true;
        // String s1 = s.toLowerCase();
        char[] arr = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < arr.length; i++){
            char c = arr[i];
            if(Character.isLetter(c)){
                sb.append(Character.toLowerCase(c));
            } else if(Character.isDigit(c)){
                sb.append(c);
            }
        }
        
        String s2 = sb.toString();
        if(s2.length() == 0)
            return true;
        int start = 0, end = s2.length() - 1;
        while(start <= end){
            if(s2.charAt(start) == s2.charAt(end)){
                start++;
                end--;
            } else{
                return false;
            }
            
        }
        
        
        return true;
        
    }
}