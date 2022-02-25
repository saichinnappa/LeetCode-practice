class Solution {
//     public String shiftingLetters(String s, int[] shifts) {
        
//         char[] input = s.toCharArray();
//         StringBuilder sb = new StringBuilder();
        
//         for(int i = 0; i < shifts.length; i++){
//             int count = i;
//             int index = 0;
//             System.out.println("****");
//             while(count >= 0){

//                 int x = input[index] - 0 +shifts[i] % 26;
//                 // System.out.println(x);
//                 if(x > 122)
//                     x = x + 97;
//                 input[index] = (char)(x);
//                 // System.out.println(input[index]);
//                 // sb.append(input[index] - '0' + shifts[i]);
//                 index++;
//                 count--;
//                 System.out.println(new String(input));
//             }
//         }
        
//         return new String(input);
//     }
    
    
     public String shiftingLetters(String s, int[] shifts) {
        int n = shifts.length;
        int runningSum = 0;
        for(int i = n - 1; i >= 0; i --) {
            shifts[i] = (shifts[i] + runningSum) % 26;
            runningSum = shifts[i];
        }
        StringBuilder str = new StringBuilder();
        int i = 0;
        for(char c : s.toCharArray()) {
            int correctShift = (c - 'a' + shifts[i]) % 26;
            str.append((char)('a' + correctShift));
            i ++;
        }
        return str.toString();
    }
}