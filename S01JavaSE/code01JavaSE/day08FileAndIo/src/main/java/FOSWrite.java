import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FOSWrite {
    public static void main(String[] args) throws IOException {
        File f = new File("a.txt");
        File fcopy = new File("acopy.txt");
        FileInputStream fis = new FileInputStream(f);
        FileOutputStream fos = new FileOutputStream(fcopy);
        byte[] b = new byte[1024];
        int len;
        while ((len = fis.read(b)) != -1) {
            fos.write(b);
        }
        fis.close();
        fos.close();
    }
}
