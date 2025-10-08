package LowLevelDesign.DesignTwitter.designtwitter;

import java.util.HashSet;
import java.util.Set;

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
