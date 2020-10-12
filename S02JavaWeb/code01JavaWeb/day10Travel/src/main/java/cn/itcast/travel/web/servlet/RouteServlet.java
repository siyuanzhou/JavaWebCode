package cn.itcast.travel.web.servlet;

import cn.itcast.travel.domain.PageBean;
import cn.itcast.travel.domain.Route;
import cn.itcast.travel.service.RouteService;
import cn.itcast.travel.service.impl.RouteServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

@WebServlet("/route/*")
public class RouteServlet extends BaseServlet {
    private RouteService routeService = new RouteServiceImpl();
    //分页查询
    public void pageQuery(HttpServletRequest res, HttpServletResponse resp) throws UnsupportedEncodingException {
        String currentPagestr = res.getParameter("currentPage");
        String pageSizestr = res.getParameter("pageSize");
        String cidstr = res.getParameter("cid");
        String rname=res.getParameter("rname");
        System.out.println(cidstr+rname);
        int cid=0;
        if(cidstr!=null&&cidstr.length()>0&&!"null".equals(cidstr)){
            cid=Integer.parseInt(cidstr);
        }
        int currentPage=0;
        if(currentPagestr!=null&&currentPagestr.length()>0){
            currentPage=Integer.parseInt(currentPagestr);
        }else {
            currentPage=1;
        }
        int pageSize=0;
        if(pageSizestr!=null&&pageSizestr.length()>0){
            pageSize=Integer.parseInt(pageSizestr);
        }else {
            pageSize=5;
        }
        if(rname!=null&&"null".equals(rname)){
            rname=null;
        }

        //调用Sercive
        PageBean<Route> pb=routeService.pageQuery(cid,pageSize,currentPage,rname);
        //4. 将pageBean对象序列化为json，返回
        try {
            writeValue(pb,resp);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //查询具体旅游线路
    public void findOne(HttpServletRequest res, HttpServletResponse resp) throws IOException {
        String ridstr = res.getParameter("rid");
        int rid=0;
        if(ridstr!=null&&ridstr.length()>0&&!"null".equals(ridstr)){
            rid=Integer.parseInt(ridstr);
        }
        Route route = routeService.findOne(rid);
        writeValue(route,resp);
    }
}
