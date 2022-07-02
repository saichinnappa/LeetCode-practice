class Solution {
    public int myAtoi(String s) {
        long result = 0;
                s = s.trim();
        if(s.length() == 0)
            return 0;
        
        boolean isNegative = false;

        if(!Character.isDigit(s.charAt(0))
          && s.charAt(0) != '+' && s.charAt(0) != '-'){
            return 0;
        }

        if(s.charAt(0) == '-')
            isNegative = true;
                System.out.println(isNegative);
        for(int i = 0; i < s.length(); i++){
            if(i != 0 && !Character.isDigit(s.charAt(i)))
                break;
            if(Character.isDigit(s.charAt(i))){
                result = (result * 10) + Character.getNumericValue(s.charAt(i));
            }
            System.out.println(result);
            if(!isNegative && result >= Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            if(isNegative && (-1 * result) <= Integer.MIN_VALUE)
                return Integer.MIN_VALUE;
        }
        if(isNegative)
            result *= -1;
        return (int)result;
    }
}