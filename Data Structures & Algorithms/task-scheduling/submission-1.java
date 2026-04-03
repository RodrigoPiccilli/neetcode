class Solution {
    public int leastInterval(char[] tasks, int n) {
        
        int[] count = new int[26];

        for(char c : tasks) {
            count[c - 'A']++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for(int c : count) {
            if(c > 0) pq.add(c);
        }

        // [0] -> Count, [1] -> Time to come back
        Queue<int[]> q = new LinkedList<>();

        int time = 0;

        while(!pq.isEmpty() || !q.isEmpty()) {

            if(pq.isEmpty()) {
                time = q.peek()[1];
            } else {
                time++;
            }

            if(!q.isEmpty() && q.peek()[1] == time) {
                pq.add(q.remove()[0]);
            }

            int current = pq.remove();

            current--;

            if(current > 0) {
                q.add(new int[] {current, time + n + 1});
            }

        }

        return time;

    }
}
