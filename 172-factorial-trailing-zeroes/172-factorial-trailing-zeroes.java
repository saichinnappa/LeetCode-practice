class Solution {
    public int trailingZeroes(int n) {
//         int result = 1;
        
//         for(int i = n; i > 0; i--){
//             result *=i;
//         }
        
//         System.out.println(result);
        
//         int count = 0;
//         int x = 0;
//         while(result != 0){
//             x = result % 10;
//             System.out.println(x);
//             if(x == 0)
//                 count++;
//             else
//                 break;
//             result /= 10;
//         }
//         return count;
        
        int count=0;
        for(int i=5;i<=n;i=i*5)
            count+=n/i;
        return count;
    }
}