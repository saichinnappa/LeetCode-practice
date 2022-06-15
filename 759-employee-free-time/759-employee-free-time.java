class Solution {
    private Interval cur, next;
    private List<Interval> answer = new ArrayList<>();
    private PriorityQueue<Interval> heap;
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
		//heap of all intervals arranged increases by start time
		//cur is the interval with the lowest start time
        cur = initHeap(schedule);
        while(0 < heap.size()) {
			//next is the next interval with the lowest start time
            next = heap.poll();
			//we found a free interval between cur and next
            if(cur.end < next.start) answer.add(new Interval(cur.end, next.start));
			//we want cur to be the interval with the higher end time, because we will compare it's end time with next's strt time
            if(cur.end < next.end) cur = next;
        }
        return answer;
    }
    private Interval initHeap(List<List<Interval>> schedule) {
        heap = new PriorityQueue<>((i1, i2) -> i1.start - i2.start);
        for(List<Interval> l: schedule) {
            for(Interval i: l) heap.add(i);
        }
        return heap.poll();
    }
}