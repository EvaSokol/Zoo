/**
 * Created by MASK on 23/09/2015.
 */
public abstract class animal {
    int age, height;
    String color;

    animal(int age, int height, String color) {
        this.age = age;
        this.height = height;
        this.color = color;
    }

    public void move(int steps) {
    }

    void voice() {
    }

    String name(String name) {
        return getClass().toString() + " " + name;
    }

}



