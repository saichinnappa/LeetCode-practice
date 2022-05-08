class Solution {
    int[] memo = new int[500001];
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
                Arrays.fill(memo, -1);
        //Build one list with jobs
        List<List<Integer>> jobs = new ArrayList<>();
        for(int i = 0; i< startTime.length; i++){
            List<Integer> job = new ArrayList<>();
            job.add(startTime[i]);
            job.add(endTime[i]);
            job.add(profit[i]);
            jobs.add(job);
        }
        
        //Sort jobs by start time
        jobs.sort((j1, j2) -> j1.get(0) - j2.get(0));
        
        for(int i = 0;  i < startTime.length; i++){
            startTime[i] = jobs.get(i).get(0);
        }
        
        return maxProfit(startTime, jobs, startTime.length, 0);
        
    }
    
    
    int maxProfit(int[] startTime, List<List<Integer>> jobs, int n, int position){
        
        if(position == n)
            return 0;
        
        if(memo[position] != -1)
            return memo[position];
        
        //find next job which doesnt overlap with current job end time
        int nextIndex = findNextIndex(startTime, jobs.get(position).get(1)); 
        
        int profit = Math.max(maxProfit(startTime, jobs, n, position + 1), maxProfit(startTime, jobs, n, nextIndex) + jobs.get(position).get(2));
        return memo[position] = profit;
        
    }
    
    
    
    int findNextIndex(int[] startTime, int val){
        

        int start = 0, end = startTime.length - 1, nextIndex = startTime.length;
        
        while(start <= end){
            int mid = (start + end) / 2 ;
            if(startTime[mid] >= val){
                nextIndex = mid;
                end = mid - 1;
            } else{
                start = mid + 1;
            }
        }
        
        return nextIndex;
    }
    
    
}