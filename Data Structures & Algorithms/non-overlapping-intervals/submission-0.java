class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        
        int endTime = intervals[0][1];
        int kept = 1;

        for(int i = 1; i < intervals.length; i++) {

            int startB = intervals[i][0];

            if(endTime <= startB) {
                endTime = intervals[i][1];
                kept++;
            }

        }

        return intervals.length - kept;

    }
}
