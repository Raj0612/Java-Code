package DesignPatterns.Creational.ObjectPool.connection;

import java.util.Enumeration;
import java.util.Hashtable;

public abstract class ObjectPool<T> {
    long deadTime;

    Hashtable<T, Long> lock, unlock;

    ObjectPool() {
        deadTime = 50000; // 50 seconds
        lock = new Hashtable<T, Long>();
        unlock = new Hashtable<T, Long>();
    }

    abstract T create();

    abstract boolean validate(T o);

    abstract void destroy(T o);

    public synchronized T takeOut() {
        long now = System.currentTimeMillis();
        T t;
        System.out.println("takeOut unlock " +unlock.size());
        if (unlock.size() > 0) {
            Enumeration<T> e = unlock.keys();
            while (e.hasMoreElements()) {
                t = e.nextElement();
                if ((now - unlock.get(t)) > deadTime) {
                    // object has dead
                    unlock.remove(t);
                    destroy(t);
                    t = null;
                } else {
                    if (validate(t)) {
                        unlock.remove(t);
                        lock.put(t, now);
                        return (t);
                    } else {
                        unlock.remove(t);
                        destroy(t);
                        t = null;
                    }
                }
            }
        }
        // no objects available, create a new one
        t = create();
        lock.put(t, now);
        return (t);
    }

    public synchronized void takeIn(T t) {
        lock.remove(t);
        unlock.put(t, System.currentTimeMillis());
    }
}
