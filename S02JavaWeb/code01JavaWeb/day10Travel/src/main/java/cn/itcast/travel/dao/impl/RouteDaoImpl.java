package cn.itcast.travel.dao.impl;

import cn.itcast.travel.dao.RouteDao;
import cn.itcast.travel.domain.Route;
import cn.itcast.travel.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

public class RouteDaoImpl implements RouteDao {
    JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public int findTotalCount(int cid, String rname) {
        //多条件组合查询
        String sql = "select count(*) from tab_route where 1=1 ";
        //判断参数是否有值
        List param = new ArrayList();

        StringBuilder sb = new StringBuilder(sql);
        if (cid != 0) {
            sb.append(" and cid= ? ");
            param.add(cid);
        }
        if (rname != null && rname.length() > 0) {
            sb.append(" and rname like ? ");
            param.add("%" + rname + "%");
        }
        sql = sb.toString();
        return template.queryForObject(sql, Integer.class, param.toArray());
    }

    @Override
    public List<Route> findByPage(int cid, int start, int pageSize, String rname) {
        String sql = "select * from tab_route where 1=1 ";
        //判断参数是否有值
        List param = new ArrayList();

        StringBuilder sb = new StringBuilder(sql);
        if (cid != 0) {
            sb.append(" and cid= ? ");
            param.add(cid);
        }
        if (rname != null && rname.length() > 0) {
            sb.append(" and rname like ? ");
            param.add("%" + rname + "%");
        }
        sb.append(" limit ?,? ");
        sql = sb.toString();
        System.out.println(sql);
        param.add(start);
        param.add(pageSize);
        return template.query(sql, new BeanPropertyRowMapper<Route>(Route.class), param.toArray());
    }

    @Override
    public Route findOne(int rid) {
        String sql = "select * from tab_route where rid=? ";
        Route route = null;
        try {
            route = template.queryForObject(sql, new BeanPropertyRowMapper<>(Route.class), rid);
        } catch (Exception e) {
        }
        return route;
    }
}
