class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        solve(k, n, 0, new ArrayList<>(), 1);
        return result;
    }
    
    void solve(int k, int n , int sum, List<Integer> list, int val){
        if(list.size() == k && sum == n){
            result.add(new ArrayList<>(list));
            return;
        }
        for(int i = val; i < 10; i++){
            sum += i;
            list.add(i);
            if(sum <= n)
                solve(k, n, sum, list, i + 1);
            sum -= i;
            list.remove(list.size() - 1);
        }
    }
}