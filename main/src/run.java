/**
 * Created by MASK on 23/09/2015.
 */
public class run {

    public static void main(String[] args) {

        wolf Jack = new wolf(5, 2, "Gray", "Jack", "male");

        Jack.name();

        Jack.move((int) (Math.random() * 5) + 2);

        System.out.println("He said:");

        Jack.jump();

        Jack.voice();

        parrot Koki = new parrot(1, 1, "Green", "Koki", "female");

        Koki.name();

        Koki.move((int) (Math.random() * 5) + 2);

        System.out.println("And shout:");

        Koki.jump();

        Koki.voice();

        System.out.println("Then he added:");

        Koki.fly();
    }

}
