import java.util.Comparator;

public abstract class Animal implements Comparator{


    int age, height;
    String color;
    String name;
    String sex;
    String type;

    Animal(String type, int age, int height, String color, String name, String sex) {
        this.type = type;
        this.age = age;
        this.height = height;
        this.color = color;
        this.name = name;
        this.sex = sex;
    }

    public void getAnimalDescription() {
        System.out.println(color + " color");

        if (age == 1) System.out.println(age + " age old");
            else System.out.println(age + " ages old");

        if (height == 1) System.out.println("Height is " + height + " meter");
            else System.out.println("Height is " + height + " meters");

        if (!sex.contains("female")) {
            System.out.println("His name is " + name);
            System.out.print("His voice is: ");
            voice();
        }
        else {
            System.out.println("Her name is " + name);
            System.out.print("Her voice is: ");
            voice();
        }

    }

    public String getType() {
        return type;
    }

    public int getAge() {
        return age;
    }

    public int getHeight() {
        return height;
    }

    public String getColor() {
        return color;
    }

    public String getSex() {
        return sex;
    }

    public  String getName() {
        return this.name;
    }

    abstract public void move(int steps);

    abstract void voice();

    final void newAnimal() {
        System.out.println("Some new animal came here...");
    }

    public void getAnimalData() {
        System.out.println(this.type + " " + this.name + " " + this.sex + " " + this.getAge());
    }

    public int compare(Object animal1, Object anmal2){
        Animal a = (Animal)animal1;
        Animal b = (Animal)anmal2;
        return a.getAge() - b.getAge();
    }


}



