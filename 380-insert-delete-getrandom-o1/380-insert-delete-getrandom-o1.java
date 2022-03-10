class RandomizedSet {
    
    List<Integer> list;
    Map<Integer, Integer> map;
    Random random;

    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val))
            return false;
        map.put(val, list.size());
        list.add(list.size(), val);
        // System.out.println(list);
        return true;
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val)){
            return false;
        }
        
        int index = map.get(val);
        int temp = list.get(index);
        map.put(list.get(list.size() - 1), index);
        map.remove(val);
        int lastElement = list.get(list.size() - 1);
        // System.out.println(list.size()+"<<<Before");
        list.set(index, lastElement);
        list.remove(list.size() - 1);
        // System.out.println(list.size()+"<<<AFter");
        // System.out.println(list+"<<<<");

        // System.out.println(list);
        // list.add(list.size() - 1, temp);
        
        return true;
    }
    
    public int getRandom() {
        // System.out.println(list.size()+"<<<<");
        return list.get(random.nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */