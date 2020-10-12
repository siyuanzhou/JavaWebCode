package site.syzhou;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientTCP {
    public static void main(String[] args) throws IOException {
        System.out.println("客户端启动，发送数据。。。");
        Scanner sc = new Scanner(System.in);
        String line;
        while ((line = sc.nextLine()) != "-1") {
            Socket s = new Socket("127.0.0.1", 6666);
            OutputStream out = s.getOutputStream();
            out.write(line.getBytes());
            InputStream in = s.getInputStream();
            byte[] b = new byte[1024];
            int len = in.read(b);
            String msg = new String(b, 0, len);
            System.out.println("收到服务器回复：" + msg);
            in.close();
            out.close();
        }
    }
}
