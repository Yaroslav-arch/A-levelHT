package ua.Lysenko.HW17;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SomeObject implements Comparable<SomeObject> {
    private int id;
    private String name;
    private int count;

    @Override
    public int compareTo(SomeObject that) {
        return this.id - that.id;
    }
}