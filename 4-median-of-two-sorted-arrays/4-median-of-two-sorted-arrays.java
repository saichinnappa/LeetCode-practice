class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] arr = new int[m + n];
        int i = 0;
        int j = 0;
        int k = 0;
        while(i < m && j < n){
            if(nums1[i] < nums2[j]){
                arr[k] = nums1[i];
                i++;
            } else{
                arr[k] = nums2[j];
                j++;
            }
            k++;
        }
        
        
        if(i != m){
            System.arraycopy(nums1, i, arr,k, (m -i)); 
            k += (m-i);
        }
        if(j != n){
            System.arraycopy(nums2, j, arr,k, (n -j)); 
            k += (n-j);
        }
        double result;
        int mid = k / 2;
        if(k % 2 == 0){
            result = Double.valueOf(arr[mid] + arr[mid - 1]) /2;
            
        } else{
            result = arr[mid];
        }
        return result;
    }
}