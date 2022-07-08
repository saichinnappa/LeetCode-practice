class Solution {
    public int reverse(int x) {
        int isNegative = 1;
        if(x < 0)
            isNegative = -1;
        
        long result = 0;
        
        int val = 0;
        while(x != 0){
            val = x % 10;
            // System.out.println(val);
            result = (result * 10) + val;
            x = x / 10;
        }
        
        
        // System.out.println(result);
        // result *= isNegative;
        
        if(result > Integer.MAX_VALUE || result < Integer.MIN_VALUE)
            return 0;
        
        return (int)result;
    }
}