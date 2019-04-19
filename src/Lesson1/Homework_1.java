package Lesson1;

//1. Написать метод, который меняет два элемента массива местами
// (массив может быть любого ссылочного типа);
//2. Написать метод, который преобразует массив в ArrayList;

import java.util.ArrayList;
import java.util.Arrays;

public class Homework_1 {
    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        transfer(arr, 4, 7);

        converting(arr);
    }

    public static <T> void transfer(T[] arr, int a, int b){
        T k = arr[a];
        arr[a] = arr[b];
        arr[b] = k;
        System.out.println(Arrays.toString(arr));
    }

    public static <T> ArrayList converting(T[] arr){
        ArrayList<T> arrayList = new ArrayList<>(Arrays.asList(arr));
        return arrayList;
    }

}
