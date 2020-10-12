package site.newvalue;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Ticket2 implements Runnable {
    Lock lock = new ReentrantLock();
    private int ticket = 100;

    @Override
    public void run() {
        while (true) {
            lock.lock();
            if (ticket > 0) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "正在卖" + ticket--);
            } else {
                break;
            }
            lock.unlock();
        }
    }
}
