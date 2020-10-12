package site.syzhou;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTCP {
    public static void main(String[] args) throws IOException {
        System.out.println("服务器启动，等待连接...");
        ServerSocket ss = new ServerSocket(6666);
        while (true) {
            Socket s = ss.accept();
            InputStream in = s.getInputStream();
            byte[] b = new byte[1204];
            int len = in.read(b);
            String msg = new String(b, 0, len);
            System.out.println("收到数据" + msg);
            OutputStream out = s.getOutputStream();
            out.write(("服务器已收到" + msg).getBytes());
            out.close();
            in.close();
        }
    }


}
