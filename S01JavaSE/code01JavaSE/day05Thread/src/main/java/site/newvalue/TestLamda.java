package site.newvalue;

interface Calculator {
    int calc(int a, int b);
}

public class TestLamda {
    public static void main(String[] args) {
        new Thread(() -> System.out.println(Thread.currentThread().getName() + "多线程任务执行！")).start(); // 启动线程
        invokeCalc(120, 130, (a, b) -> a + b);
    }

    private static void invokeCalc(int a, int b, Calculator calculator) {
        int result = calculator.calc(a, b);
        System.out.println("结果是：" + result);
    }
}