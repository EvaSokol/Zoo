/**
  Created by MASK on 23/09/2015.
 */
public class run {

    public static void main(String[] args){

        getNewAnimal(new wolf(5, 2, "Gray", "Jack", "male"));
        getNewAnimal(new parrot(1, 1, "Green", "Koki", "female"));
        getNewAnimal(new wolf(4, 3, "Dark", "Vasya", "male"));
        getNewAnimal(new parrot(1, 1, "Blue", "Mario", "male"));

    }

    protected static void getNewAnimal(animal an) {
        // print: "Some new animal came here..."
        an.newAnimal();

        System.out.println("Oh, it's " + an.getName() + "!!!");

        // print: animal moved for few steps
        an.move((int) (Math.random() * 5) + 2);

        System.out.println("He said:");

        // he sad about his abilities
        jump jumper = (an instanceof jump)? ((jump) an) : null;
        if (jumper != null) jumper.jump();

        fly flier = (an instanceof fly)? ((fly) an) : null;
        if (flier != null) flier.fly();

        if (!an.sex.contains("female"))
            System.out.println("And he left saying only...");
        else
            System.out.println("And she left saying only...");
        an.voice();


    }


}
