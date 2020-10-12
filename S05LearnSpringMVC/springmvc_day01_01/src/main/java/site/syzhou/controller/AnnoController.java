package site.syzhou.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import site.syzhou.domain.User;

import java.util.Date;
import java.util.HashMap;

@Controller
@RequestMapping("/anno")
public class AnnoController {
    @RequestMapping("/requestParam")
    public String requestParam(@RequestParam(value = "username",required = false) String name)
    {
        System.out.println("执行了..");
        System.out.println(name);
        return "success";
    }

    @RequestMapping("/requestBody")
    public String requestBody(@RequestBody String body)
    {
        System.out.println("执行了..");
        System.out.println(body);
        return "success";
    }

    @RequestMapping("/PathVariable/{sid}")
    public String PathVariable(@PathVariable(value = "sid") String id)
    {
        System.out.println("执行了..");
        System.out.println(id);
        return "success";
    }
    @RequestMapping("/requestHeader")
    public String requestHeader(@RequestHeader(value = "accept") String header)
    {
        System.out.println("执行了..");
        System.out.println(header);
        return "success";
    }

    @RequestMapping("/cookieValue")
    public String cookieValue(@CookieValue(value = "JSESSIONID") String cookieValue)
    {
        System.out.println("执行了..");
        System.out.println(cookieValue);
        return "success";
    }

    @RequestMapping("/modelAttribute")
    public String modelAttribute(@ModelAttribute(value = "aaa") User user) {
        System.out.println("执行了..");
        System.out.println(user.toString());
        return "success";
    }

    @ModelAttribute
    public User showUser(String uname){
        System.out.println("ModelAttribute修饰方法先执行");
        User user=new User();
        user.setUname(uname);
        user.setAge(10);
        user.setDate(new Date());
        return user;
    }
    @ModelAttribute
    public void showUser(String uname, HashMap<String,User> map) {
        System.out.println("ModelAttribute修饰方法先执行");
        User user=new User();
        user.setUname(uname);
        user.setAge(10);
        user.setDate(new Date());
        map.put("aaa",user);
    }


}
