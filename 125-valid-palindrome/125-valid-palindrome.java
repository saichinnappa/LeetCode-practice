class Solution {
    public boolean isPalindrome(String s) {
        if(s.length() == 0)
            return true;
        char[] arr = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < arr.length; i++){
            if(Character.isDigit(arr[i]))
                sb.append(arr[i]);
            if(Character.isLetter(arr[i])){
                if(Character.isUpperCase(arr[i])){
                    sb.append(Character.toLowerCase(arr[i]));    
                } else
                    sb.append(arr[i]);
            }
        }
        
        return checkPalindrom(sb.toString());
    }
    
    boolean checkPalindrom(String s){
        int start = 0;
        int end = s.length() - 1;
        while(start <= end){
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