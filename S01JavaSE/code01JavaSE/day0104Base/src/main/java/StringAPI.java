import java.util.Arrays;

public class StringAPI {
    public static void main(String[] args) {
        String str = "abcde";
        char[] ch = str.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            System.out.println(ch[i]);
        }
        byte[] by = str.getBytes();
        System.out.println(by);
        for (int i = 0; i < by.length; i++) {
            System.out.println(by[i]);
        }
//        String s="aa|bb|cc";
//        String[] splits=s.split("|");
//        System.out.println(Arrays.toString(splits));
//        for (int i=0;i<splits.length;i++){
//            System.out.println(splits[i]);
//        }
        String s = "aa|bb|cc";
        String[] strArray = s.split("|"); // ["aa","bb","cc"]
        System.out.println(Arrays.toString(strArray));

    }
}
