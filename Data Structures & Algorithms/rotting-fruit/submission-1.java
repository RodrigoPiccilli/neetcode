class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int time = 0;
        int fresh = 0;

        int ROWS = grid.length;
        int COLS = grid[0].length;

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (grid[r][c] == 1) {
                    fresh++;
                }

                if (grid[r][c] == 2) {
                    q.offer(new int[] {r, c});
                }
            }
        }

        while (fresh > 0 && !q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] pos = q.remove();
                int r = pos[0];
                int c = pos[1];

                if (r + 1 >= 0 && r + 1 < ROWS && grid[r + 1][c] == 1) {
                    grid[r + 1][c] = 2;
                    q.offer(new int[] {r + 1, c});
                    fresh--;
                }

                if (r - 1 >= 0 && r - 1 < ROWS && grid[r - 1][c] == 1) {
                    grid[r - 1][c] = 2;
                    q.offer(new int[] {r - 1, c});
                    fresh--;
                }

                if (c + 1 >= 0 && c + 1 < COLS && grid[r][c + 1] == 1) {
                    grid[r][c + 1] = 2;
                    q.offer(new int[] {r, c + 1});
                    fresh--;
                }

                if (c - 1 >= 0 && c - 1 < COLS && grid[r][c - 1] == 1) {
                    grid[r][c - 1] = 2;
                    q.offer(new int[] {r, c - 1});
                    fresh--;
                }
            }

            time++;
        }

        return fresh == 0 ? time : -1;
    }
}
