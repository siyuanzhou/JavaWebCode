import java.io.File;

public class PrintFileTree {
    public static void main(String[] args) {
        File dir = new File(".");
        printTree(dir);
    }

    public static void printTree(File f) {
        if (f.isFile()) {
            System.out.println(f.getAbsolutePath());
        } else if (f.isDirectory()) {
            File[] l = f.listFiles();
            for (File f1 : l) {
                printTree(f1);
            }
        }
    }
}
