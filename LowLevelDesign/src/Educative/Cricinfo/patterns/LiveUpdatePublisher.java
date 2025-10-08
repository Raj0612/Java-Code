package Educative.Cricinfo.patterns;

import java.util.*;

public class LiveUpdatePublisher {
    private final List<LiveUpdateListener> listeners = new ArrayList<>();

    public void addListener(LiveUpdateListener listener) {
        listeners.add(listener);
    }

    public void removeListener(LiveUpdateListener listener) {
        listeners.remove(listener);
    }

    public void publishUpdate(String update) {
        for (LiveUpdateListener listener : listeners) {
            listener.onLiveUpdate(update);
        }
    }
}
