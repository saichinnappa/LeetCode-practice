class Solution {
    public String[] reorderLogFiles(String[] logs) {
        
        List<String> letterLogs = new ArrayList();
        for(int i=0; i< logs.length; i++){
            int x = logs[i].indexOf(" ");
            if(Character.isLetter(logs[i].charAt(x+1))){
                letterLogs.add(logs[i]);
            }
        }
        
        String[] result = new String[logs.length];
        
        for(int i = 0; i< letterLogs.size(); i++){
            for(int j = i + 1; j< letterLogs.size(); j++){
                // if(i != j){
                
                
                 String[] split1 = letterLogs.get(i).split(" ", 2);
                 String[] split2 = letterLogs.get(j).split(" ", 2);
                
                // String a = letterLogs.get(i).substring(letterLogs.get(i).indexOf(" ")+1, letterLogs.get(i).length());  
                // String b = letterLogs.get(j).substring(letterLogs.get(j).indexOf(" ")+1, letterLogs.get(j).length());
                    int aComp = split1[1].compareTo(split2[1]);
                    if(aComp > 0){
                        String temp = letterLogs.get(i);
                        letterLogs.set(i, letterLogs.get(j));
                        letterLogs.set(j, temp);
                    } else if (aComp == 0){
                    // String aPrefix = letterLogs.get(i).substring(0, letterLogs.get(i).indexOf(" "));
                    // String bPrefix = letterLogs.get(j).substring(0, letterLogs.get(j).indexOf(" "));
                        if(split1[0].compareTo(split2[0]) > 0){
                             String temp = letterLogs.get(i);
                            letterLogs.set(i, letterLogs.get(j));
                            letterLogs.set(j, temp);
                        }
                    }
                // }
            }
        }
        
        
        for(int i = 0; i< logs.length; i++){
              int x = logs[i].indexOf(" ");
            if(!Character.isLetter(logs[i].charAt(x+1))){
                letterLogs.add(logs[i]);
            }
        }
        
        
       result =  letterLogs.toArray(result);
           return result;
    }

}