import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import site.newvalue.IUserService;
import site.newvalue.dao.IUserDao;
import site.newvalue.domain.User;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class IUserDaoTest {
    @Autowired
    private IUserDao iUserDao;

    @Test
    public void testFindAll() {
        List<User> users = iUserDao.findAll();
        System.out.println(users);
    }


    @Autowired
    private IUserService userService;



    @Test
    public void testServiceFindAll(){
        List<User> users = userService.findAll();
        System.out.println(users);
    }

    @Test
    public void testFindOne(){
        User user = userService.findById(1);
        System.out.println(user);
    }

    @Test
    public void testUpdate(){
        User user = userService.findById(1);
        System.out.println("修改之前的用户"+user);

        user.setAge(55);
        userService.updateUser(user);

        user = userService.findById(1);
        System.out.println("修改之后的用户"+user);
    }
}

