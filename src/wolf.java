/**
 * Created by MASK on 23/09/2015.
 */
public class wolf extends animal implements jump{

        String name;
        String sex;
        public int JumpHeight = 3;

        public wolf(int age, int height, String color, String name, String sex) {
            super(age, height, color);
            this.name = name;
            this.sex = sex;
        }

        @Override
        public void jump() {
            System.out.print("- I'm jumping for " + JumpHeight + " meters!");
        }

        void voice() {
            System.out.println(" Arrrrgh!!!");
        }

        public void move(int steps) {
            System.out.println(color + " wolf have run " + steps + " steps.");
        }

        void name() {
            System.out.println("<<<<<<<<<<<<< " + super.name("object " + this.name + " >>>>>>>>>>>>>>>>>"));
        }


    }

