import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;


public class FRRead {
    public static void main(String[] args) throws IOException {
        File f = new File("a.txt");
        FileReader fr = new FileReader(f);
        System.out.println((char) fr.read());
        System.out.println((char) 1234564);
        Properties pro = new Properties();
        pro.load(new FileInputStream("a.txt"));
        System.out.println(pro);
        System.out.println(pro.getProperty("s"));

    }
}
