import java.io.File;
import java.io.IOException;

public class Demo1TestFile {
    public static void main(String[] args) throws IOException {
        File f1 = new File("a.txt");
        System.out.println(f1.exists());
        f1.createNewFile();

        System.out.println(f1.length());
        System.out.println(f1.getAbsolutePath());
        System.out.println(f1.getPath());
    }
}
