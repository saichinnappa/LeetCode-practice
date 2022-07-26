class Solution {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        
        int result = 0;
        
        for(List<String> item : items){
            switch(ruleKey){
                case "type": if(item.get(0).equals(ruleValue)) result++;
                break;    
                case "color": if(item.get(1).equals(ruleValue)) result++;
                break;    
                case "name": if(item.get(2).equals(ruleValue)) result++;
                break;   
            }
        }
        return result;
    }
}