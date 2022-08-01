class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int result = -1;
        int maxValue = arr[0];
        for(int i = 1; i < arr.length; i++){
            if(arr[i] > maxValue){
                maxValue = arr[i];
                result = i;
            }
        }
        
        return result;
    }
}