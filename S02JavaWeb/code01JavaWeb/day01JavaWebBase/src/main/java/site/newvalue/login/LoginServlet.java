package site.newvalue.login;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");


        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String checkCode = req.getParameter("checkCode");

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        String checkCode_sess = (String) req.getSession().getAttribute("checkCode_sess");
        req.getSession().removeAttribute("checkCode_sess");
        if (checkCode_sess != null && checkCode.equalsIgnoreCase(checkCode_sess)) {
            //简化，需要查询数据库
            if (user.getUsername().equals("123") && user.getPassword().equals("123")) {
                req.getSession().setAttribute("user", user);
                resp.sendRedirect(req.getContextPath() + "/succ.jsp");
            } else {
                req.setAttribute("login_error", "用户名或密码错误");
                req.getRequestDispatcher("/login.jsp").forward(req, resp);
            }
        } else {
            req.setAttribute("check_error", "验证码错误");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }
    }
}
