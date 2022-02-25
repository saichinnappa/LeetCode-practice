class Solution {
    public boolean isPalindrome(String s) {
        if(s.length() == 0)
            return true;
        StringBuilder sb = new StringBuilder();
        char[] input = s.toCharArray();
        for(int i = 0; i < input.length; i++){
            if(Character.isLetter(input[i])){
                sb.append(Character.toLowerCase(input[i]));
            }
            if(Character.isDigit(input[i])){
                sb.append(input[i]);
            }
        }
        return check(sb.toString());
    }
    
    private boolean check(String s){
        
        int start = 0;
        int end = s.length() - 1;
        char[] input = s.toCharArray();
        while(start < end){
            if(input[start] == input[end]){
                start++;
                end--;
            } else{
                return false;
            }
        }
        return true;
    }
}