class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        //BRUTE FORCE - TLE
        
//         int totalSpeed = 0;
//         int currentSpeed = 1;  
//         while(true){
//             // System.out.println("CurrentSpeed-->"+currentSpeed);
//             for(int j = 0; j < piles.length; j++){
//                 totalSpeed += Math.ceil((double)piles[j] / currentSpeed);
//                 // System.out.println("TotalSpeed-->"+totalSpeed);
//                 if(totalSpeed > h)
//                     break;
//             }
//             if(totalSpeed <= h)
//                 break;
//             else{
//                 totalSpeed = 0;
//                 currentSpeed++;
//             }
            
//         }
//         return currentSpeed;
        
        
        // BINARY SEARCH
        
        int maxValue = Integer.MIN_VALUE;
        for(int i = 0; i< piles.length; i++){
            maxValue = Math.max(piles[i], maxValue);
        }
        int start = 1;
        int end = maxValue;
        int totalSpeed = 0;
        int mid = (start + end) / 2;
        int result = Integer.MAX_VALUE;
        
        while(start <= end){
            for(int i = 0; i< piles.length; i++){
                totalSpeed += Math.ceil((double)piles[i] / mid);
                // System.out.println("TotalSpeed==> "+totalSpeed);
                if(totalSpeed > h){
                    start = mid + 1;
                    break;
                }
            }
            if(totalSpeed <= h){
                end = mid - 1;
                result = Math.min(mid, result);
                
            }
            // System.out.println("Start = "+start+" End = "+end);
            mid = (start + end)/2;
            totalSpeed = 0;
        }
        
        return result;
        
    }
}