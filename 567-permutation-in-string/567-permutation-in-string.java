class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.equals(s2))
            return true;

        char[] input = s1.toCharArray();
        Set<Character> set = new HashSet();
        for(char c : input){
            set.add(c);
        }
        
        Arrays.sort(input);
        String inputS = new String(input);
        
        
        for(int i = 0; i< s2.length(); i++){
            if(set.contains(s2.charAt(i)) && (i + s1.length()) <= s2.length()){
                String s = s2.substring(i, i+s1.length());

                char[] sarr = s.toCharArray();
                Arrays.sort(sarr);
                String sNew = new String(sarr);
                // System.out.println(s);
                if(sNew.equals(inputS)) return true;
            }
        }
        
        
        
//         int startWindow = 0;
        
        
        
        
        
        return false;
    }
}