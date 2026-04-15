class Solution {

    int total = 0;
    public int numIslands(char[][] grid) {
        // KEY = Coordinate, VALUE = Island #
        Set<String> count = new HashSet<>();

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                dfs(r, c, grid, count);
            }
        }

        return total;
    }

    private void dfs(int r, int c, char[][] grid, Set<String> count) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == '0'
            || grid[r][c] == '.') {
            return;
        }

        grid[r][c] = '.';

        if (!(count.contains((r - 1) + "," + c) || count.contains((r + 1) + "," + c)
                || count.contains(r + "," + (c - 1)) || count.contains(r + "," + (c + 1)))) {
            
            total++;
        }

        count.add((r + "," + c));

        dfs(r, c + 1, grid, count);
        dfs(r, c - 1, grid, count);
        dfs(r + 1, c, grid, count);
        dfs(r - 1, c, grid, count);
    }
}
