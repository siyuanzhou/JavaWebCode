package cn.itcast.travel.dao;

import cn.itcast.travel.domain.PageBean;
import cn.itcast.travel.domain.Route;

import java.util.List;

public interface RouteDao {
    //根据cid查询总条数
    public int findTotalCount(int cid,String rname);

    //查询当前页数据集合
    public List<Route> findByPage(int cid,int start,int pageSize,String rname);

    //查询route
    Route findOne(int rid);
}
