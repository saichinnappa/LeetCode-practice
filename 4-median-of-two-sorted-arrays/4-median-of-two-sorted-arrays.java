class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] newArray = new int[nums1.length + nums2.length];
        int i = 0;
        for(int n : nums1){
            newArray[i] = nums1[i];
            i++;
        }
        int j = 0;
        for(int n : nums2){
            newArray[i] = nums2[j];
            i++;
            j++;
        }
        Arrays.sort(newArray);
        int mid = newArray.length / 2;
        System.out.println(mid);
        double median = 0;
        if(newArray.length % 2 == 0){
            double mid1 = newArray[mid] + newArray[mid - 1];
            
            median = Double.valueOf(mid1 / 2);
        } else{
            mid = newArray[mid];
            median = Double.valueOf(mid);
        }
        
        return median;
    }
}