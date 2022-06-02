class Solution {
    List<Job> jobs = new ArrayList<>();
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int maxProfit = 0;
        for(int i = 0; i < difficulty.length; i++){
            Job job = new Job(difficulty[i], profit[i]);
            jobs.add(job);
        }
        
        Collections.sort(jobs, (j1, j2) -> j1.difficulty - j2.difficulty);
        Arrays.sort(worker);
        
        int n = jobs.size();
        int x = 0;
        int best = 0;
        for(int i = 0; i < worker.length; i++){
            while(x < n && jobs.get(x).difficulty <= worker[i]){
                best = Math.max(best, jobs.get(x).profit);
                x++;
            }
            maxProfit += best;
        }
        
        return maxProfit;
        
        
    }
    
    
    // int binarySearch(int start, int end, int value){
    //     while(start < end){
    //         int mid = (start + end) / 2;
    //         if(jobs.get(mid).difficulty == value){
    //             return jobs.get(mid).profit;
    //         }
    //         if(jobs.get(mid).difficulty > value){
    //             end = mid - 1;
    //         } else{
    //             start = mid + 1;
    //         }
    //     }
    //      return jobs.get(start).profit;
    // }
    
}

class Job{
    int difficulty;
    int profit;
    
    Job(int difficulty, int profit){
        this.difficulty = difficulty;
        this.profit = profit;
    }
}