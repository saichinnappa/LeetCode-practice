class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int max = -1;
        int totalWeight = 0;
        for(int w : weights){
            max = Math.max(w, max);
            totalWeight += w;
        }
        int result = 0;
        while(max <= totalWeight){
            int mid = (max + totalWeight) / 2;
            if(isPossible(mid, days, weights)){
                result = mid;
                totalWeight = mid - 1;
            } else{
                max = mid + 1;
            }
        }
        return result;
    }
    
    private boolean isPossible(int w, int days, int[] weights){
    int result = 1;
    int cw = 0;
    for(int i = 0; i < weights.length; i++){
        cw += weights[i];
         if(cw > w){
            result++;
            cw = weights[i];   
        }
        if(result > days)
            return false;
    }
        return true;
    }
}