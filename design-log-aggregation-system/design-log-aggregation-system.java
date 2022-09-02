class LogAggregator {
    
    Map<Integer, List<Log>> machineMap = new HashMap<>();
    Map<Integer, List<Log>> serviceMap = new HashMap<>();

    public LogAggregator(int machines, int services) {
        
    }
    
    public void pushLog(int logId, int machineId, int serviceId, String message) {
        Log log = new Log(logId, message);
        machineMap.putIfAbsent(machineId, new ArrayList<>());
        machineMap.get(machineId).add(log);
        
        serviceMap.putIfAbsent(serviceId, new ArrayList<>());
        serviceMap.get(serviceId).add(log);
        
    }
    
    public List<Integer> getLogsFromMachine(int machineId) {
        List<Integer> result = new ArrayList<>();
        if(machineMap.containsKey(machineId)){
            List<Log> logs = machineMap.get(machineId);
            for(Log l : logs){
                result.add(l.id);
            }
        }
        
        return result;
    }
    
    public List<Integer> getLogsOfService(int serviceId) {
        List<Integer> result = new ArrayList<>();
        if(serviceMap.containsKey(serviceId)){
            List<Log> logs = serviceMap.get(serviceId);
            for(Log l : logs){
                result.add(l.id);
            }
        }
        
        return result;
    }
    
    public List<String> search(int serviceId, String searchString) {
        List<String> result = new ArrayList<>();
         if(serviceMap.containsKey(serviceId)){
            List<Log> logs = serviceMap.get(serviceId);
            for(Log l : logs){
                if(l.message.contains(searchString)){
                    result.add(l.message);
                }
            }
        }
        return result;
    }
}

class Log{
    String message;
    int id;
    
    Log(int id,String message){
        this.message = message;
        this.id = id;
    }
}

/**
 * Your LogAggregator object will be instantiated and called as such:
 * LogAggregator obj = new LogAggregator(machines, services);
 * obj.pushLog(logId,machineId,serviceId,message);
 * List<Integer> param_2 = obj.getLogsFromMachine(machineId);
 * List<Integer> param_3 = obj.getLogsOfService(serviceId);
 * List<String> param_4 = obj.search(serviceId,searchString);
 */