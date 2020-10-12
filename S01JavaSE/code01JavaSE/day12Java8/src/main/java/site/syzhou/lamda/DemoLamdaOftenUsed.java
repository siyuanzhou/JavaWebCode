package site.syzhou.lamda;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class DemoLamdaOftenUsed {
    public static int supplierTest(Supplier<Integer> sup) {
        return sup.get();
    }

    public static void consumerTest(String name, Consumer<String> con) {
        con.accept(name);
    }

    public static void consumerTest(String str, Consumer<String> con1, Consumer<String> con2) {
//        con1.accept(str);con2.accept(str);
        con1.andThen(con2).accept(str);
    }

    public static boolean predicateTest(String s, Predicate<String> pre) {
        return pre.test(s);
    }

    //第一个操作是将字符串解析成为int数字，第二个操作是+10
    public static int functionTest(String s, Function<String, Integer> fun1, Function<Integer, Integer> fun2) {
        return fun1.andThen(fun2).apply(s);
    }

    public static void main(String[] args) {
        System.out.println(supplierTest(() -> 123));
        consumerTest("赵丽颖", (String name) -> System.out.println(name));
        consumerTest("asdfg", (s) -> System.out.println(s.toUpperCase()), (s) -> System.out.println(s.toLowerCase()));
        System.out.println(predicateTest("123456", (s) -> s.length() > 5));
        System.out.println(functionTest("10", (s) -> Integer.parseInt(s), (a) -> a + 10));
    }
}
