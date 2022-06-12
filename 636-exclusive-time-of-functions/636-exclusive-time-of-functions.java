class Solution {
	public int[] exclusiveTime(int n, List<String> logs) {

		Stack <Integer> stack = new Stack <> ();
		int lastTimeStamp = 0;
		int [] ans = new int [n];
		for (String log : logs) {

			String [] sLog = log.split (":");
			int time = Integer.parseInt (sLog[2]);
			if ("start".equals (sLog[1])) {
				int id = Integer.parseInt (sLog[0]);

				if (!stack.isEmpty ()) {
					ans [stack.peek()] += time - lastTimeStamp;
				} 
				stack.push (id);
				 lastTimeStamp =  time;

			} else {

				ans [stack.pop()] += time - lastTimeStamp + 1;
				lastTimeStamp = time + 1;
			}
		}
		return ans;
	}
}