import cn.itcast.travel.util.MailUtils;
import org.junit.Test;

import java.lang.annotation.Target;

public class TestDemo {
    @Test
    public void testMail(){
        MailUtils.sendMail("siyuanzhou@163.com","test","test");
    }
}
