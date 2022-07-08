class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for(String s : words){
            map.putIfAbsent(s, 0);
            map.put(s, map.get(s) + 1);
        }
        
        ArrayList<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(new MapComparator());
        
        for(int i = 0; i < k; i++){
            result.add(list.get(i).getKey());
        }
        
        return result;
    }
}

class MapComparator implements Comparator<Map.Entry<String, Integer>> {
    @Override
    public int compare(Map.Entry<String,Integer> e1, Map.Entry<String, Integer> e2){
        if(e1.getValue() == e2.getValue())
            return e1.getKey().compareTo(e2.getKey());
        return e2.getValue().compareTo(e1.getValue());
    }
}