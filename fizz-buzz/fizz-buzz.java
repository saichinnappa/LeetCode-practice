class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList();
        for(int i = 1; i <= n; i++){
            String val ="";boolean found = false;
            if(i % 3 == 0){
                val = "Fizz";
                found = true;
            }
            if(i % 5 == 0){
                val = "Buzz";
                found = true;
            }
            if(i % 3 == 0 && i % 5 == 0){
                val = "FizzBuzz";
                found = true;
            }
            if(found)
                list.add(val);
            else
                list.add(String.valueOf(i));
            
        }
        return list;
    }
}