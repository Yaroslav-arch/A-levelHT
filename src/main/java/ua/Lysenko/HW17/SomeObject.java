package ua.Lysenko.HW17;

import java.util.Comparator;

public class SomeObject {
    private int id;
    private String name;
    private int count;

    public SomeObject(int id, String name, int count) {
        this.id = id;
        this.name = name;
        this.count = count;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }

    public int compareById(SomeObject a) { //это чтобы с компараторами не мучаться

        return this.getId() - a.getId();
    }


}