package InterviewQuestions.RateLimiter;

public class RateLimiterMain {
    public static void main(String[] args) throws InterruptedException {
        RateLimiter limiter = new RateLimiter(5, 60_000);

        String user = "alice";
        // Simulate 7 quick requests
        for (int i = 1; i <= 7; i++) {
            boolean allowed = limiter.allowRequest(user);
            System.out.println("Request " + i + ": " + (allowed ? "allowed" : "blocked"));
        }

        // Wait a minute and try again
        Thread.sleep(60_000);
        System.out.println("After 1 minute:");
        System.out.println("Request 8: " + (limiter.allowRequest(user) ? "allowed" : "blocked"));
    }
}
