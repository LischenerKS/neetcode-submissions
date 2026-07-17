class Twitter {
    private Map<Integer, Queue<Tweet>> userHeapByUserId;
    private Map<Integer, Set<Integer>> followersSetByCreatorId;
    private Map<Integer, List<Tweet>> userTweetsListByUserId;
    private int time;

    public Twitter() {
        this.userHeapByUserId = new HashMap<>();
        this.followersSetByCreatorId = new HashMap<>();
        this.userTweetsListByUserId = new HashMap<>();
        this.time = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        Tweet tweet = new Tweet(time++, tweetId);

        if (!userTweetsListByUserId.containsKey(userId)) {
            userTweetsListByUserId.put(userId, new ArrayList<>());
        }

        userTweetsListByUserId.get(userId).add(tweet);

        if (followersSetByCreatorId.containsKey(userId)) {
            Set<Integer> followers = followersSetByCreatorId.get(userId);

            for (Integer followerId : followers) {
                if (!userHeapByUserId.containsKey(followerId)) {
                    userHeapByUserId.put(followerId, new PriorityQueue<>());
                }

                userHeapByUserId.get(followerId).add(tweet);
            }
        }   

        if (!userHeapByUserId.containsKey(userId)) {
            userHeapByUserId.put(userId, new PriorityQueue<>());
        }

        userHeapByUserId.get(userId).add(tweet);     
    }
    
    public List<Integer> getNewsFeed(int userId) {

        Queue<Tweet> userHeap = userHeapByUserId.get(userId);
        if (userHeap == null) throw new RuntimeException(" " +userId);
        List<Tweet> ans = new ArrayList<>();

        for (int i = 0; i < 10 && !userHeap.isEmpty(); i++) {
            ans.add(userHeap.poll());
        }

        for (Tweet i : ans) {
            userHeap.add(i);
        }

        return ans.stream().map(i -> i.tweetId()).toList();
    }
    
    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) return;

        
        if (!followersSetByCreatorId.containsKey(followeeId)) {
            followersSetByCreatorId.put(followeeId, new HashSet<>());
        }

        boolean isNotFollowYet = !followersSetByCreatorId.get(followeeId).contains(followerId);
        followersSetByCreatorId.get(followeeId).add(followerId);

        if (isNotFollowYet && userTweetsListByUserId.containsKey(followeeId)) {
            List<Tweet> followeeTweets = userTweetsListByUserId.get(followeeId);

            if (!userHeapByUserId.containsKey(followerId)) {
                userHeapByUserId.put(followerId, new PriorityQueue<>());
            }

            Queue<Tweet> followerHeap = userHeapByUserId.get(followerId);
            for (Tweet tweet : followeeTweets) {
                followerHeap.add(tweet);
            }
        }

        
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (followersSetByCreatorId.containsKey(followeeId)) {
            followersSetByCreatorId.get(followeeId).remove(followerId);

            if (userTweetsListByUserId.containsKey(followeeId)) {
                List<Tweet> followeeTweets = userTweetsListByUserId.get(followeeId);

                if (userHeapByUserId.containsKey(followerId)) {
                    Queue<Tweet> followerHeap = userHeapByUserId.get(followerId);
                    for (Tweet tweet : followeeTweets) {
                        followerHeap.remove(tweet);
                    }
                }
            }
        }
    }

    private record Tweet(int timestamp, int tweetId) implements Comparable<Tweet> {
        @Override
        public boolean equals(Object other) {
            if (!(other instanceof Tweet)) return false;
            Tweet otherTweet = (Tweet) other;
            return this.tweetId() == otherTweet.tweetId();
        }

        @Override
        public int compareTo(Tweet other) {
            return Integer.compare(other.timestamp(), this.timestamp());
        }
    }
}
