package Lesson6.test;

import Lesson6.Homework.ArrayAfterFor;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class TestHM1 {
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{1, 2, 4, 4, 2, 3, 4, 1, 7}, new int[]{1,7}},
                {new int[]{1, 9, 4, 4, 8, 2, 4}, new int[]{}},
                {new int[]{4, 3, 7, 7, 4, 8, 3, 2}, new int[]{8, 3, 2}}
        });
    }

    private int[] a;
    private int[] b;

    public TestHM1(int[] a, int[] b) {
        this.a = a;
        this.b = b;
    }

    private ArrayAfterFor arrayAfterFor;

    @Before
    public void startTest() {
        arrayAfterFor = new ArrayAfterFor();
    }

    @Test
    public void testAfterFor() {
        Assert.assertArrayEquals(b, ArrayAfterFor.check(a));
    }

    @Test(expected = RuntimeException.class)
    public void testException() {
        ArrayAfterFor.check(new int[]{0, 1, 2, 3, 5, 7, 8, 9});
    }
}
