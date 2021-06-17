package ua.Lysenko.HW15;

import java.util.*;

public class Collections {
    public static void main(String[] args) {
//        arrayList();
//        set();
//        queue();
//        deque();
        map();
    }

    public static void arrayList() {
        List<String> arraylist = new ArrayList<>();
        arraylist.add("first");
        arraylist.add("second");
        arraylist.add("third");
        arraylist.add("fourth");
        arraylist.add("fifth");
        System.out.println(arraylist);
        arraylist.removeAll(arraylist);
        System.out.println(arraylist);
    }

    public static void set() {
        Set<Integer> numberSet = new HashSet<>();
        numberSet.add(1);
        numberSet.add(2);
        numberSet.add(3);
        numberSet.add(4);
        numberSet.add(5);
        System.out.println(numberSet);
        numberSet.removeAll(numberSet);
        System.out.println("Set is empty: " + numberSet.isEmpty());
    }

    public static void queue() {
        Queue<String> stringQueue = new PriorityQueue<>();
        stringQueue.add("One");
        stringQueue.add("Two");
        stringQueue.add("Three");
        stringQueue.add("Four");
        stringQueue.add("Five");

        System.out.println(stringQueue);
        while (stringQueue.peek() != null)
            stringQueue.poll();
        System.out.println(stringQueue);
    }

    public static void deque() {
        Deque<Integer> numbersDeque = new ArrayDeque<>();
        numbersDeque.add(1);
        numbersDeque.add(2);
        numbersDeque.add(3);
        numbersDeque.add(4);
        numbersDeque.add(5);

        System.out.println(numbersDeque);
        while (numbersDeque.peek() != null)
            numbersDeque.pop();
        System.out.println(numbersDeque);
    }

    public static void map() {
        Map<Integer, String> cars = new HashMap<>();
        cars.put(1, "Mercedes");
        cars.put(2, "BMW");
        cars.put(3, "Opel");
        cars.put(4, "Porsche");
        cars.put(5, "Audi");


        System.out.println("В коллекции объектов: " + cars.size());
        Set<Integer> keys = cars.keySet();
        Integer[] keysArray = keys.toArray(new Integer[keys.size()]);
        for (int i = 0; i < keysArray.length; i++) {
            cars.remove(keysArray[i]);
        }

        System.out.println("Остались машины: " + cars.values());
    }
}
