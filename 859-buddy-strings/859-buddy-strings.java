class Solution {
    public boolean buddyStrings(String s, String goal) {
        if(s.length() != goal.length())
            return false;
        HashMap<Character, Integer> smap = new HashMap<>();
        HashMap<Character, Integer> gmap = new HashMap<>();
        if(s.equals(goal)){
            for(int i = 0; i < s.length(); i++){
                smap.put(s.charAt(i), i);
            }
            return smap.size() < s.length();
                
        }
        for(int j = 0; j < goal.length(); j++){
            gmap.put(goal.charAt(j), j);
        }
        
        List<Integer> dif = new ArrayList<>();
        for (int i = 0; i < s.length(); ++i){
            if (s.charAt(i) != goal.charAt(i)) 
                dif.add(i);
        }
        return dif.size() == 2 && s.charAt(dif.get(0)) == goal.charAt(dif.get(1)) && s.charAt(dif.get(1)) == goal.charAt(dif.get(0));
    
        // return false;
    }
}