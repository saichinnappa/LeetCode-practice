class OrderedStream {
    String[] input;
    int idx = 0;

    public OrderedStream(int n) {
        input = new String[n];
    }
    
    public List<String> insert(int idKey, String value) {
        input[idKey - 1] = value;
        List<String> result = new ArrayList<>();

        for(int i = idx; i < input.length; i++){
            if(input[i] == null)
                break;

            result.add(input[i]);
            idx++;
        }
        return result;
    }
}

/**
 * Your OrderedStream object will be instantiated and called as such:
 * OrderedStream obj = new OrderedStream(n);
 * List<String> param_1 = obj.insert(idKey,value);
 */