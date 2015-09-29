/**
 * Created by MASK on 23/09/2015.
 */
public class Wolf extends Animal implements Jump, Cloneable{

        public int JumpHeight = 3;

        public Wolf(int age, int height, String color, String name, String sex) {
            super(age, height, color, name, sex);

        }

        @Override
        public void jump() {
            System.out.println("- I'm jumping for " + JumpHeight + " meters!");
        }

        void voice() {
            System.out.println("- Arrrrgh!!!");
        }

        public void move(int steps) {
            System.out.println(color + " Wolf has run " + steps + " steps.");
        }


    @Override
    protected Wolf clone() throws CloneNotSupportedException {
        return new Wolf(this.age, this.height, this.color, this.name, this.sex);
    }

    @Override
    public void getAnimalDescription() {
        System.out.println("It's a wolf");
        super.getAnimalDescription();
        if (!sex.contains("female"))
            System.out.println("He can jump for " + JumpHeight + "meters");
        else
            System.out.println("She can jump for " + JumpHeight + "meters");
    }
}
