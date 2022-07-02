class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        char[] arr = s.toCharArray();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int result = 0;
        int length = arr.length;
        boolean found = false;
        for(int i = 0; i < arr.length; i++){
            if((i + 1) < length){
                if((arr[i] == 'I' && arr[i + 1] == 'X') 
                  || (arr[i] == 'I' && arr[i+1] == 'V')
                  || (arr[i] == 'X' && arr[i + 1] == 'L')
                  || (arr[i] == 'X' && arr[i + 1] == 'C')
                  || (arr[i] == 'C' && arr[i + 1] == 'D')
                  || (arr[i] == 'C' && arr[i + 1] == 'M')){
                    found = true;
                    result += map.get(arr[i + 1]) - map.get(arr[i]);
                    i = i + 1;
                }
            } 
            if(!found){
                result += map.get(arr[i]);
            }
            found = false;
        }
       return result; 
    }
}