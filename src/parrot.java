/**
 * Created by MASK on 23/09/2015.
 */
public class parrot extends animal implements jump, fly {

    String name;
    String sex;
    public int FlyLenght = 4;
    public int JumpHeight = 3;

    parrot(int age, int height, String color, String name, String sex) {
        super(age, height, color);
        this.name = name;
        this.sex = sex;
    }


    @Override
    public void fly() {
        System.out.println("- I can fly and I'm flying!");
    }

    @Override
    public void jump() {
        System.out.print("- I'm jumping for " + JumpHeight + " santimeters!");
    }

    public void move(int steps) {
        System.out.println(color + " parrot have jumped " + steps + " steps.");
    }

    void voice() {
        System.out.println(" Durrrak!!!");
    }

    void name() {
        System.out.println("<-<-<-<-< " + super.name("object " + this.name + " >->->->->->"));
    }
}
