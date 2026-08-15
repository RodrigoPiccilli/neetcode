/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {

        if(intervals.size() == 0) return 0;

        Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));

        Queue<Integer> minHeap = new PriorityQueue();

        minHeap.offer(intervals.get(0).end);

        for (int i = 1; i < intervals.size(); i++) {
            int startTime = intervals.get(i).start;
            int endTime = intervals.get(i).end;

            if (startTime >= minHeap.peek()) {
                minHeap.remove();
            }

            minHeap.offer(endTime);
        }

        return minHeap.size();
    }
}
