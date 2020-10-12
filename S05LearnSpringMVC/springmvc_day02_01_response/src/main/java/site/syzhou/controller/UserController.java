package site.syzhou.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import site.syzhou.domain.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/testString")
    public String testString(Model model)
    {
        System.out.println("getUser执行了..");
        //模拟查询User对象
        User user=new User();
        user.setUsername("美美");
        user.setPassword("123");
        user.setAge(18);
        model.addAttribute("user",user);
        return "success";
    }

    @RequestMapping("/testVoid")
    public void testVoid(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("getVoid执行..");
        System.out.println("请求转发");
//        request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request,response);
        System.out.println("请求重定向");
        //请求不到WEB-INF里的东西
//        response.sendRedirect(request.getContextPath()+"/index.jsp");
        //直接响应
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().println("你好");
    }

    /**
     * 返回ModelAndView
     * @return
     */
//    @RequestMapping("/testModelAndView")
//    public ModelAndView testModelAndView(){
//        // 创建ModelAndView对象
//        ModelAndView mv = new ModelAndView();
//        System.out.println("testModelAndView方法执行了...");
//        // 模拟从数据库中查询出User对象
//        User user = new User();
//        user.setUsername("小凤");
//        user.setPassword("456");
//        user.setAge(30);
//        // 把user对象存储到mv对象中，也会把user对象存入到request对象
//        mv.addObject("user",user);
//        // 跳转到哪个页面
//        mv.setViewName("success");
//        return mv;
//    }
    @RequestMapping("/testModelAndView")
    public ModelAndView testModelandView(){
        ModelAndView mv=new ModelAndView();
        User user=new User();
        user.setAge(18);
        user.setUsername("zsy");
        user.setPassword("123");

        mv.addObject("user",user);
        mv.setViewName("success");
        return mv;
    }

    @RequestMapping("/testForwardOrRedirect")
    public String testForwardOrRedirect()
    {
        System.out.println("testForwardOrRedirect执行");
        //return "forward:/WEB-INF/pages/success.jsp";
        return "redirect: /index.jsp";
    }

    /**
     * 模拟异步请求响应
     */
    @RequestMapping("/testAjax")
    public @ResponseBody
    User testAjax(@RequestBody User user){
        System.out.println("testAjax方法执行了...");
        // 客户端发送ajax的请求，传的是json字符串，后端把json字符串封装到user对象中
        System.out.println(user);
        // 做响应，模拟查询数据库
        user.setUsername("haha");
        user.setAge(40);
        // 做响应
        return user;
    }

//      @RequestMapping("/testAjax")
//      public void testAjax(@RequestBody String body){
//          System.out.println("testAjax方法执行了...");
//          System.out.println(body);
//      }

}
