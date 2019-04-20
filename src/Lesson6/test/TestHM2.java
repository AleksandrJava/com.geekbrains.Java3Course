package Lesson6.test;

import Lesson6.Homework.OneAndFor;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class TestHM2 {
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{1, 2, 4, 4, 2, 3, 4, 1, 7}, true},
                {new int[]{1, 9, 4, 4, 8, 2, 4}, true},
                {new int[]{4, 3, 7, 7, 4, 8, 3, 2}, false}
        });
    }

    private int[] a;
    private boolean flag;

    public TestHM2(int[] a, boolean flag) {
        this.a = a;
        this.flag = flag;
    }

    private OneAndFor oneAndFor;

    @Before
    public void startTest() {
        oneAndFor = new OneAndFor();
    }

    @Test
    public void testAfterFor() {
        Assert.assertEquals(flag, OneAndFor.check(a));
    }

}
