package LowLevelDesign.DesignTwitter;

import java.util.*;

public class DesignTwitter1 {
    private HashMap<Integer, HashSet<Integer>> follows;
    private HashMap<Integer, LinkedList<Tweet>> tweets;
    private int timestamp;


    public DesignTwitter1() {
        follows = new HashMap<Integer, HashSet<Integer>>();
        tweets = new HashMap<Integer, LinkedList<Tweet>>();
        timestamp = 0;
    }

    public void postTweet(int userId, int tweetId) {
        if (!tweets.containsKey(userId)) {
            tweets.put(userId, new LinkedList<Tweet>());
        }
        tweets.get(userId).add(0, new Tweet(tweetId, userId, timestamp++));
        if (!follows.containsKey(userId)) {
            follows.put(userId, new HashSet());
            follows.get(userId).add(userId);
        }
    }

    public List<Integer> getNewsFeed(int userId) {
        System.out.println("getNewsFeed userId " + userId);
        List<Integer> feed = new LinkedList<Integer>();
        PriorityQueue<Tweet> queue = new PriorityQueue<Tweet>();
        if (!follows.containsKey(userId)) {
            return feed;
        }
        HashSet<Integer> followed = follows.get(userId);
        System.out.println("getNewsFeed userId " + userId + " followed: " + followed);
        HashMap<Integer, Integer> count = new HashMap<Integer, Integer>();
        for (Integer i : followed) {
            if (tweets.containsKey(i)) {
                Tweet t = tweets.get(i).get(0);
                System.out.println("i: " + i + " t:  " + t);
                queue.add(t);
                count.put(t.userId, 1);
            }
        }
        System.out.println("getNewsFeed count " + count);
        System.out.println("getNewsFeed queue " + queue);
        System.out.println("getNewsFeed tweets " + tweets);
        while (queue.size() > 0 && feed.size() < 10) {
            Tweet t = queue.poll();
            feed.add(t.tweetId);
            int next = count.get(t.userId);
            count.put(t.userId, next + 1);
            System.out.println("getNewsFeed count " + count + " t : "+t + " tweets size:" + tweets.get(t.userId).size());
            if (next < tweets.get(t.userId).size()) {
                queue.add(tweets.get(t.userId).get(next));
            }
            System.out.println("getNewsFeed queue1 " + queue);
        }
        return feed;
    }

    public void follow(int followerId, int followeeId) {
        if (!follows.containsKey(followerId)) {
            follows.put(followerId, new HashSet());
            follows.get(followerId).add(followerId);
        }
        follows.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (followerId == followeeId) {
            return;
        }
        if (follows.containsKey(followerId)) {
            follows.get(followerId).remove(followeeId);
        }
    }

    private class Tweet implements Comparable<Tweet> {
        private int tweetId;
        private int ts;
        private int userId;

        public Tweet(int tweetId, int userId, int timestamp) {
            this.tweetId = tweetId;
            this.ts = timestamp;
            this.userId = userId;
        }

        @Override
        public int compareTo(Tweet t2) {
            return t2.ts - this.ts;
        }

        @Override
        public String toString() {
            return "Tweet{" +
                    "tweetId=" + tweetId +
                    ", ts=" + ts +
                    ", userId=" + userId +
                    '}';
        }
    }

    public static void main(String[] args) {
        DesignTwitter1 twitter = new DesignTwitter1();
        twitter.postTweet(1, 5);
     //   twitter.postTweet(4, 13);
        twitter.follow(1, 4);
        twitter.postTweet(1, 12);
        twitter.postTweet(1, 1);
        twitter.postTweet(1, 7);
        twitter.postTweet(1, 6);
        twitter.postTweet(1, 4);
        twitter.follow(1, 2);
        twitter.postTweet(2, 25);
        twitter.postTweet(1, 2);
        twitter.postTweet(3, 18);
        twitter.follow(1, 3);
        twitter.postTweet(1, 19);
        twitter.postTweet(4, 13);
        twitter.postTweet(1, 11);
        twitter.postTweet(4, 20);


        System.out.println(twitter.getNewsFeed(1));
    }
}
