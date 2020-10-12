package site.newvalue.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/cookie")
public class DemoCookieTest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        resp.setContentType("text/html;charset=utf-8");
        //获取当前时间并编码
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy年MM年dd HH:mm:ss");
        String strDate = df.format(date);
        System.out.println("编码前：" + strDate);
        String s = URLEncoder.encode(strDate, "utf-8");
        System.out.println("编码后:" + s);
        Cookie[] cookies = req.getCookies();
        boolean flag = false;//是否有lastTime
        if (cookies != null && cookies.length > 0) {
            for (Cookie c : cookies) {
                String name = c.getName();
                //不是第一次访问
                if (name.equals("lastTime")) {
                    flag = true;
                    String time = URLDecoder.decode(c.getValue(), "utf-8");
                    c.setValue(s);
                    c.setMaxAge(60 * 60 * 24);
                    resp.addCookie(c);
                    resp.getWriter().write("欢迎回来，您上次访问时间为:" + time);
                    break;
                }
            }
        }
        if (cookies == null || cookies.length == 0 || flag == false) {
            Cookie c = new Cookie("lastTime", s);
            c.setMaxAge(60 * 60 * 24);
            resp.addCookie(c);
            resp.getWriter().write("您好，欢迎首次访问");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
