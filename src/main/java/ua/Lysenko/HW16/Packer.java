package ua.Lysenko.HW16;

public class Packer {

    public static void main(String[] args) {
        Packer packer = new Packer();
        Box<Food> foodBox = new Box<>();
        Box<Cake> cakeBox = new Box<>();
        packer.repackage(foodBox, cakeBox);

    }

    public <E extends Goods, T extends E> void repackage(Box<E> to, Box<T> from) {
        to.put(from.get());
    }

}

// Остальные классы сделал специально не паблик,
// чтобы компилятор не ругался и не пришлось создавать новые файлы

class Box<T extends Goods> {

    private T item;

    public void put(T item) {
        this.item = item;
    }

    public T get() {
        return this.item;
    }
}

class Goods {
}

class Food extends Goods {
}

class Bakery extends Food {
}

class Cake extends Bakery {
}

class Pie extends Bakery {
}

class Tart extends Bakery {
}