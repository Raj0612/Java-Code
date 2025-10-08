package com.leetcode.systemdesign;
//Design a simplified version of Twitter where users can post tweets, follow/unfollow another user, and is able to see the 10 most recent tweets in the user's news feed.
/*
Implement the Twitter class:

 # Twitter() Initializes your twitter object.
 # void postTweet(int userId, int tweetId) Composes a new tweet with ID tweetId by the user userId. Each call to this function will be made with a unique tweetId.
 # List<Integer> getNewsFeed(int userId) Retrieves the 10 most recent tweet IDs in the user's news feed.
    Each item in the news feed must be posted by users who the user followed or by the user themself. Tweets must be ordered from most recent to least recent.
 # void follow(int followerId, int followeeId) The user with ID followerId started following the user with ID followeeId.
 # void unfollow(int followerId, int followeeId) The user with ID followerId started unfollowing the user with ID followeeId.
 */

/*
Input
["Twitter", "postTweet", "getNewsFeed", "follow", "postTweet", "getNewsFeed", "unfollow", "getNewsFeed"]
[[], [1, 5], [1], [1, 2], [2, 6], [1], [1, 2], [1]]
Output
[null, null, [5], null, null, [6, 5], null, [5]]

Explanation
Twitter twitter = new Twitter();
twitter.postTweet(1, 5); // User 1 posts a new tweet (id = 5).
twitter.getNewsFeed(1);  // User 1's news feed should return a list with 1 tweet id -> [5]. return [5]
twitter.follow(1, 2);    // User 1 follows user 2.
twitter.postTweet(2, 6); // User 2 posts a new tweet (id = 6).
twitter.getNewsFeed(1);  // User 1's news feed should return a list with 2 tweet ids -> [6, 5]. Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
twitter.unfollow(1, 2);  // User 1 unfollows user 2.
twitter.getNewsFeed(1);  // User 1's news feed should return a list with 1 tweet id -> [5], since user 1 is no longer following user 2.
 */

import java.util.*;

public class DesignTwitter {
    private static int timeStamp=0;

    private Map<Integer, User> userMap;
    public DesignTwitter(){
        userMap = new HashMap<Integer, User>();
    }

    public void postTweet(int userId, int tweetId) {
        if(!userMap.containsKey(userId)){
            User user = new User(userId);
            userMap.put(userId, user);
        }
        userMap.get(userId).post(tweetId);
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new LinkedList<>();

        if(!userMap.containsKey(userId))   return res;

        Set<Integer> users = userMap.get(userId).followed;
        PriorityQueue<Tweet> q = new PriorityQueue<Tweet>(users.size(), (a,b)->(b.time-a.time));
        System.out.println("getNewsFeed userId: " + userId + " users: " + users);
        for(int user: users){
            Tweet t = userMap.get(user).tweet_head;
            // very imporant! If we add null to the head we are screwed.
            if(t!=null){
                q.add(t);
            }
        }

        System.out.println("getNewsFeed q " + q);
        int n=0;
        while(!q.isEmpty() && n<10){
            System.out.println("getNewsFeed q1 " + q);
            Tweet t = q.peek();
            Tweet twee = null;
            System.out.println("t " + t);
            while(t!=null){
                t = t.next;
                //System.out.println("t11 " + t);
            }
            System.out.println("t12 " + t);
            t = q.poll();
            System.out.println("t13 " + t);
            res.add(t.id);
            n++;
            if(t.next!=null)
                q.add(t.next);
        }

        return res;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if(!userMap.containsKey(followerId)){
            User u = new User(followerId);
            userMap.put(followerId, u);
        }
        if(!userMap.containsKey(followeeId)){
            User u = new User(followeeId);
            userMap.put(followeeId, u);
        }
        userMap.get(followerId).follow(followeeId);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if(!userMap.containsKey(followerId) || followerId==followeeId)
            return;
        userMap.get(followerId).unfollow(followeeId);
    }

    public class User {
        public int id;
        public Set<Integer> followed;
        public Tweet tweet_head;

        public User(int id) {
            this.id = id;
            followed = new HashSet<>();
            follow(id); // first follow itself
            tweet_head = null;
        }

        public void follow(int id) {
            followed.add(id);
            // System.out.println("User follow " + followed + " userid " + this.id);
        }

        public void unfollow(int id) {
            followed.remove(id);
        }

        // everytime user post a new tweet, add it to the head of tweet list.
        public void post(int id) {
            Tweet t = new Tweet(id);
            t.next = tweet_head;
            tweet_head = t;
        }

        @Override
        public String toString() {
            return "User{" +
                    "id=" + id +
                    ", followed=" + followed +
                    '}';
        }
    }

    public class Tweet{
        public int id;
        public int time;

        public Tweet next;

        public Tweet(int id){
            this.id = id;
            time = timeStamp++;
            next=null;
        }
        @Override
        public String toString() {
            return "Tweet{" +
                    "id=" + id +
                    ", time=" + time +
                    '}';
        }
    }



    public static void main(String[] args) {
        DesignTwitter twitter = new DesignTwitter();
        twitter.postTweet(1, 5);
        twitter.postTweet(4, 13);
        twitter.follow(1, 4);
        twitter.postTweet(1, 12);
//        twitter.postTweet(1, 1);
//        twitter.postTweet(1, 7);
//        twitter.postTweet(1, 6);
        twitter.postTweet(1, 4);
        twitter.follow(1, 2);
        twitter.postTweet(2, 25);
//        twitter.postTweet(1, 2);
//        twitter.postTweet(3, 18);
//        twitter.follow(1, 3);
//        twitter.postTweet(1, 19);
//        twitter.postTweet(1, 11);
//        twitter.postTweet(4, 20);


        System.out.println("News Feed " + twitter.getNewsFeed(1));
       // twitter.follow(1, 2);
        //twitter.postTweet(2, 6);
        //twitter.getNewsFeed(1);
        //twitter.unfollow(1, 2);
        //twitter.getNewsFeed(1);
    }
}
