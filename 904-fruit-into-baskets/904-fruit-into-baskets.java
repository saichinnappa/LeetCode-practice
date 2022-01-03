class Solution {
    public int totalFruit(int[] fruits) {
        int k = 2;
        int startWindow = 0;
        int result = 0;
        Map<Integer, Integer> map = new HashMap();
        for(int i = 0; i< fruits.length; i++){
            map.put(fruits[i], map.getOrDefault(fruits[i], 0) + 1);
            while(map.size() > k){
                int first = fruits[startWindow];
                map.put(first, map.get(first) - 1);
                if(map.get(first) == 0)
                    map.remove(first);
                startWindow++;
            }
            result = Math.max(result, i - startWindow + 1);
        }
        return result;
    }
}