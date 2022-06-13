class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        List<Job> jobList = new ArrayList<>();
        for(int i = 0; i < difficulty.length; i++){
            Job job = new Job(difficulty[i], profit[i]);
            jobList.add(job);
        }
        jobList.sort((j1, j2) -> j1.difficulty - j2.difficulty);
        Arrays.sort(worker);
        
        int maxProfit = 0;
        int n = jobList.size();
        int j = 0;
        int best = 0;
        for(int i = 0; i < worker.length; i++){
            while(j < n && jobList.get(j).difficulty <= worker[i]){
                best = Math.max(best, jobList.get(j).profit);
                j++;
            }
            maxProfit += best;
        }
        return maxProfit;
    }
}
class Job{
    int difficulty;
    int profit;
    
    Job(int difficulty, int profit){
        this.difficulty = difficulty;
        this.profit = profit;
    }
}