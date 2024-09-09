class Animal {
    private String name;
    private int runDistance;
    private int swimDistance;

    public Animal(String name, int runDistance, int swimDistance) {
        this.name = name;
        this.runDistance = runDistance;
        this.swimDistance = swimDistance;
    }

    public String getName() {
        return name;
    }

    public void run(int distance) {
        if (distance <= runDistance) {
            System.out.println(name + " пробежал " + distance + " м");
        } else {
            System.out.println(name + " не пробежал " + distance + " м");
        }
    }

    public void swim(int distance) {
        if (distance <= swimDistance) {
            System.out.println(name + " проплыл " + distance + " м");
        } else if (swimDistance == 0) {
            System.out.println(name + " не умеет плавать");
        } else {
            System.out.println(name + " не смог проплыть " + distance + " м");
        }
    }
}

class Dog extends Animal {
    public static int numberOfDogs = 0;

    public Dog(String name) {
        super(name, 500, 10); // Лимит
        numberOfDogs++; // Считаем количество собак
    }
}

class Cat extends Animal {
    public static int numberOfCats = 0;
    private boolean satietyCat;

    public Cat(String name) {
        super(name, 200, 0); // Лимит
        this.satietyCat = false;
        numberOfCats++; // Считаем количество котов
    }

    public void eat(Bowl bowl, int foodAmount) {
        if (bowl.decreaseFood(foodAmount)) {
            this.satietyCat = true;
            System.out.println(getName() + " покушал " + foodAmount + " еды и теперь сыт.");
        } else {
            System.out.println(getName() + " не смог покушать. В миске недостаточно еды.");
        }
    }

    public boolean isSatiety() {
        return satietyCat;
    }
}

class Bowl {
    private int food;

    public Bowl(int food) {
        this.food = food;
    }

    public boolean decreaseFood(int amount) {
        if (amount <= food) {
            food -= amount;
            return true;
        } else {
            return false;
        }
    }

    public void addFood(int amount) {
        if (amount > 0) {
            food += amount;
            System.out.println("В миску добавлено " + amount + " еды.");
        }
    }

    public int getFood() {
        return food;
    }
}

public class Main {
    public static void main(String[] args) {
        Dog dogSharik = new Dog("Шарик");
        Cat catPushok = new Cat("Пушок");
        Cat catMilisa = new Cat("Милиса");

        Bowl bowl = new Bowl(30);
        Cat[] cats = {catPushok, catMilisa};

        for (int i = 0; i < cats.length; i++) {
            cats[i].eat(bowl, 5);
            System.out.println(cats[i].getName() + " сыт: " + cats[i].isSatiety());
        }

        bowl.addFood(10); // Добавляем еду в тарелку
        System.out.println("Всего собак: " + Dog.numberOfDogs);
        System.out.println("Всего котов: " + Cat.numberOfCats);
    }
}