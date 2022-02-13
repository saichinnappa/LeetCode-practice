class Solution {
    public String addStrings(String nums1, String nums2) {
       
        //APPROACH 1:
//         int p1 = num1.length() - 1;
//         int p2 = num2.length() - 1;
        
//         StringBuilder sb = new StringBuilder();
//         int carry = 0;
//         int sum = 0;
//         while(p1 > -1 && p2 > -1){
//             int val1 = num1.charAt(p1) - '0';
//             int val2 = num2.charAt(p2) - '0';
//             sum = (carry + val1 + val2);
//             int val = sum % 10;
//             carry = sum / 10;
//             sb.append(val);
//             p1--;
//             p2--;
//         }
        
//         // System.out.println(carry+" "+sb.reverse().toString());
//         if(p1 < 0){
//             while(p2 > -1){
//                 sum = carry + num2.charAt(p2) - '0';
//                 int val = (sum % 10);
//                 carry = sum / 10;
//                 sb.append(val);
//                 p2--;
//             }
//         }
        
//         if(p2 < 0){
//             while(p1 > -1){
//                 sum = carry + num1.charAt(p1) - '0';
//                 int val = (sum % 10);
//                 carry = sum / 10;
//                 sb.append(val);
//                 p1--;
//             }
//         }
        
//         if(carry > 0)
//             sb.append(carry);
        
//         return sb.reverse().toString();
        
        //APPROACH 2
        
        int p = nums1.length() - 1;
        int q = nums2.length() - 1;
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        while(p >= 0 || q >= 0){
            int x = (p >= 0) ? nums1.charAt(p) - '0' : 0;
            int y = (q >= 0) ? nums2.charAt(q) - '0' : 0;
            int sum = (carry + x + y);
            sb.append(sum % 10);
            carry = sum / 10;
            p--;
            q--;
        }
        
        if(carry > 0)
            sb.append(carry);
        
        return sb.reverse().toString();
    }
}