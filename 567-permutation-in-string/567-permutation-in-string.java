class Solution {
    public boolean checkInclusion(String pattern, String str) {
//         if(s1.equals(s2))
//             return true;

//         char[] input = s1.toCharArray();
//         Set<Character> set = new HashSet();
//         for(char c : input){
//             set.add(c);
//         }
        
//         Arrays.sort(input);
//         String inputS = new String(input);
        
        
//         for(int i = 0; i< s2.length(); i++){
//             if(set.contains(s2.charAt(i)) && (i + s1.length()) <= s2.length()){
//                 String s = s2.substring(i, i+s1.length());

//                 char[] sarr = s.toCharArray();
//                 Arrays.sort(sarr);
//                 String sNew = new String(sarr);
//                 if(sNew.equals(inputS)) return true;
//             }
//         }
//         return false;
        
        int windowStart = 0, matched = 0;
    Map<Character, Integer> charFrequencyMap = new HashMap<>();
    for (char chr : pattern.toCharArray())
      charFrequencyMap.put(chr, charFrequencyMap.getOrDefault(chr, 0) + 1);

    // our goal is to match all the characters from the 'charFrequencyMap' with the 
    // current window try to extend the range [windowStart, windowEnd]
    for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
      char rightChar = str.charAt(windowEnd);
      if (charFrequencyMap.containsKey(rightChar)) {
        // decrement the frequency of the matched character
        charFrequencyMap.put(rightChar, charFrequencyMap.get(rightChar) - 1);
        if (charFrequencyMap.get(rightChar) == 0) // character is completely matched
          matched++;
      }

      if (matched == charFrequencyMap.size())
        return true;

      if (windowEnd >= pattern.length() - 1) { // shrink the window by one character
        char leftChar = str.charAt(windowStart++);
        if (charFrequencyMap.containsKey(leftChar)) {
          if (charFrequencyMap.get(leftChar) == 0)
            matched--; // before putting the character back, decrement the matched count
          // put the character back for matching
          charFrequencyMap.put(leftChar, charFrequencyMap.get(leftChar) + 1);
        }
      }
    }

    return false;
    }
}