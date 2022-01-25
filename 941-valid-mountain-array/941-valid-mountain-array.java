class Solution {
    public boolean validMountainArray(int[] arr) {
        if(arr.length < 3)
            return false;
        
        int maxIndex = -1;
        int maxValue = Integer.MIN_VALUE;
        for(int i = 0; i< arr.length; i++){
            if(maxValue < arr[i]){
                maxIndex = i;
                maxValue = Math.max(maxValue, arr[i]);
            } else if(maxValue == arr[i]){
                return false;
            }
        }
        
        if(maxIndex == arr.length - 1 || maxIndex == 0) return false;
        
        int i = 1, j = maxIndex + 1;
        
        while(i != maxIndex){
            if(arr[i - 1] < arr[i]){
                i++;
            } else{
                return false;
            }
        }
        
        while( j != arr.length - 1){
            if(arr[j] > arr[j + 1]){
                j++;
            } else{
                return false;
            }
        }
        
        
        // for(int i = 0; i< arr.length; i++){
        //     if( i < maxIndex || i > maxIndex){
        //         if(arr[i] >= arr[maxIndex]){
        //             return false;
        //         }
        //     }  
        // }
        return true;
    }
}