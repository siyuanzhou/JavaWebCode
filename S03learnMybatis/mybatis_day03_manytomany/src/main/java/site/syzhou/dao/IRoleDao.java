package site.syzhou.dao;


import site.syzhou.domain.Role;

import java.util.List;

public interface IRoleDao {
    //查询所有角色的账户信息
    public List<Role> findAll();
}
