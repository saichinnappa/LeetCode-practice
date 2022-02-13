class Solution {
    public String addStrings(String num1, String num2) {
        int p1 = num1.length() - 1;
        int p2 = num2.length() - 1;
        
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int sum = 0;
        while(p1 > -1 && p2 > -1){
            int val1 = num1.charAt(p1) - '0';
            int val2 = num2.charAt(p2) - '0';
            sum = (carry + val1 + val2);
            int val = sum % 10;
            carry = sum / 10;
            sb.append(val);
            p1--;
            p2--;
        }
        
        // System.out.println(carry+" "+sb.reverse().toString());
        System.out.println(p1+" "+ p2);
        if(p1 < 0){
            while(p2 > -1){
                sum = carry + num2.charAt(p2) - '0';
                int val = (sum % 10);
                carry = sum / 10;
                sb.append(val);
                p2--;
            }
        }
        
        if(p2 < 0){
            while(p1 > -1){
                sum = carry + num1.charAt(p1) - '0';
                System.out.println(sum);
                int val = (sum % 10);
                carry = sum / 10;
                sb.append(val);
                p1--;
            }
        }
        
        if(carry > 0)
            sb.append(carry);
        
        return sb.reverse().toString();
    }
}