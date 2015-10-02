import java.util.LinkedList;


public class Run {

    public static void main(String[] args) {

        LinkedList<Animal> AnimalList = DataFile.getAnimalList();

        System.out.println("There are " + DataFile.getAnimalCount() + " animals");

        allAnimalPresentation(AnimalList);

        AnimalList.forEach(animal -> getAllParameters(animal));

//        AnimalList.forEach(animal -> animal.getAnimalDescription());

        getAbilities(AnimalList.get(3));

    }

    // void getSingleAnimal(array){}
    // void getOldestAnimal(array) {}

    protected static void getAbilities(Animal animal) {
        if (animal instanceof Jump) System.out.println("Jumping");
        if (animal instanceof Fly) System.out.println("Flying");

    }

    protected static void getAllParameters(Animal animal) {
        System.out.println(animal.getClass());
        System.out.println(animal.getName());
        System.out.println(animal.getColor());
        System.out.println(animal.getAge());
        System.out.println(animal.getHeight());
        System.out.println(animal.getSex());
    }

    static void allAnimalPresentation(LinkedList<Animal> animal_list) {
//        animal_list.forEach(animal -> oneAnimalPresentation(animal));
    }

    protected static void oneAnimalPresentation(Animal animal) {
        // print: "Some new Animal came here..."
        animal.newAnimal();

        System.out.println("Oh, it's " + animal.getName() + "!!!");

        // print: Animal moved for few steps
        animal.move((int) (Math.random() * 5) + 2);

        if (!animal.sex.contains("female"))
            System.out.println("He said:");
        else
            System.out.println("She said:");

        // he sad about his abilities
        if (animal instanceof Jump) ((Jump) animal).jump();
        if (animal instanceof Fly) ((Fly) animal).fly();

        if (!animal.sex.contains("female"))
            System.out.println("And he left saying only...");
        else
            System.out.println("And she left saying only...");
        animal.voice();


    }


}
