class Solution {
    public int[] plusOne(int[] digits) {
        int length = digits.length;
        
        if(digits[length - 1] < 9){
            digits[length - 1]++;
            return digits;
        }
        
        int carry = 1;
        for(int i = digits.length - 1; i > -1 ; i--){
            if(carry == 1 && digits[i] == 9){
                digits[i] = 0;
                carry = 1;
            } else{
                digits[i] += carry;
                carry = 0;
            }
        }
        
        if(carry == 1){
            int[] result = new int[digits.length + 1];
            result[0] = carry;
            System.arraycopy(digits, 0, result, 1, length);
            return result;
        }
        
        
        return digits;
    }
}