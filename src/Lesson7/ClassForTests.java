package Lesson7;

public class ClassForTests {
    @BeforeSuite
    public static void before() {
        System.out.println("Before");
    }
    @Test
    public static  void met1() {
        System.out.println("met1");
    }
    @Test(priority = 8)
    public static  void method2() {
        System.out.println("met2");
    }
    @Test(priority = 4)
    public static  void method3() {
        System.out.println("met3");
    }
    @AfterSuite
    public static void after() {
        System.out.println("After");
    }
}
