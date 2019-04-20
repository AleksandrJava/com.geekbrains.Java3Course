package Lesson7;

//Создать класс, который может выполнять «тесты».
//В качестве тестов выступают классы с наборами методов с аннотациями @Test.

//Для этого у него должен быть статический метод start(), которому в качестве параметра передается
//или объект типа Class, или имя класса.
//Из «класса-теста» вначале должен быть запущен метод с аннотацией @BeforeSuite, если такой имеется.
//Далее запущены методы с аннотациями @Test, а по завершении всех тестов – метод с аннотацией @AfterSuite.

//К каждому тесту необходимо добавить приоритеты (int числа от 1 до 10),
//в соответствии с которыми будет выбираться порядок их выполнения. Если приоритет одинаковый,
//то порядок не имеет значения. Методы с аннотациями @BeforeSuite и @AfterSuite должны присутствовать
//в единственном экземпляре, иначе необходимо бросить RuntimeException при запуске «тестирования».

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;

public class Main {

    public  static void start(Class a){
        Method[] allMethods = a.getDeclaredMethods();
        ArrayList<Method> list = new ArrayList<>();
        for (Method m: allMethods) {
            if(m.isAnnotationPresent(Test.class)) {
                int priority = m.getAnnotation(Test.class).priority();
                if(priority < 1 || priority > 10) {
                    throw  new RuntimeException("Указан неправильный приоритет для метода " + m.getName());
                } else list.add(m);
            }
        }
        list.sort(new Comparator<Method>() {
            @Override
            public int compare(Method m1, Method m2) {
                return m2.getAnnotation(Test.class).priority() - m1.getAnnotation(Test.class).priority();
            }
        });
        int countBeforeSuite = 0;
        int countAfterSuite = 0;
        for (Method m: allMethods) {
            if(m.isAnnotationPresent(BeforeSuite.class)) {
                countBeforeSuite++;
                if(countBeforeSuite > 1) {
                    throw new RuntimeException("Должен содержаться только один метод BeforeSuite");
                } else list.add(0, m);
            }
            if(m.isAnnotationPresent(AfterSuite.class)) {
                countAfterSuite++;
                if(countAfterSuite > 1) {
                    throw new RuntimeException("Должен содержаться только один метод AfterSuite");
                } else list.add(m);
            }
        }
        for (Method o: list) {
            try {
                o.invoke(null);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        start(ClassForTests.class);
    }
}
