class Solution {
    public String[] reorderLogFiles(String[] logs) {
        
        List<String> digitLogs = new ArrayList();
        String[] result = new String[logs.length];
        int index = 0;
        
        for(int i = 0; i < logs.length; i++){
            if(Character.isDigit(logs[i].split(" ")[1].charAt(0))){
                digitLogs.add(logs[i]);
            } else{
                result[index] = logs[i];
                index++;
            }
        }
        
        Arrays.sort(result, new TestComparator<String>());
        // System.out.println(Arrays.toString(result));
        for(int i = 0;  i < digitLogs.size(); i++){
            result[index  + i] = digitLogs.get(i);
        }
        
        return result;
    }
    
    
   
}

 public class TestComparator<T> implements Comparator<String>{
        @Override
        public int compare(String s1, String s2){
            if(s1 == null || s2 == null) return 0;
            // System.out.println(s1+" "+ s2);
            String[] a1 = s1.split(" ", 2);
            String[] a2 = s2.split(" ", 2);
            if(a1[1].compareTo(a2[1]) == 0)
                return a1[0].compareTo(a2[0]);
            return a1[1].compareTo(a2[1]);
        }
}