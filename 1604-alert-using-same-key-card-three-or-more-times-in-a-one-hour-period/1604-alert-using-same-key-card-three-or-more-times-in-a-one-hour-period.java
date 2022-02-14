class Solution {
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        Map<String, List<String>> map = new HashMap<>();
        for(int i = 0; i < keyName.length; i++){
            map.putIfAbsent(keyName[i], new ArrayList());
            map.get(keyName[i]).add(keyTime[i].replace(":",""));
        }

        List<String> result = new ArrayList();
        for(Map.Entry<String, List<String>> entry : map.entrySet()){
            Collections.sort(entry.getValue());
            List<String> timeList = entry.getValue();
            if(timeList.size() > 2){
                for(int i = 2; i < timeList.size(); i++){
                    if(!moreThan1Hr(timeList.get(i), timeList.get(i - 2))){
                        result.add(entry.getKey());
                        break;
                    }
                }
            }
        }
        
        Collections.sort(result, new TimeComparator());
        return result;
        
    }
    
    boolean moreThan1Hr(String t1, String t2){

        int t1Hr = Integer.parseInt(t1.substring(0, 2));
        int t2Hr = Integer.parseInt(t2.substring(0, 2));
        int t1Mn = Integer.parseInt(t1.substring(2, 4));
        int t2Mn = Integer.parseInt(t2.substring(2, 4));
        
        return (t1Hr - t2Hr) > 1 || (t1Hr - t2Hr == 1 && t1Mn - t2Mn > 0);
    }
    
}


class TimeComparator implements Comparator<String>{
    @Override
    public int compare(String s1, String s2){
        if(s1 == null || s2 == null) return 0;
        return s1.compareTo(s2);
    }
}