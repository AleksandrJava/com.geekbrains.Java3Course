package Lesson1.Homework_3;

//Есть классы Fruit -> Apple, Orange (больше фруктов не надо);

//Класс Box, в который можно складывать фрукты. Коробки условно сортируются по типу фрукта,
//поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
//Для хранения фруктов внутри коробки можно использовать ArrayList;

//Сделать метод getWeight(), который высчитывает вес коробки, зная количество фруктов и вес одного фрукта
//(вес яблока – 1.0f, апельсина – 1.5f. Не важно, в каких это единицах);

//Внутри класса Коробка сделать метод compare, который позволяет сравнить текущую коробку с той,
//которую подадут в compare в качестве параметра, true – если она равны по весу, false – в противном случае
//(коробки с яблоками мы можем сравнивать с коробками с апельсинами);

//Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую
//(помним про сортировку фруктов: нельзя яблоки высыпать в коробку с апельсинами).
//Соответственно, в текущей коробке фруктов не остается, а в другую перекидываются объекты,
//которые были в этой коробке;

//Не забываем про метод добавления фрукта в коробку.

public class MainBox {
    public static void main(String[] args) {
        Box<Apple> box1 = new Box<Apple>();
        box1.addFruit(new Apple(), 8);

        Box<Orange> box2 = new Box<Orange>();
        box2.addFruit(new Orange(), 6);

        Box<Apple> box3 = new Box<Apple>();
        box3.addFruit(new Apple(), 5);

        System.out.println(box1.getWeigth());
        System.out.println(box2.getWeigth());
        System.out.println(box3.getWeigth());

        System.out.println(box1.compare(box2));

        box1.shift(box3);

        System.out.println(box1.getWeigth());
        System.out.println(box3.getWeigth());
    }
}
