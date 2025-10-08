package InterviewQuestions.RateLimiter;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class RateLimiter {
    private final int maxRequests;
    private final long windowSizeMillis;
    private final ConcurrentMap<String, Deque<Long>> userRequests = new ConcurrentHashMap<>();
    public RateLimiter(int maxRequests, long windowSizeMillis) {
        this.maxRequests = maxRequests;
        this.windowSizeMillis = windowSizeMillis;
    }

    public boolean allowRequest(String userId) {
        long now = System.currentTimeMillis();
        Deque<Long> timestamps = userRequests.computeIfAbsent(userId, k -> new ArrayDeque<>());

        synchronized (timestamps) {
            // Remove stale timestamps
            while (!timestamps.isEmpty() && timestamps.peekFirst() <= now - windowSizeMillis) {
                timestamps.pollFirst();
            }
            if (timestamps.size() < maxRequests) {
                timestamps.addLast(now);
                return true;
            } else {
                return false;
            }
        }
    }

}
