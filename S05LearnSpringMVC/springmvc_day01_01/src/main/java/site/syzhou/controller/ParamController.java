package site.syzhou.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import site.syzhou.domain.Account;
import site.syzhou.domain.User;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/param")
public class ParamController {

    @RequestMapping("/testParam")
    public String testParam(String username, String password) {
        System.out.println("执行了" + username + ":" + password);
        return "success";
    }

    @RequestMapping("/getAPI")
    public String getAPI(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("执行了");
        System.out.println(request);
        HttpSession session=request.getSession();
        System.out.println(session);
        ServletContext servletContext=session.getServletContext();
        System.out.println(servletContext);
        return "success";
    }

    @RequestMapping("/saveAccount")
    public String saveAccount(Account account) {
        System.out.println(account.toString());
        return "success";
    }

    @RequestMapping("/saveUser")
    public String saveUser(User user) {
        System.out.println(user.toString());
        return "success";
    }



}
