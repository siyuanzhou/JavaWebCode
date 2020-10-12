import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import site.newvalue.service.IAccountService;

public class TestIOCGetBean {
    @Test
    public void testGetBean(){
        // 获取核心容器对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        // 根据id获取Bean对象
        IAccountService as  = (IAccountService)ac.getBean("accountService");
        // 执行as的具体方法
        as.saveAccount();
    }
}
