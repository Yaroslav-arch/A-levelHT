package ua.Lysenko.HW17;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<SomeObject> list = new ArrayList<>();
        list.add(new SomeObject(22, "Benjamin", 1));
        list.add(new SomeObject(17, "Alfred", 2));
        list.add(new SomeObject(11, "George", 3));
        list.add(new SomeObject(79, "Abraham", 4));
        list.add(new SomeObject(13, "Aaron", 5));
        list.add(new SomeObject(19, "Christian", 6));
        list.add(new SomeObject(29, "Justin", 7));
        list.add(new SomeObject(31, "Daniel", 8));
        list.add(new SomeObject(23, "Wilfredo", 9));
        list.add(new SomeObject(15, "William", 10));

        List<String> namesList = list.stream()
                .map(SomeObject::getName)
                .collect(Collectors.toList());

        SomeObject maxIdObject = list.stream()
                .max(SomeObject::compareTo)
                .get();
        System.out.println(maxIdObject.getName());

        int aContainersCountSum = list.stream()
                .filter(s -> s.getName().toLowerCase().contains("a"))
                .mapToInt(s -> s.getCount())
                .sum();
        System.out.println(aContainersCountSum);

        Map<Integer, Object> peopleFromList = list.stream()
                .collect(Collectors.toMap(s -> s.getId(), s -> s.getName()));
        peopleFromList.forEach((k, v) -> System.out.println(k + " " + v));

    }
}
