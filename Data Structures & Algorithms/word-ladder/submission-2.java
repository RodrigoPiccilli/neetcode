class Solution {

    Map<String, List<String>> neighbors = new HashMap<>();
    Set<String> visited = new HashSet<>();

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        if(!wordList.contains(endWord)) return 0;

        neighbors.put(beginWord, findNeighbors(beginWord, wordList));

        for(String word : wordList) {
            neighbors.put(word, findNeighbors(word, wordList));
        }

        Queue<String> q = new LinkedList<>();

        int count = 0;

        q.offer(beginWord);

        while(!q.isEmpty()) {

            int size = q.size();

            count++;
            
            for(int i = 0; i < size; i++) {

                String cur = q.poll();

                visited.add(cur);

                if(cur.equals(endWord)) return count;

                List<String> nei = neighbors.get(cur);

                for(String n : nei) {

                    if(visited.contains(n)) continue;

                    q.offer(n);

                }

            }

        }

        return 0;

        
    }

    private List<String> findNeighbors(String word, List<String> wordList) {

        List<String> res = new ArrayList<>();

        for(String w : wordList) {

            int diff = w.length();

            if(w.equals(word)) continue;

            for(int i = 0; i < word.length(); i++) {
                if(w.charAt(i) == word.charAt(i)) diff--;
            }

            if(diff == 1) res.add(w);

        }

        return res;

    }
}
