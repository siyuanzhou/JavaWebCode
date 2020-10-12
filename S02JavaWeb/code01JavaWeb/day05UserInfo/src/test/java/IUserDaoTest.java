import org.junit.Test;
import site.newvalue.dao.IUserDao;
import site.newvalue.dao.impl.UserDaoImpl;
import site.newvalue.domain.User;

import java.util.List;


public class IUserDaoTest {
    IUserDao userDao=new UserDaoImpl();
    @Test
    public void testFindAll(){
        List<User> users=userDao.findAll();
        System.out.println(users);
    }

    @Test
    public void testFindUserByUsernameAndPassword(){
        User user=userDao.findUserByUsernameAndPassword("zsy","123");
        System.out.println(user);
    }

    @Test
    public void testAdd(){
        User u=new User(1,"123","男",23,"123","123","123@qq.com","","");
        userDao.add(u);
    }

    @Test
    public void testDelete(){
        userDao.delete(2);
    }

    @Test
    public void testFindById(){
        User user = userDao.findById(1);
        System.out.println(user);
    }

    @Test
    public void testUpdate(){
        User u=new User(45,"123","男",23,"123","123","123@qq.com","as","sa");
        userDao.update(u);
    }


//
//    /**
//     * 查询总记录数
//     * @return
//     * @param condition
//     */
//    int findTotalCount(Map<String, String[]> condition);
//
//    /**
//     * 分页查询每页记录
//     * @param start
//     * @param rows
//     * @param condition
//     * @return
//     */
//    List<User> findByPage(int start, int rows, Map<String, String[]> condition);
}
