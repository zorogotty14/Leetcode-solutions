import java.util.*;

class Twitter {
    private static int timestamp = 0; // Global timestamp to keep track of tweet order
    private Map<Integer, Set<Integer>> followees; // Maps userId to the set of users they follow
    private Map<Integer, List<Tweet>> tweets; // Maps userId to a list of their tweets

    // Inner class representing a Tweet with a tweetId and timestamp
    private class Tweet {
        int tweetId;
        int time;
        
        Tweet(int tweetId, int time) {
            this.tweetId = tweetId;
            this.time = time;
        }
    }

    public Twitter() {
        followees = new HashMap<>();
        tweets = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        if (!tweets.containsKey(userId)) {
            tweets.put(userId, new ArrayList<>());
        }
        // Add the tweet with the current timestamp
        tweets.get(userId).add(new Tweet(tweetId, timestamp++));
    }

    public List<Integer> getNewsFeed(int userId) {
        // Use a max-heap to get the 10 most recent tweets
        PriorityQueue<Tweet> maxHeap = new PriorityQueue<>((a, b) -> b.time - a.time);

        // Add the user's own tweets to the heap
        if (tweets.containsKey(userId)) {
            maxHeap.addAll(tweets.get(userId));
        }

        // Add the tweets of the people the user follows to the heap
        if (followees.containsKey(userId)) {
            for (int followeeId : followees.get(userId)) {
                if (tweets.containsKey(followeeId)) {
                    maxHeap.addAll(tweets.get(followeeId));
                }
            }
        }

        // Collect the top 10 most recent tweets
        List<Integer> result = new ArrayList<>();
        int count = 0;
        while (!maxHeap.isEmpty() && count < 10) {
            result.add(maxHeap.poll().tweetId);
            count++;
        }

        return result;
    }

    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) return; // Cannot follow oneself
        followees.putIfAbsent(followerId, new HashSet<>());
        followees.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (followees.containsKey(followerId)) {
            followees.get(followerId).remove(followeeId);
        }
    }
}
