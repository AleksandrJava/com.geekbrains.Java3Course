package Lesson6.Homework;

//Написать метод, которому в качестве аргумента передается не пустой одномерный целочисленный массив.
//Метод должен вернуть новый массив, который получен путем вытаскивания из исходного массива элементов,
//идущих после последней четверки. Входной массив должен содержать хотя бы одну четверку,
//в методе необходимо выбросить RuntimeException. Написать набор тестов для этого метода
//(по 3-4 варианта входных данных). Вх: [ 1 2 4 4 2 3 4 1 7 ] -> вых: [ 1 7 ].

import java.util.Arrays;

public class ArrayAfterFor {

    public static int[] check(int[] arr) throws RuntimeException {
        int lastFor = 0;
        String str = Arrays.toString(arr);
        if (str.indexOf(String.valueOf(4)) != -1) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == 4) lastFor = i;
            }
            int[] mas = new int[arr.length - lastFor - 1];
            System.arraycopy(arr, lastFor + 1, mas, 0, mas.length);
            return mas;
        } else {
            throw new RuntimeException("4 не найдена");
        }
    }
}
