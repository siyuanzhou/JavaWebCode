package site.newvalue;

public class TicketDemo {
    public static void main(String[] args) {
        Runnable r = new Ticket2();
        Thread t1 = new Thread(r, "窗口1");
        Thread t2 = new Thread(r, "窗口2");
        Thread t3 = new Thread(r, "窗口3");

        t1.start();
        t2.start();
        t3.start();

    }
}
