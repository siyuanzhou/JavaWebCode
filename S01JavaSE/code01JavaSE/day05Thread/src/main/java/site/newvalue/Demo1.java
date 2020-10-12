package site.newvalue;

public class Demo1 {
    public static void main(String[] args) {
        MyThread t1 = new MyThread("t1");
        t1.run();
        t1.start();
        for (int i = 0; i < 10; i++) {
            System.out.println("main线程执行" + i);
        }
    }
}
