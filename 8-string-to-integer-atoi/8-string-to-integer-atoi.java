class Solution {
    public int myAtoi(String s) {

        long result = 0;
        s = s.trim();
                if(s.length() == 0)
            return 0;
        boolean isNegative = false;
        char[] input = s.toCharArray();
        if(input[0] == '-')
            isNegative = true;
        for(int i = 0; i < input.length; i++){
            if( i == 0 && (input[i] == '+' || input[i] == '-'))
                continue;
            if(!Character.isDigit(input[i]))
                break;
            result = (result * 10) + (input[i] - '0');
            if(!isNegative && result > Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }
            if(isNegative && (result * -1) < Integer.MIN_VALUE){
                return Integer.MIN_VALUE;
            }
        }
    
        if(isNegative)
        result *= -1;
        return (int)result;
        
    }
}