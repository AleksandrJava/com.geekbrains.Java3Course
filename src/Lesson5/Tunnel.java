package Lesson5;

import java.util.concurrent.Semaphore;

public class Tunnel extends Stage {
    public Tunnel() {
        this.length = 160;
        this.description = "Тоннель " + length + " метров";
    }

    Semaphore semaphore = new Semaphore(MainClass.getCarsCount()/2);

    @Override
    public void go(Car c) {
        try {
            try {

                if(semaphore.availablePermits() == 0) {
                    System.out.println(c.getName() + " ждет, пока туннель освободится");
                }
                semaphore.acquire();
                System.out.println(c.getName() + " начал этап: " + description);
                Thread.sleep(length / c.getSpeed() * 1000);
                semaphore.release();

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(c.getName() + " закончил этап: " + description);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
