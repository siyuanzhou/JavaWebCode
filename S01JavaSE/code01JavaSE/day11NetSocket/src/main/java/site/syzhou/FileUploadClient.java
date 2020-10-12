package site.syzhou;

import java.io.*;
import java.net.Socket;

public class FileUploadClient {
    public static void main(String[] args) throws IOException {
        System.out.println("客户端启动。。。。");
        Socket s = new Socket("localhost", 7777);
        FileInputStream fis = new FileInputStream(new File("a.txt"));

        OutputStream skout = s.getOutputStream();
        byte[] b = new byte[1024];
        int len;
        while ((len = fis.read(b)) != -1) {
            skout.write(b, 0, len);
        }
        s.shutdownOutput();
        System.out.println("文件发送完毕");
        InputStream in = s.getInputStream();
        byte[] back = new byte[20];
        in.read(back);
        System.out.println(new String(back));
        in.close();
        fis.close();
        s.close();
    }
}
