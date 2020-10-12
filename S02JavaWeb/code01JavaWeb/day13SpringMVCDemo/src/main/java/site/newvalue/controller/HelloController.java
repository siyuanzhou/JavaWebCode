package site.newvalue.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import site.newvalue.domain.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.Map;

@Controller
public class HelloController {
    @RequestMapping("/deleteAccount")
    public String deleteAccount(Date date) {
        System.out.println("删除了账户。。。。"+date);
        return "success";
    }
    //只需要在控制器的方法参数定义HttpServletRequest和HttpServletResponse对象
    @RequestMapping("/testServletAPI")
    public String testServletAPI(HttpServletRequest request,
                                 HttpServletResponse response,
                                 HttpSession session) {
        System.out.println(request.getParameter("date"));
        return "success";
    }
    @RequestMapping(path="/hello")
    public String sayHello(@RequestParam(value="username",required=false)String name) {
        System.out.println(name);
        return "success";
    }
    @RequestMapping("/useRequestBody")
    public String  useRequestBody(@RequestBody(required=false) String body){
        System.out.println(body);
        return "success";
    }
    @ModelAttribute
    public void showUser(String name, Map<String, User> map) {
        System.out.println("showUser执行了...");
        // 模拟从数据库中查询对象
        User user = new User();
        user.setName(name);
        user.setPassword("123");
        user.setMoney(100);
        map.put("abc", user);
    }
    @RequestMapping(path="/updateUser")
    public String updateUser(@ModelAttribute(value="abc") User user) {
        System.out.println(user);
        return "success";
    }
    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView(){
        System.out.println("testModelAndView");
        // 创建ModelAndView对象
        ModelAndView mv = new ModelAndView();
        // 模拟从数据库中查询出User对象
        User user = new User();
        user.setName("小凤");
        user.setPassword("456");
        // 把user对象存储到mv对象中，也会把user对象存入到request对象
        mv.addObject("user",user);
        System.out.println(mv);
        // 跳转到哪个页面
        mv.setViewName("success");
        return mv;
    }
    @RequestMapping("/testAjax")
    //使用@ResponseBody注解把JavaBean对象转换成json字符串，直接响应
    //使用@RequestBody注解把json的字符串转换成JavaBean的对象
    public @ResponseBody User testAjax(@RequestBody User user){
        // 客户端发送ajax的请求，传的是json字符串，后端把json字符串封装到user对象中
        System.out.println(user);
        // 做响应，模拟查询数据库
        user.setName("haha");
        return user;
    }
}
