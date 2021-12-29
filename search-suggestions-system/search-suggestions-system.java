class Solution {
    
    List<List<String>> result = new ArrayList();
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        if(searchWord.length() == 0)
            return result;
        
        //BruteForce
        int start = 0;
        int end = 1;
        // Arrays.sort(products);
        for(Character c : searchWord.toCharArray()){
            helper(products, searchWord, start, end);    
            end = end + 1;
        }
        return result;
    }
    
    void helper(String[] products, String searchWord, int start, int end){
        LinkedList<String> list = new LinkedList();
        for(int i = 0; i< products.length; i++)
        {
            String subString = searchWord.substring(start, end);
            if(products[i].length() >= end && products[i].substring(start, end).equals(subString)){
                list.add(products[i]);
            }
        }
       Collections.sort(list);
        if(list.size() > 3){
            int size = list.size();
            while(size != 3){
                list.removeLast();
                size--;
            }
        }
        
        result.add(list);
    }
}