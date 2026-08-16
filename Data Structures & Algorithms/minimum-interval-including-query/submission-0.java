class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        // Sort Intervals Array by Start Time, at index 0.
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int[][] q = new int[queries.length][2];

        for (int i = 0; i < queries.length; i++) {
            q[i][0] = queries[i]; // Query
            q[i][1] = i; // Index
        }

        // Sort Queries Array
        Arrays.sort(q, (a, b) -> Integer.compare(a[0], b[0]));

        int[] res = new int[queries.length];

        // Sort Priority Queue by size. [0] = Size, [1] = endTime
        Queue<int[]> active = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        int prev = 0;

        // Iterate Through Queries, Sequentially
        for (int[] entry : q) {
            int query = entry[0];
            int index = entry[1];

            // Add Intervals to heap such that query >= startTime
            while (prev < intervals.length && query >= intervals[prev][0]) {
                active.offer(new int[] {intervals[prev][1] - intervals[prev][0] + 1, intervals[prev][1]});
                prev++;
            }

            // Remove Intervals from heap such that endTime < query
            while (!active.isEmpty() && active.peek()[1] < query) {
                active.remove();
            }

            if (!active.isEmpty()) {
                res[index] = active.peek()[0];
            } else {
                res[index] = -1;
            }
        }

        return res;
    }
}
