class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Pair> map = new HashMap();
        for(int i : nums){
            if(!map.containsKey(i))
                map.put(i, new Pair(i, 1));
            else{
                Pair p = map.get(i);
                map.put(i, new Pair(i,p.freq + 1));
            }
        }
        
        PriorityQueue<Pair> queue = new PriorityQueue(new myComparator<Pair>());
        
        for(Map.Entry<Integer, Pair> entry : map.entrySet()){
            queue.offer(entry.getValue());
        }
        
        List<Integer> result = new ArrayList<Integer>();
        while(k != 0){
            
                result.add(queue.poll().val);
            k--;
        }
        int[] arr = new int[result.size()];
        // return result.toArray(arr);
        return result.stream().mapToInt(i->i).toArray();
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

public class myComparator<T> implements Comparator<Pair>{
    @Override
    public int compare(Pair p1, Pair p2){
        if(p1.freq > p2.freq)
            return -1;
        else if(p1.freq < p2.freq)
            return 1;
        else
            return 0;
    }
}