package Lesson5;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class Car implements Runnable {
    CyclicBarrier cbar;
    private CountDownLatch cdl_1;
    private CountDownLatch cdl_2;
    private static int CARS_COUNT;
    static {
        CARS_COUNT = 0;
    }
    private Race race;
    private int speed;
    private String name;
    private static volatile Integer count = 1;
    public String getName() {
        return name;
    }
    public int getSpeed() {
        return speed;
    }
    public Car(Race race, int speed, CyclicBarrier cbar, CountDownLatch cdl_1, CountDownLatch cdl_2) {
        this.cbar = cbar;
        this.cdl_1 = cdl_1;
        this.cdl_2 = cdl_2;
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }


    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int) (Math.random() * 800));
            System.out.println(this.name + " готов");
            cdl_1.countDown();
            Thread.sleep(15);
            cbar.await();

        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }
        synchronized (count) {
            if (count == 1) {
                System.out.println(this.name + " WIN! Занял " + count + " МЕСТО");
                count++;
            } else {
                System.out.println(this.name + " занял " + count + " МЕСТО");
                count++;
            }
        }

        cdl_2.countDown();
    }


}
