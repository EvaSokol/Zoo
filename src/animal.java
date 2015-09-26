/**
 * Created by MASK on 23/09/2015.
 */
public abstract class animal {
    int age, height;
    String color;
    String name;
    String sex;

    animal(int age, int height, String color, String name, String sex) {
        this.age = age;
        this.height = height;
        this.color = color;
        this.name = name;
        this.sex = sex;
    }

    public  String getName() {
        return this.name;
    }
    public void move(int steps) {
    }

    abstract void voice();

    final void newAnimal() {
        System.out.println("Some new animal came here...");
    }

}



