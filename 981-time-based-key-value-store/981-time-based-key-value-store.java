class TimeMap {

	HashMap<String,ArrayList<Pair<String,Integer>>> map;

	public TimeMap() {
		map = new HashMap<>();
	}

	public void set(String key, String value, int timestamp) {
		map.computeIfAbsent(key,x->new ArrayList<>()).add(new Pair(value,timestamp));
	}

	public String get(String key, int timestamp) {
		if(!map.containsKey(key))
			return "";

		ArrayList<Pair<String,Integer>> times = map.get(key);
		if(timestamp<times.get(0).getValue())
			return "";

		int i=0,j=times.size();
		while(i<j){
			int mid = i+(j-i)/2;
			if(mid==i)
				break;
			if(times.get(mid).getValue()>timestamp){
				j=mid-1;
			}else{
				i = mid;
			}
		}
		return times.get(i).getKey();
	}
}