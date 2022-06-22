class Solution {
    public boolean isPalindrome(String s) {
        if(s.length() == 1)
            return true;
        
        char[] arr = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(char c : arr){
            if(Character.isLetter(c) || Character.isDigit(c)){
                sb.append(Character.toLowerCase(c));
            }
        }
        
        String newS = sb.toString();
        
        int start = 0, end = newS.length() - 1;
        
        while(start <= end){
            if(newS.charAt(start) == newS.charAt(end)){
                start++;
                end--;
            } else{
                return false;
            }
        }
     return true;   
    }
}