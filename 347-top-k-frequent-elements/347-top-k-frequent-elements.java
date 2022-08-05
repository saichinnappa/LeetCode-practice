class Solution {
    int[] nums;
    Map<Integer, Integer> map = new HashMap<>();
    public int[] topKFrequent(int[] num, int k) {
        
        for(int n1 : num){
            map.put(n1, map.getOrDefault(n1, 0) + 1);
        }
        
        this.nums = new int[map.size()];
        int i = 0;
        for(int n : map.keySet()){
            nums[i] = n;
            i++;
        }
        int n = this.nums.length;
        quickselect(n - k, 0, nums.length - 1);
        return Arrays.copyOfRange(this.nums, n - k, n);
        
    }
    
    void quickselect(int k, int left, int right){
        if(left == right)
            return;
        
        int pivot = partition(left, right);
        if(pivot == k){
           return;
            
           
        } else if(pivot > k){
         quickselect(k, left, pivot - 1);
        }else
        
         quickselect(k, pivot + 1, right);
        
    }
    
    
    int partition(int start, int end){
        int partitionIndex = start - 1;
        int pivot = map.get(this.nums[end]);
        for(int i = start; i <= end; i++){
            if(map.get(this.nums[i]) <= pivot){
                partitionIndex++;
                int temp = this.nums[partitionIndex];
                this.nums[partitionIndex] = this.nums[i];
                this.nums[i] = temp;
            }
        }
        return partitionIndex;
    }
    
    
    
    
    /*public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Pair> map = new HashMap();
        for(int i : nums){
            if(!map.containsKey(i))
                map.put(i, new Pair(i, 1));
            else{
                Pair p = map.get(i);
                map.put(i, new Pair(i,p.freq + 1));
            }
        }
        
        PriorityQueue<Pair> queue = new PriorityQueue(new myComparator());
        
        for(Map.Entry<Integer, Pair> entry : map.entrySet()){
            queue.offer(entry.getValue());
        }
        
        int[] result = new int[k];
        for(int i = 0; i < k; i++){
            result[i] = queue.poll().val;
        }
        return result;
    }
}

class Pair{
    int val;
    int freq;
    
    Pair(int val, int freq){
        this.val = val;
        this.freq = freq;
    }
}

public class myComparator implements Comparator<Pair>{
    @Override
    public int compare(Pair p1, Pair p2){
        if(p1.freq > p2.freq)
            return -1;
        else if(p1.freq < p2.freq)
            return 1;
        else
            return 0;
    } */
}