package site.newvalue.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {
    @Before
    public void init() {
        System.out.println("init...");
    }

    @After
    public void close() {
        System.out.println("close...");
    }

    @Test
    public void testAdd() {
        System.out.println(new Calculator().add(2, 3));
        Assert.assertEquals(5, new Calculator().add(2, 3));

    }
}
