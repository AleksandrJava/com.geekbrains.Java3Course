package Lesson1.Homework_3;

import java.util.ArrayList;

public class Box<T extends Fruit> {
    ArrayList<T> box;

    public Box() {
        box = new ArrayList<T>();
    }

    void addFruit(T fruit, int number) {
        for (int i = 0; i < number; i++) {
            box.add(fruit);
        }
    }

    Float getWeigth(){
        Float sumWeigth = 0.0f;
        for (T a: box) {
            sumWeigth = sumWeigth + a.getWeight();
        }
        return sumWeigth;
    }

    boolean compare(Box<?> anotherbox){
        return (this.getWeigth() == anotherbox.getWeigth());
    }

    public void shift(Box<T> anotherBox) {
        ArrayList<T> list = anotherBox.box;
        list.addAll(box);
        box.clear();
    }
}

