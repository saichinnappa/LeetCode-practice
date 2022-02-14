class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        List<String> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < cpdomains.length; i++){
            String[] arr = cpdomains[i].split(" ");
            
             map.put(arr[1], map.getOrDefault(arr[1], 0) + Integer.parseInt(arr[0]));
            
            // if(map.containsKey(arr[1])){
            //     map.put(arr[1], map.get(arr[1]) + arr[0]);
            // } else{
            //     map.put(arr[1], arr[0]);
            // }
            
            String[] subdomain = arr[1].split("\\.");
            if(subdomain.length == 3){
                String x = subdomain[1]+"."+subdomain[2];
                map.put(x, map.getOrDefault(x, 0) + Integer.parseInt(arr[0]));
                String y = subdomain[2];
                map.put(y, map.getOrDefault(y, 0) + Integer.parseInt(arr[0]));
            } else{
                String z = subdomain[1];
                map.put(z, map.getOrDefault(z, 0) + Integer.parseInt(arr[0]));
            }
            
        }
        
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            result.add(entry.getValue() +" "+ entry.getKey());
        }
        
        
        return result;
    }
}