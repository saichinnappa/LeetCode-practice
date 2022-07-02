class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums);
        int count = 0;
        int start = 0;
        for(int i = 0; i < nums.length; i++){
            if(i == 0){
                start= nums[i];
                count++;
            }
            else if(start == nums[i]){
                count++;
            } else{
                start = nums[i];
                count = 1;
            }
            if(count > nums.length / 3){
                if(!set.contains(nums[i])){
                    result.add(nums[i]);
                    set.add(nums[i]);
                }
            }
        }
        return result;
    }
}   