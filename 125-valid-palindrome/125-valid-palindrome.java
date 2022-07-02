class Solution {
    public boolean isPalindrome(String s) {
        if(s.trim().length() == 0)
            return true;
        char[] arr = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < arr.length; i++){
            if(Character.isLetter(arr[i]) || Character.isDigit(arr[i])){
                sb.append(arr[i]);
            }
        }
        // System.out.println(sb.toString());
        return isValid(sb.toString().toLowerCase());
        
    }
    
    boolean isValid(String s){
        int start = 0;
        int end = s.length() - 1;
        while(start < end){
            if(s.charAt(start) == s.charAt(end)){
                start++;
                end--;
            } else{
                return false;
            }
        }
        return true;
    }
}