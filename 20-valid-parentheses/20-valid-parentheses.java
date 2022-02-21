class Solution {
    public boolean isValid(String s) {
        char[] arr = s.toCharArray();
        if(s.length() == 1)
            return false;
        Map<Character, Character> map = new HashMap<>();
        map.put('}', '{');
        map.put(')', '(');
        map.put(']', '[');
        
        if(map.containsKey(s.charAt(0))){
            return false;
        }
        
        Stack<Character> stack = new Stack();
        
        
        for(int i = 0; i < arr.length; i++){
            if(!map.containsKey(arr[i]))
                stack.push(arr[i]);
            else{

                if(stack.size() == 0) return false;
                char top = stack.pop();
                if(map.get(arr[i]) != top)
                    return false;
                // }    
            }
            
        }

        
        return stack.size() == 0;
        
        
    }
}