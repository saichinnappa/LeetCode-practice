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
            for(int x = i; x < m; x++){
                arr[k++] = nums1[x];
            } 
        }
        if(j != n){
            for(int x = j; x < n; x++){
                arr[k++] = nums2[x];
            }
        }
        System.out.println(Arrays.toString(arr));
        double result;
        int mid = k / 2;
        if(k % 2 == 0){
            result = Double.valueOf(arr[mid] + arr[mid - 1]) /2;
            
        } else{
            result = arr[mid];
        }
        return (double)result;
    }
}