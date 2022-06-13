/**
Initial search sapce 1 to m, takes log m comparisions to reduce search space to 1.
For each eating speed middle, we traverse the array -> O(n)
Overall O(n.logm)
**/
class Solution {
    public int minEatingSpeed(int[] orders, int hours) {
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
        
//         int maxValue = Integer.MIN_VALUE;
//         for(int i = 0; i< piles.length; i++){
//             maxValue = Math.max(piles[i], maxValue);
//         }
//         int start = 1;
//         int end = maxValue;
        
//         int mid = (start + end) / 2;
//         int result = Integer.MAX_VALUE;
        
//         while(start <= end){
//             int totalSpeed = 0;

//             for(int i = 0; i< piles.length; i++){
//                 totalSpeed += Math.ceil((double)piles[i] / mid);
//                 if(totalSpeed > h){
//                     start = mid + 1;
//                     break;
//                 }
//             }
//             if(totalSpeed <= h){
//                 end = mid - 1;
//                 result = Math.min(mid, result);
                
//             }
            
//             mid = (start + end)/2;
//             // 
//             totalSpeed = 0;
//         }
        
//         return result;
        
//     }
        
        
        int left = 1, right = 1;

        // find max orders for upper limit of search. You will never deliver more than max orders in any hour.
        // You can also use Integer.MAX_VALUE
        for (int order : orders) {
            right = Math.max(right, order);
        }

        // binary search
        while (left < right) {

            // We start with speed = middle; and then move left or right.
            int middle = (left + right) / 2;

            int hourSpent = 0;

            // Iterate over the orders and calculate hourSpent.
            // We increase the hourSpent by ceil (order / middle)
            for (int order : orders) {
                hourSpent += Math.ceil((double) order / middle);
            }

            // cut the search space by half based on whether the speed can be further optimized
            if (hourSpent <= hours) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }

        // Once the left and right boundaries coincide, we find the target value,
        // that is, the minimum speed of delivery.
        return right;
    }
        
}