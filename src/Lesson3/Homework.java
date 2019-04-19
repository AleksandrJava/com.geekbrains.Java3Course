package Lesson3;

//Прочитать файл (около 50 байт) в байтовый массив и вывести этот массив в консоль;

//Последовательно сшить 5 файлов в один (файлы примерно 100 байт). Может пригодиться следующая конструкция:
//ArrayList<InputStream> al = new ArrayList<>();
//Enumeration<InputStream> e = Collections.enumeration(al);

//Написать консольное приложение, которое умеет постранично читать текстовые файлы (размером > 10 mb).
//Вводим страницу (за страницу можно принять 1800 символов), программа выводит ее в консоль.

//Контролируем время выполнения: программа не должна загружаться дольше 10 секунд,
//а чтение – занимать свыше 5 секунд.

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Scanner;

public class Homework {
    private static RandomAccessFile pageReader;
    private static final int PAGE = 1800;
    private static final String FILE_NAME = "src/Lesson3/123/big.txt";

    public static void main(String[] args) throws IOException {
        test1();
        test2();
        test3();
    }


    static void test1(){
        try{
            byte[] text = FileToByteArray("src/Lesson3/123/2.txt");
            printArray(text);
            System.out.println(" ");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    static void test2() throws IOException{
        ArrayList<InputStream> al = new ArrayList<>();

        try {
            al.add(new FileInputStream("src/Lesson3/123/1.txt"));
            al.add(new FileInputStream("src/Lesson3/123/2.txt"));
            al.add(new FileInputStream("src/Lesson3/123/3.txt"));
            al.add(new FileInputStream("src/Lesson3/123/4.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Enumeration<InputStream> e = Collections.enumeration(al);
        SequenceInputStream in = new SequenceInputStream(e);

        int x;
        while ((x = in.read()) != -1) {
            System.out.print((char)x);
        }
        in.close();
    }

    static void test3() {
        try {
            System.out.println(" ");
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите номер страницы");
            String sPage = scanner.nextLine();
            long pageNumber = Long.parseLong(sPage);

            long t = System.currentTimeMillis();
            pageReader = new RandomAccessFile(FILE_NAME, "r");
            pageReader.seek(pageNumber * PAGE);
            int x;
            for (int i = 0; i < PAGE; i++) {
                x = pageReader.read();
                //если -1, то выводим в консоль "The End" и прерываем цикл чтения
                if (x != -1) {
                    System.out.print((char) x);
                } else {
                    System.out.println("The End");
                    break;
                }
            }
            System.out.println(" ");
            System.out.println("Время чтения файла: " + (System.currentTimeMillis()-t));
        } catch (IOException e){
            e.printStackTrace();
        }
    }



    private static void printArray(byte[] text) {
        System.out.print("[");
        for (int i = 0; i < text.length; i++) {
            System.out.print(text[i] + " ");
        }
        System.out.print("]");
    }


    private static byte[] FileToByteArray(String fileName) throws IOException {
        BufferedInputStream input = new BufferedInputStream(new FileInputStream(fileName));
        byte[] text = new byte[input.available()];
        input.read(text);
        input.close();
        return text;
    }

}
