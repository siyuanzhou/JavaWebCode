package stream;

import java.util.ArrayList;

public class NormalStreamFilter {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        ArrayList<String> ans = new ArrayList<>();
        list.add("张无忌");
        list.add("周芷若");
        list.add("赵敏");
        list.add("张强");
        list.add("张三丰");

        for (String s : list) {
            if (s.startsWith("张") && s.length() == 3) {
                ans.add(s);
            }
        }
        System.out.println(ans);
    }
}
