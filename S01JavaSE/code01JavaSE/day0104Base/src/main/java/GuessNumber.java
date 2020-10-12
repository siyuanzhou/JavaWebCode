import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
    public static void main(String[] args) {
        Random r = new Random();
        int number = r.nextInt(100) + 1;
        Scanner sc = new Scanner(System.in);
        while (true) {
            int guss = sc.nextInt();
            if (guss > number) {
                System.out.println("太高了！");
            } else if (guss < number) {
                System.out.println("太低了！");
            } else {
                System.out.println("成功！为：" + guss);
                break;
            }
        }
    }
}
