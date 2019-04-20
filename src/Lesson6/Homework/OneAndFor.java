package Lesson6.Homework;

//Написать метод, который проверяет состав массива из чисел 1 и 4.
//Если в нем нет хоть одной четверки или единицы, то метод вернет false;
//Написать набор тестов для этого метода (по 3-4 варианта входных данных).

public class OneAndFor {

    public static boolean check(int[] arr) {
        boolean has1 = false, has4 = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) has1 = true;
            if (arr[i] == 4) has4 = true;
        }
        return (has1 && has4);
    }
}
