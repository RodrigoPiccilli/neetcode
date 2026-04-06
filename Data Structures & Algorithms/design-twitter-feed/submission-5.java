class Twitter {

    class Tweet {
        int time;
        int id;
        public Tweet(int time, int id) {
            this.time = time;
            this.id = id;
        }
    }

    private Map<Integer, Set<Integer>> follows;
    private Map<Integer, List<Tweet>> posts;
    private int time;
    public Twitter() {
        this.time = 0;
        this.follows = new HashMap<>();
        this.posts = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        time++;
        posts.putIfAbsent(userId, new ArrayList<>());
        posts.get(userId).add(new Tweet(time, tweetId));

        if(posts.get(userId).size() > 10) posts.remove(0);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        // Make sure we follow ourselves.
        follow(userId, userId);

        List<Integer> res = new ArrayList<>();

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        Set<Integer> followers = follows.get(userId);

        for(int follower : followers) {

            List<Tweet> followerPosts = posts.get(follower);

            if(followerPosts == null || followerPosts.isEmpty()) continue;

            int lastIndex = followerPosts.size() - 1;

            Tweet latest = followerPosts.get(lastIndex);

            pq.add(new int[] {latest.time, follower, lastIndex, latest.id});
        }

        while(!pq.isEmpty() && res.size() < 10) {

            int[] current = pq.remove();

            for(int n : current) {
                System.out.print(n + " ");
            }

            System.out.println();

            int currentId = current[1];
            int idx = current[2];

            
            res.add(current[3]);

            int updatedIdx = idx - 1;

            if(updatedIdx >= 0) {
                Tweet latest = posts.get(currentId).get(updatedIdx);
                pq.add(new int[] {latest.time, currentId, updatedIdx, latest.id});
            }
            
        }

        return res;

    }
    
    public void follow(int followerId, int followeeId) {
        follows.putIfAbsent(followerId, new HashSet<>());
        follows.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        follows.putIfAbsent(followerId, new HashSet<>());
        follows.get(followerId).remove(followeeId);
        
    }
}
