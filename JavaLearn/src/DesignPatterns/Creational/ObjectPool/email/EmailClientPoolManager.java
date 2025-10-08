package DesignPatterns.Creational.ObjectPool.email;

import java.util.LinkedList;
import java.util.Queue;

public class EmailClientPoolManager {
    private static final EmailClientPoolManager pool_manager = new EmailClientPoolManager();
    private static final int POOL_SIZE=5;
    private final Queue<EmailClient> pool;
    private EmailClientPoolManager(){
        pool=new LinkedList<>();
        for(int i=0; i<POOL_SIZE; i++) {
            pool.offer(new EmailClient(i));
        }
    }

    public static EmailClient borrowClient() throws InterruptedException {
        System.out.println("Thread ["+Thread.currentThread().getName()+"] is waiting for borrow request");
        synchronized (pool_manager.pool) {
            while(pool_manager.pool.isEmpty()) {
                pool_manager.pool.wait();
            }
            return pool_manager.pool.poll();
        }
    }

    public static void returnClient(EmailClient client){
        System.out.println("Thread ["+Thread.currentThread().getName()+"] is returning EmailClient with ID ["+client.getId()+"]");
        synchronized (pool_manager.pool){
            // do something to reset/sanitize client if required
            pool_manager.pool.offer(client);
            pool_manager.pool.notifyAll();
        }
    }
}
