class Solution {
    public int nextGreaterElement(int n) {
        ArrayList<Integer> numList = new ArrayList<>();
        int descInd = -1, index = 0;
        while(n > 0){
            int d = n % 10;
            n = n/10;
            index ++;
            if(descInd < 0 && !numList.isEmpty() && d < numList.get(0)){
                descInd = index;
            }
            numList.add(0, d);
        }
        if(descInd < 0)
            return -1;
        int i = numList.size() - descInd, j = 0;
        
        for(j = i + 1; j < numList.size(); j++){
            if(numList.get(i) >= numList.get(j))
                break;
        }
        
        Collections.swap(numList, i, j - 1);
        //Collections.sort(numList.subList(i + 1, numList.size()));
         Collections.reverse(numList.subList(i + 1, numList.size()));
        
        Long result = Long.valueOf(numList.get(0));
        for(int k = 1; k < numList.size(); k++){
            result = result * 10 + numList.get(k);
        }
        return result > Integer.MAX_VALUE ? - 1 : result.intValue();
    }
}