class Solution {
    Map<Character, List<Character>> adjList = new HashMap<>();

    Map<Character, Boolean> visited = new HashMap<>();

    StringBuilder sb = new StringBuilder();

    public String foreignDictionary(String[] words) {
        for (String word : words) {
            for (char c : word.toCharArray()) {
                adjList.putIfAbsent(c, new ArrayList<>());
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i];
            String w2 = words[i + 1];

            int length = Math.min(w1.length(), w2.length());

            int diff = -1;

            for (int j = 0; j < length; j++) {
                if (w1.charAt(j) != w2.charAt(j)) {
                    diff = j;
                    break;
                }
            }

            if (diff == -1 && w1.contains(w2) && w1.length() > w2.length()) {
                return "";
            }

            if (diff == -1)
                continue;

            adjList.get(w1.charAt(diff)).add(w2.charAt(diff));
        }

        for (Character c : adjList.keySet()) {
            if (!dfs(c)) { // Cycle Detected.
                return "";
            }
        }

        return sb.reverse().toString();
    }

    private boolean dfs(Character c) {
        // Not in Visited -> Not reached yet
        // False -> in current path
        // True -> Completely visited

        if (visited.containsKey(c)) {
            return visited.get(c);
        }

        List<Character> neighbors = adjList.get(c);

        visited.put(c, false);

        if (neighbors != null) {
            for (Character nei : neighbors) {
                if (!dfs(nei)) {
                    return false;
                }
            }
        }

        visited.put(c, true);

        sb.append(c);

        return true;
    }
}
