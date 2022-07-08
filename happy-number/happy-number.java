class Solution {
    public boolean isHappy(int n) {
        
        Set<Integer> nums = new HashSet();
        int x = n;
        while( n != 1){
            
            int ans = 0;
            
            while(n != 0){
                ans += Math.pow(n % 10, 2);
                n = n /10;
            }
            
            
            if(nums.contains(ans))
                return false;
            
            nums.add(ans);
            
           n = ans;
            
        }
        
        return true;
        
    }
}