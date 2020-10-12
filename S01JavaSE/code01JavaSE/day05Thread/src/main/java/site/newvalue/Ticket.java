package site.newvalue;

public class Ticket implements Runnable {
    Object lock = new Object();
    private int ticket = 100;

    @Override
    public void run() {
        while (true) {
            synchronized (lock) {
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
            }
        }
    }
}
