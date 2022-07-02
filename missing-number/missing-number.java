class Solution {
    int result = 0;
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int product = compute(n);
        System.out.println(product);
        for(int i : nums){
            product -=i;
        }
        return product;
    }
    
    int compute(int n){
        if(n == 0)
            return result;
        result = n + compute(n - 1);
        return result;
    }
}