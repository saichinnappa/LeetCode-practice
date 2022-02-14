class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        List<String> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < cpdomains.length; i++){
            String[] arr = cpdomains[i].split(" ");
            int count = Integer.parseInt(arr[0]);
            
            
             map.put(arr[1], map.getOrDefault(arr[1], 0) + count);
            
            String[] subdomain = arr[1].split("\\.");
            if(subdomain.length == 3){
                String x = subdomain[1]+"."+subdomain[2];
                map.put(x, map.getOrDefault(x, 0) + count);
                String y = subdomain[2];
                map.put(y, map.getOrDefault(y, 0) + count);
            } else{
                String z = subdomain[1];
                map.put(z, map.getOrDefault(z, 0) + count);
            }
            
        }
        
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            result.add(entry.getValue() +" "+ entry.getKey());
        }
        
        
        return result;
    }
}