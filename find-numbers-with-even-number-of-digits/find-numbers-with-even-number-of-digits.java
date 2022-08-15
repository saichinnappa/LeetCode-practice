class Solution {
    public int findNumbers(int[] nums) {
        int result = 0;
        for(int n : nums){
            int r = n;
            int count = 0;
            while(r!= 0){
                r /= 10;
                System.out.println(r);
                count++;
            }
            
            if(count % 2 == 0)
                result++;
            
        }
        
        return result;
    }
}