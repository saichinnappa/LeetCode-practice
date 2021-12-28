class Solution {
    public int romanToInt(String s) {
        
        
        if (s == null || s.length() == 0)
		return -1;
        
        Map<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);
        
        char[] input = s.toCharArray();
        
        
        int result = 0;
        
        for(int i=0; i<input.length;i++){
            
            if((i+1) <= input.length-1 && romanMap.get(input[i+1]) > romanMap.get(input[i])){
                result += (romanMap.get(input[i+1]) - romanMap.get(input[i]));
                i++;
            }
            else
                result += romanMap.get(input[i]);
            
        }
          return result;      
        }
    
}