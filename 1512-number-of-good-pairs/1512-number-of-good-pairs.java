class Solution {
    public int numIdenticalPairs(int[] nums) {
        int arr[] = new int[101];
        for(int item: nums){
            arr[item]++;
        }
        
        int sum = 0;
        for(int item: arr){
            sum += (item*(item-1))/2;
        }
        return sum;
    }
}