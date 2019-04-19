package Lesson3.Serializable;

import java.io.Serializable;

public class Player implements Serializable {
    String name;
    int level;

    public Player(String name, int level) {
        this.name = name;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }
}
