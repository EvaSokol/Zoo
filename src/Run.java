import java.util.LinkedList;


public class Run {

    public static void main(String[] args) {

        LinkedList<Animal> AnimalList = DataFile.getAnimalList();

        System.out.println("There are " + DataFile.getAnimalCount() + " animals");

//        allAnimalPresentation(AnimalList);

//        AnimalList.forEach(animal -> getAllParameters(animal));

//        AnimalList.forEach(animal -> animal.getAnimalDescription());

//        getAbilities(AnimalList.get(3));

//        getSingleAnimal(AnimalList);

        printOldestAnimals(AnimalList);
    }

    static void getSingleAnimal(LinkedList<Animal> AnimalList) {
         int wolf_male_count = 0;
         int wolf_female_count = 0;
         int parrot_male_count = 0;
         int parrot_female_count = 0;

         for (Animal animal : AnimalList) {
             if (animal instanceof Wolf) {
                 if (animal.getSex().contains("female"))
                     wolf_female_count++;
                 else wolf_male_count++;
             }
             if (animal instanceof Parrot) {
                 if (animal.getSex().contains("female"))
                     wolf_female_count++;
                 else wolf_male_count++;
             }
         }

             int wolf_male_men = wolf_male_count - wolf_female_count;
             if (wolf_male_men > 0)
                 System.out.println("There are " + wolf_male_men + " single wolf boy(s).");
             if (wolf_male_men < 0)
                 System.out.println("There are " + wolf_male_men + " single wolf girl(s).");

             int parrot_male_men = parrot_male_count - parrot_female_count;

             if (parrot_male_men > 0)
                 System.out.println("There are " + parrot_male_men + " single parrot boy(s).");
             if (parrot_male_men < 0)
                 System.out.println("There are " + parrot_male_men + " single parrot girl(s).");
         }

    static void printOldestAnimals(LinkedList<Animal> AnimalList) {
        int max_age = 0;
        LinkedList<Animal> OldAnimals = new LinkedList<Animal>();
        for (Animal animal : AnimalList) {
            if (animal.getAge() == max_age)
                OldAnimals.add(animal);
            else if (animal.getAge() > max_age) {
                OldAnimals.clear();
                OldAnimals.add(animal);
                max_age = animal.getAge();
            }
        }
        System.out.println("Max age is " + max_age);
        OldAnimals.forEach(animal -> System.out.println(animal.getName()));
    }

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
