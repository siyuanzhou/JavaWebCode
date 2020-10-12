package cn.itcast.travel.web.servlet;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BaseServlet extends HttpServlet {
    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        //请求路径URI
        String requestURI = req.getRequestURI();
        System.out.println(requestURI);

        //获取方法并调用
        String method = requestURI.substring(requestURI.lastIndexOf("/") + 1);
        try {
            //this谁调用表示谁,getDeclaredMethod忽略访问修饰符
            Method method1 = this.getClass().getMethod(method, HttpServletRequest.class, HttpServletResponse.class);
//            method1.setAccessible(true);
            method1.invoke(this,req,res);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    //将对象序列化为json 并返回客户端
    public void writeValue(Object o,HttpServletResponse resp) throws IOException {
        String json= new ObjectMapper().writeValueAsString(o);
        resp.setContentType("application/json;charset=utf-8");
        resp.getWriter().write(json);
    }

    //将对象序列化为json
    public String writeAsString(Object o) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(o);
    }
}
