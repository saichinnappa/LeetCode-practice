class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        if(truckSize == 0)
            return 0;
        Arrays.sort(boxTypes, (a, b) -> Integer.compare(b[1], a[1]));
        int size = 0;
        int units = 0;
        for(int i = 0; i < boxTypes.length; i++){
            int currSize = boxTypes[i][0];
           for(int j = 0; j < currSize; j++){
               if(truckSize != size){
                   size++;
                   units += boxTypes[i][1];
               }
           }
        }
        return units;
    }
}