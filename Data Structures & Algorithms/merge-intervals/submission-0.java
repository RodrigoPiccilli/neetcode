class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> res = new ArrayList<>();

        res.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {

            int startA = res.get(res.size() - 1)[0];
            int endA = res.get(res.size() - 1)[1];
            int startB = intervals[i][0];
            int endB = intervals[i][1];

            if (startB <= endA) {
                int newStart = Math.min(startA, startB);
                int newEnd = Math.max(endA, endB);
                res.remove(res.size() - 1);
                res.add(new int[] {newStart, newEnd});
            } else {
                res.add(intervals[i]);
            }
        }

        return res.toArray(new int[0][]);
    }
}
