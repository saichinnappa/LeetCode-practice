class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        int[] result = new int[k];
        
        PriorityQueue<Pair> queue = new PriorityQueue<>(new PairComparator());
        
        Map<Integer, Integer> map = new HashMap();
        
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i]))
                map.put(nums[i], map.get(nums[i]) + 1);
            else
                map.put(nums[i], 1);
        }
        
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            queue.offer(new Pair(entry.getKey(), entry.getValue()));
        }
        
        int i = 0;
        while(k != 0){
            result[i] = queue.poll().value;
            i++;
            k--;
        }
        
        
        return result;
    }
}

class Pair{
    int value;
    int freq;
    
    Pair(int value,int freq){
        this.value = value;
        this.freq = freq;
    }
}


class PairComparator implements Comparator<Pair>{
    public int compare(Pair p1, Pair p2){
        if(p1.freq < p2.freq)
            return 1;
        else if(p1.freq > p2.freq)
            return -1;
        else
            return 0;
    }
}