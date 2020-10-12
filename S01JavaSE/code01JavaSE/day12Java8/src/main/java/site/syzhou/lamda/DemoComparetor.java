package site.syzhou.lamda;

import java.util.Arrays;
import java.util.Comparator;

public class DemoComparetor {
    private static Comparator<String> newComparator() {
//        return new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o1.length()-o2.length();
//            }
//        };
        return (o1, o2) -> {
            return o1.length() - o2.length();
        };
    }

    public static void main(String[] args) {
        String[] sarr = {"123", "23", "23121321", "2333"};
        Arrays.sort(sarr, newComparator());
        for (String i : sarr) {
            System.out.println(i);
        }
        byte[] num = "1234567890".getBytes();
    }
}
