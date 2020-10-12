package cn.itcast.travel.web.servlet;

import cn.itcast.travel.domain.ResultInfo;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.UserService;
import cn.itcast.travel.service.impl.UserServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/user/*")
public class UserServlet extends BaseServlet {
    UserService userService = new UserServiceImpl();

    /**
     * 登录
     * @param req
     * @param resp
     * @throws IOException
     */
    public void login(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //获取数据
        Map<String, String[]> parameterMap = req.getParameterMap();
        //封装对象
        User u = new User();
        try {
            BeanUtils.populate(u, parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //UserService userService = new UserServiceImpl();
        User user = userService.login(u);
        ResultInfo resultInfo = new ResultInfo();
        HttpSession session = req.getSession();
        if (user == null) {
            resultInfo.setFlag(false);
            resultInfo.setErrorMsg("用户名密码错误！");
        } else {
            if (user.getStatus().equals("N")) {
                resultInfo.setFlag(false);
                resultInfo.setErrorMsg("您未完成邮件激活！");
            } else {
                session.setAttribute("user", user);
                resultInfo.setFlag(true);
            }
        }
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(resultInfo);
        resp.setContentType("application/json;charset=utf-8");
        resp.getWriter().write(json);
    }

    /**
     * 注册
     * @param req
     * @param resp
     * @throws IOException
     */
    public void regist(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String check = req.getParameter("check");
        HttpSession session = req.getSession();
        String checkcode_server = (String) session.getAttribute("CHECKCODE_SERVER");
        session.removeAttribute("CHECKCODE_SERVER");//只用一次
        if (!check.equalsIgnoreCase(checkcode_server)) {
            ResultInfo resultInfo = new ResultInfo();
            resultInfo.setFlag(false);
            resultInfo.setErrorMsg("验证码错误");
            //结果序列化并返回
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(resultInfo);
            resp.setContentType("application/json;charset=utf-8");
            resp.getWriter().write(json);
            return;
        }

        //获取数据
        Map<String, String[]> parameterMap = req.getParameterMap();

        //封装对象
        User u = new User();
        try {
            BeanUtils.populate(u, parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println(u);
        //调用Service
        //UserService userService = new UserServiceImpl();
        boolean flag = userService.regist(u);
        //返回结果对象
        ResultInfo resultInfo = new ResultInfo();
        if (flag) {
            resultInfo.setFlag(true);
        } else {
            resultInfo.setFlag(false);
            resultInfo.setErrorMsg("注册失败");
        }

        //结果序列化并返回
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(resultInfo);
        resp.setContentType("application/json;charset=utf-8");
        resp.getWriter().write(json);
    }

    /**
     * 激活
     * @param req
     * @param resp
     * @throws IOException
     */
    public void active(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //1.获取激活码
        String code = req.getParameter("code");
        if (code != null) {
            //2.调用service完成激活
            //UserService service = new UserServiceImpl();
            boolean flag = userService.active(code);
            //3.判断标记
            String msg = null;
            if (flag) {
                //激活成功
                msg = "激活成功，请<a href='../login.html'>登录</a>";
            } else {
                //激活失败
                msg = "激活失败，请联系管理员!";
            }
            resp.setContentType("text/html;charset=utf-8");
            resp.getWriter().write(msg);
        }
    }

    /**
     * 查询用户名
     * @param req
     * @param resp
     * @throws IOException
     */
    public void finduser(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session=req.getSession();
        User user=(User)session.getAttribute("user");
        String json= new ObjectMapper().writeValueAsString(user);
        resp.setContentType("application/json;charset=utf-8");
        resp.getWriter().write(json);
    }

    /**
     * 退出
     * @param req
     * @param resp
     * @throws IOException
     */
    public void exit(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.getSession().invalidate();
        resp.sendRedirect(req.getContextPath()+"/login.html");
    }
}
