package site.newvalue;

public class Demo2 {
    public static void main(String[] args) {
        Runnable r = new MyRunable();
        Thread t = new Thread(r, "t1");
        t.start();
        for (int i = 0; i < 20; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }
}
