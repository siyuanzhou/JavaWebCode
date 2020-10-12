package site.syzhou.lamda;

public class DemoLoggerLamda {
    public static void log(int lever, MessageBuder mb) {
        if (lever == 1) {
            System.out.println(mb.messagebuder());
        }
    }

    public static void main(String[] args) {
        String a = "123";
        String b = "123";
        String c = "123";
        log(2, () -> {
            System.out.println(a + b + c);
            return a + b + c;
        });
    }

}
