class Solution {

    Map<String, List<String>> neighbors = new HashMap<>();

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        if(!wordList.contains(endWord)) return 0;

        wordList.add(beginWord);

        for(String word : wordList) {
            findNeighbors(word, wordList);
        }

        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        q.offer(beginWord);

        int count = 0;

        while(!q.isEmpty()) {

            int size = q.size();
            count++;

            for(int i = 0; i < size; i++) {

                String cur = q.poll();

                if(visited.contains(cur)) continue;

                if(cur.equals(endWord)) return count;

                visited.add(cur);

                List<String> nei = neighbors.get(cur);

                for(String n : nei) {
                    if(visited.contains(n)) continue;
                    q.offer(n);
                }

            }

        }

        return 0;
        
    }

    private void findNeighbors(String word, List<String> wordList) {

        List<String> res = new ArrayList<>();

        for(String w : wordList) {

            if(w.equals(word)) continue;

            int diff = word.length();

            for(int i = 0; i < word.length(); i++) {
                if(w.charAt(i) == word.charAt(i)) diff--;
            }

            if(diff == 1) res.add(w);

        }

        neighbors.put(word, res);

    }
}
