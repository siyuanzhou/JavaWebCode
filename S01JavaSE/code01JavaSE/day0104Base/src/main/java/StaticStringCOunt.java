import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class StaticStringCOunt {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        int smallChar = 0;
        int largeChar = 0;
        int numberChar = 0;
        for (int i = 0; i < line.length(); i++) {
            char m = line.charAt(i);
            if (m >= 'a' && m <= 'z') {
                smallChar++;
            } else if (m >= 'A' && m <= 'Z') {
                largeChar++;
            } else if (m >= '0' && m <= '9') {
                numberChar++;
            }
        }
        System.out.println("共有小写字母：" + smallChar + "个，大写字母：" + largeChar + "个，数字：" + numberChar + "个");
        System.out.println(new Date());
        System.out.println(new Date().getTime());
        System.out.println(new Date(0L));
        Date d = new Date();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(df.format(d));
        String s = "2015年2月4日";
        df = new SimpleDateFormat("yyyy年MM月dd日");
        d = df.parse(s);
        System.out.println(d);
        Calendar cal = Calendar.getInstance();
        System.out.println(cal.get(Calendar.YEAR));
        cal.add(Calendar.YEAR, -3);
        Date d1 = cal.getTime();
        System.out.println(d);
        int[] src = new int[]{1, 2, 3, 4, 5};
        int[] dest = new int[]{6, 7, 8, 9, 10};
        System.arraycopy(src, 0, dest, 0, 3);
        System.out.println(Arrays.toString(dest));


    }
}
