class Solution {
    public int leastInterval(char[] tasks, int n) {

        // Max Heap
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        // Cooldown Queue ([0] -> task, [1] -> time it can come back)
        Queue<int[]> q = new LinkedList<>();

        int[] count = new int[26];

        for(char c : tasks) {
            count[c - 'A']++;
        }

        for(int num : count) {
            if(num > 0) pq.add(num);
        }

        int time = 0;

        while(!pq.isEmpty() || !q.isEmpty()) {

            if(pq.isEmpty()) {
                // Time jump to end of cooldown
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
