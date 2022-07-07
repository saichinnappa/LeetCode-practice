class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        int k = 0;
        List<Integer> list = new ArrayList<>();
        while(i != nums1.length && j != nums2.length){
            if(nums1[i] < nums2[j]){
                i++;
            } else if(nums1[i] > nums2[j]){
                j++;
            } else{
                
                nums1[k] = nums1[i];
                k++;
                i++;
                j++;
            }
        }
//         int[] result = new int[list.size()];
//         for(int k = 0; k < list.size(); k++){
            
//             result[k] = list.get(k);
            
//         }
         
        return Arrays.copyOfRange(nums1, 0, k);
    }
}