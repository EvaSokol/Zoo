import java.util.LinkedList;


public class Run {

    public static void main(String[] args){

//        getNewAnimal(new Wolf(5, 2, "Gray", "Jack", "male"));
//        getNewAnimal(new Parrot(1, 1, "Green", "Koki", "female"));
//        getNewAnimal(new Wolf(4, 3, "Dark", "Vasya", "male"));
//        getNewAnimal(new Parrot(1, 1, "Blue", "Mario", "male"));

        LinkedList<String[]> animal_list = DataBase.getAnimalList();
//        animalPresentation(animal_list);

//        for (an : animal_list)
//            an.get
        }

    private static void animalPresentation(LinkedList<String[]> animal_list) {
        String animal_type;
        String[] try_array;
        for (String[] one_animal : animal_list) {
            animal_type = one_animal[0];
            if (animal_type.equalsIgnoreCase("Wolf"))
                    getNewAnimal(new Wolf(
                            Integer.parseInt(one_animal[1]), Integer.parseInt(one_animal[2]),
                            one_animal[3], one_animal[4], one_animal[5]));
            if (animal_type.equalsIgnoreCase("Parrot"))
                getNewAnimal(new Parrot(
                        Integer.parseInt(one_animal[1]), Integer.parseInt(one_animal[2]),
                        one_animal[3], one_animal[4], one_animal[5]));
            else
                    System.out.println(one_animal[0] + " " + "Nevedoma zverushka");
            }
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
