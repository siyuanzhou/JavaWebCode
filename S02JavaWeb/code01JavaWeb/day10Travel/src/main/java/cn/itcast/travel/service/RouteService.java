package cn.itcast.travel.service;

import cn.itcast.travel.domain.PageBean;
import cn.itcast.travel.domain.Route;

public interface RouteService {
    PageBean<Route> pageQuery(int cid, int pageSize, int currentPage,String rname);

    Route findOne(int rid);
}
