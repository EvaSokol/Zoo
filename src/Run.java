import java.util.LinkedList;


public class Run {

    public static void main(String[] args) {

        LinkedList<Animal> AnimalList = DataBase.getAnimalList();

        animalPresentation(AnimalList);


    }

    private static void animalPresentation(LinkedList<Animal> animal_list) {
        animal_list.forEach(animal -> getNewAnimal(animal));
    }

    protected static void getNewAnimal(Animal an) {
        // print: "Some new Animal came here..."
        an.newAnimal();

        System.out.println("Oh, it's " + an.getName() + "!!!");

        // print: Animal moved for few steps
        an.move((int) (Math.random() * 5) + 2);

        if (!an.sex.contains("female"))
            System.out.println("He said:");
        else
            System.out.println("She said:");

        // he sad about his abilities
        Jump jumper = (an instanceof Jump)? ((Jump) an) : null;
        if (jumper != null) jumper.jump();

        Fly flier = (an instanceof Fly)? ((Fly) an) : null;
        if (flier != null) flier.fly();

        if (!an.sex.contains("female"))
            System.out.println("And he left saying only...");
        else
            System.out.println("And she left saying only...");
        an.voice();


    }


}
