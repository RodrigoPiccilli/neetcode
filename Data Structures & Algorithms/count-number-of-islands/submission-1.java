class Solution {
    public int numIslands(char[][] grid) {
        List<Set<String>> count = new ArrayList<>();

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                dfs(r, c, grid, count);
            }
        }

        return count.size();
    }

    private void dfs(int r, int c, char[][] grid, List<Set<String>> count) {

        if (r < 0 || c < 0 || r >= grid.length
            || c >= grid[0].length || grid[r][c] == '0' || grid[r][c] == '.') {
            return;
        }

        grid[r][c] = '.';

        boolean exists = false;

        for (Set<String> set : count) {
            if (set.contains((r - 1) + "," + c) || set.contains((r + 1) + "," + c)
                || set.contains(r + "," + (c - 1)) || set.contains(r + "," + (c + 1))) {
                set.add(r + "," + c);
                exists = true;
                break;
            }
        }

        if(!exists) {
            Set<String> newIsland = new HashSet<>();
            newIsland.add(r + "," + c);
            count.add(newIsland);
        }

        dfs(r, c + 1, grid, count);
        dfs(r, c - 1, grid, count);
        dfs(r + 1, c, grid, count);
        dfs(r - 1, c, grid, count);
    }
}
