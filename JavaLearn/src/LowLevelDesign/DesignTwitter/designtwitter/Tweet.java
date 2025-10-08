package LowLevelDesign.DesignTwitter.designtwitter;

public class Tweet {
    private static int timeStamp=0;
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
