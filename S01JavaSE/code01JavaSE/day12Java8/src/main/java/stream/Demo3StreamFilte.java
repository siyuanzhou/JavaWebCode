package stream;

import java.util.ArrayList;
import java.util.stream.Stream;

public class Demo3StreamFilte {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("张无忌");list.add("周芷若");list.add("赵敏");
        list.add("张强");list.add("张三丰");
        list.stream().filter((s) -> s.startsWith("张")).filter((s) -> s.length() == 3).forEach((s) -> System.out.println(s));
        Stream<String> stream=Stream.of("1","2","3","4");
        stream.map(s -> Integer.parseInt(s)).forEach(s-> System.out.println(s));
    }
}
