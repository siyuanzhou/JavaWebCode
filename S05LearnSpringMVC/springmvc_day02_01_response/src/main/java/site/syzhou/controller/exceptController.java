package site.syzhou.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import site.syzhou.exception.SysException;

@Controller
@RequestMapping("/exception")
public class exceptController {
    @RequestMapping("/testException")
    public String  testException() throws SysException {
        System.out.println("testException执行了。。。");
        try {
            int a=10/0;
        } catch (Exception e) {
            e.printStackTrace();
            throw new SysException("数据库执行出现了错误！....");
        }
        return "success";
    }


}
