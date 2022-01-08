class Solution {
    public List<List<Integer>> generate(int numRows) {
        
        List<List<Integer>> result = new ArrayList();
        if(numRows == 0)
            return result;
        
        result.add(Arrays.asList(1));
        
        for(int i = 1; i < numRows; i++){
            List<Integer> list = new ArrayList();
            for(int j = 0; j < i + 1; j++){
                if(j == 0 || j == i){
                    list.add(1);
                } else{
                    int val = result.get(i - 1).get(j - 1) + result.get(i - 1).get(j);
                    list.add(val);
                }
            }
            result.add(list);
        }
        return result;
    }
}