/**
 * Created by MASK on 23/09/2015.
 */
public class parrot extends animal implements jump, fly {

    public int FlyLength = 4;
    public int JumpHeight = 3;

    parrot(int age, int height, String color, String name, String sex) {
        super(age, height, color, name, sex);
    }

    @Override
    public void fly() {
        System.out.println("- I can fly " + FlyLength + " hours!");
    }

    @Override
    public void jump() {
        System.out.println("- I'm jumping for " + JumpHeight + " santimeters!");
    }

    public void move(int steps) {
        System.out.println(color + " parrot has jumped " + steps + " steps.");
    }

    void voice() {
        System.out.println("- Durrrak!!!");
    }

}
