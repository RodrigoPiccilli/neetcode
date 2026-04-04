class Twitter {

    class Tweet {
        int time;
        int tweetId;

        public Tweet(int time, int tweetId) {
            this.time = time;
            this.tweetId = tweetId;
        }
    }

    class Node {
        int userId;   
        int index;   
        Tweet tweet;  

        Node(int userId, int index, Tweet tweet) {
            this.userId = userId;
            this.index = index;
            this.tweet = tweet;
        }
    }

    
    int time;
    
    // KEY = User ID, VALUE = Set of Followers
    Map<Integer, Set<Integer>> follows;

    // KEY = User ID, VALUE = List of 10 most recent tweets
    Map<Integer, List<Tweet>> posts;

    public Twitter() {
        this.time = 0;
        this.follows = new HashMap<>();
        this.posts = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {

        time++;

        posts.putIfAbsent(userId, new ArrayList<>());
        posts.get(userId).add(new Tweet(time, tweetId));

        if(posts.get(userId).size() > 10) {
            posts.get(userId).remove(0);
        }
    }
    
    public List<Integer> getNewsFeed(int userId) {

        List<Integer> result = new ArrayList<>();

        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> Integer.compare(b.tweet.time, a.tweet.time));

        follow(userId, userId);

        Set<Integer> followers = follows.get(userId);

        for(int follower : followers) {

            List<Tweet> userPosts = posts.get(follower);

            if(userPosts == null || userPosts.size() == 0) continue;

            int lastIndex = userPosts.size() - 1;

            pq.add(new Node(follower, lastIndex, userPosts.get(lastIndex)));

        }

        while(!pq.isEmpty() && result.size() < 10) {

            Node latest = pq.remove();

            result.add(latest.tweet.tweetId);

            int nextIndex = latest.index - 1;

            if(nextIndex >= 0) {
                pq.add(new Node(latest.userId, nextIndex, posts.get(latest.userId).get(nextIndex)));
            }

        }

        return result;
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
