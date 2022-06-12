// class Solution {
//     public int[] exclusiveTime(int n, List<String> logs) {
//         int[] result = new int[n];
//         Stack<Log> stack = new Stack<>();
        
//         for(int i = 0; i < logs.size() - 1; i++){
//             String[] log = logs.get(i).split(":");
//             Log l = new Log(Integer.parseInt(log[0]), log[1], Integer.parseInt(log[2]));
//             int prevTime = -1;
            
//             if(!stack.isEmpty()){
//                 Log top = stack.peek();
//                 if(i == 1){
//                     result[top.id] += l.time - top.time;
//                 }    
//                 if(top.id == l.id && top.pos.equals("start") && l.pos.equals("end")){
//                     result[l.id] += (l.time - top.time) + 1;
//                     prevTime = top.time;
//                     stack.pop();
//                 } else{
                    
//                     stack.push(l);
//                 }
//             } else{
//                 stack.push(l);
//             }
//             // System.out.println(stack);
//         }
//          String[] log1 = logs.get(logs.size() - 1).split(":");
//         result[Integer.parseInt(log1[0])] += 1;
//         return result;
//     }
// }

// class Log{
//     int id;
//     String pos;
//     int time;
    
//     Log(int id, String pos, int time){
//         this.id = id;
//         this.pos = pos;
//         this.time = time;
//     }
// }

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