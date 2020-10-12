package site.syzhou;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class FileUploadServer {
    public static void main(String[] args) throws IOException {
        System.out.println("服务器启动。。。");
        ServerSocket ss = new ServerSocket(7777);
        while (true) {
            Socket s = ss.accept();
            InputStream in = s.getInputStream();
            FileOutputStream fos = new FileOutputStream(new File(System.currentTimeMillis() + "aup.txt"));
            byte[] b = new byte[1024];
            int len;
            while ((len = in.read(b)) != -1) {
                fos.write(b, 0, len);
            }
            OutputStream out = s.getOutputStream();
            out.write("上传成功".getBytes());
            out.close();
            System.out.println("文件上传已保存");
            fos.close();
            in.close();
            s.close();
        }
    }
}
