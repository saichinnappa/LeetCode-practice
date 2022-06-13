class Solution {
    int[] memo = new int[500001];
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
                Arrays.fill(memo, -1);
        //Build one list with jobs
        Arrays.fill(memo, - 1);
        List<Job> jobs = new ArrayList<>();
        for(int i = 0; i < startTime.length; i++){
            Job job = new Job(startTime[i], endTime[i], profit[i]);
            jobs.add(job);
        }

        jobs.sort((j1, j2) -> j1.startTime - j2.startTime);

        
        for(int i = 0;  i < startTime.length; i++){
            startTime[i] = jobs.get(i).startTime;
        }
        
        return maxProfit(startTime, jobs, startTime.length, 0);
        
    }
    
    
    int maxProfit(int[] startTime, List<Job> jobs, int n, int position){
        
        if(position == n)
            return 0;
        
        if(memo[position] != -1)
            return memo[position];
        
        //find next job which doesnt overlap with current job end time
        int nextIndex = findNextIndex(startTime, jobs.get(position).endTime); 
        
        int profit = Math.max(maxProfit(startTime, jobs, n, position + 1), maxProfit(startTime, jobs, n, nextIndex) + jobs.get(position).profit);
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

class Job{
    int startTime;
    int endTime;
    int profit;

    Job(int startTime, int endTime, int profit){
        this.startTime = startTime;
        this.endTime = endTime;
        this.profit = profit;
    }
}
