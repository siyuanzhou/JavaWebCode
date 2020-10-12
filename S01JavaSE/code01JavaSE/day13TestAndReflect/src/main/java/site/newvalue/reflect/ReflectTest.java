package site.newvalue.reflect;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

public class ReflectTest {
    public static void main(String[] args) throws IOException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, ClassNotFoundException {
        Properties pro = new Properties();
        InputStream in = ReflectTest.class.getClassLoader().getResourceAsStream("pro.properties");
        pro.load(in);
        String className = pro.getProperty("className");
        String methodName = pro.getProperty("methodName");
        System.out.println(className + methodName);
        Class cls = Class.forName(className);
        Object object = cls.newInstance();
        Method method = cls.getMethod(methodName);
        method.invoke(object);
    }
}
