class Solution {
    public void reverseString(char[] s) {
        if(s.length <= 1 )
            return;
        int start = 0;
        int end = s.length - 1;
        
        while(start < end){
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
        
    }
}