package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.UserDao;
import cn.itcast.travel.dao.impl.UserDaoImpl;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.UserService;
import cn.itcast.travel.util.MailUtils;
import cn.itcast.travel.util.UuidUtil;

public class UserServiceImpl implements UserService {
    UserDao userDao=new UserDaoImpl();
    @Override
    public boolean regist(User user) {
        User u = userDao.findByUsername(user.getUsername());
        if(u!=null){
            return false;
        }
        //设置激活状态和激活码
        user.setStatus("N");
        user.setCode(UuidUtil.getUuid());
        userDao.save(user);

        //发送激活邮件
        String content="<a href='http://localhost:8080/day10Travel_war_exploded/user/active?code="+user.getCode()+"'>点击激活黑马旅游网</a>";
        MailUtils.sendMail(user.getEmail(),content,"激活邮件");
        return true;
    }

    @Override
    public boolean active(String code) {
        //1.根据激活码查询用户对象
        User user = userDao.findByCode(code);
        if(user != null){
            //2.调用dao的修改激活状态的方法
            userDao.updateStatus(user);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public User login(User user) {
       return  userDao.findUsernameAndPassword(user);
    }
}
