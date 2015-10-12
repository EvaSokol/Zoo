import animals.Animal;
import animals.Fly;
import animals.Jump;
import utils.DataFile;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;



public class Run {

    public static void main(String[] args) {

        LinkedList<Animal> AnimalList = DataFile.getAnimalList();

        System.out.println("There are " + DataFile.getAnimalCount() + " animals total in the list.");

        allAnimalPresentation(AnimalList); //A little story about every animal

        AnimalList.forEach(animal -> getAllParameters(animal)); //Print list of all animal parameters

        AnimalList.forEach(animal -> animal.getAnimalDescription()); //get descriptions for each animal

        getAbilities(AnimalList.get(2)); // get list of abilities for some animal

/*        ********Sort animals by age:*************/
        PrintAnimalList(AnimalList); // Print list of all animals: type - name - sex - age
        System.out.println("-----------");
        SortByAge(AnimalList); //Sort min -> max
        PrintAnimalList(AnimalList); // Sorted list

        printAnimalList(getSingleAnimals(AnimalList)); //print list of all single animals

/*        ********Remove single animals:*************/
        PrintAnimalList(AnimalList); // Print list of all animals: type - name - sex - age
        System.out.println("-----------");
        removeSingleAnimals(AnimalList); //remove single animals from list and print them
        System.out.println("-----------");
        PrintAnimalList(AnimalList); // Print list of animals left in the list

        printOldestAnimals(AnimalList); //print list of animals with max age

        System.out.println("-----------");

        PrintAnimalList(getAllThisType(AnimalList, "parrot")); //print list of specified type animals wolf/parrot/lion

    }

    static void removeSingleAnimals(LinkedList<Animal> AnimalList) {
        LinkedList<Animal> singleAnimalList = getSingleAnimals(AnimalList);
        AnimalList.removeAll(singleAnimalList);
        System.out.println("Next single animals are removed:");
        printAnimalList(singleAnimalList);
    }

    static void printAnimalList(LinkedList<Animal> AnimalList) {
        for (Animal animal: AnimalList) {
            System.out.println(animal.getType() + " " + animal.getSex() + " " + animal.getName());
        }
         }

    static LinkedList<Animal> getSingleAnimals(LinkedList<Animal> AnimalList) {
        LinkedList<Animal> SingleAnimals = new LinkedList<>();

        HashSet<String> types = DataFile.getTypeSet();
        ArrayList<String> ArrTypes = new ArrayList<>();

        types.forEach(type -> ArrTypes.add(type));

        int typesCount = types.size();
        ArrayList<Animal>[][] PairAnimals = new ArrayList[typesCount][2];

        for (int i=0; i<typesCount; i++) {
            PairAnimals[i] = new ArrayList[2];
            PairAnimals[i][0] = new ArrayList<>();
            PairAnimals[i][1] = new ArrayList<>();
        }

        int index;

        for (Animal animal : AnimalList) {
            String type = animal.getType();
            index = ArrTypes.indexOf(type);
            if (animal.getSex().equalsIgnoreCase("male")) {
                PairAnimals[index][0].add(animal);
            }
            else if (animal.getSex().equalsIgnoreCase("female"))
                PairAnimals[index][1].add(animal);
        }
        int singles;

        for (ArrayList<Animal>[] one_type : PairAnimals) {
            singles = one_type[0].size() - one_type[1].size();
            if (singles > 0) {
                while (singles>0){
                    SingleAnimals.add(one_type[0].get(singles-1));
                    singles --;
                }
            }
            else if (singles < 0) {
                while (singles < 0) {
                    SingleAnimals.add(one_type[1].get(Math.abs(singles) - 1));
                    singles ++;
                }
            }

        }

        return SingleAnimals;
    }

    static void printOldestAnimals(LinkedList<Animal> AnimalList) {
        int max_age = 0;
        LinkedList<Animal> OldAnimals = new LinkedList<>();
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
        animal_list.forEach(animal -> oneAnimalPresentation(animal));
    }

    protected static void oneAnimalPresentation(Animal animal) {
        // print: "Some new animals.Animal came here..."
        animal.newAnimal();

        System.out.println("Oh, it's " + animal.getName() + "!!!");

        // print: animals.Animal moved for few steps
        animal.move((int) (Math.random() * 5) + 2);

        if (!animal.getSex().contains("female"))
            System.out.println("He said:");
        else
            System.out.println("She said:");

        // he sad about his abilities
        if (animal instanceof Jump) ((Jump) animal).jump();
        if (animal instanceof Fly) ((Fly) animal).fly();

        if (!animal.getSex().contains("female"))
            System.out.println("And he left saying only...");
        else
            System.out.println("And she left saying only...");
        animal.voice();


    }

    protected static void PrintAnimalList(LinkedList<Animal> AnimalList) {
        AnimalList.forEach(animal -> animal.getAnimalData());
    }

    protected static void SortByAge(LinkedList<Animal> animalList) {
//        animals.Animal animal = new animals.Wolf("a", 1, 1, "a", "a", "a");
//        animalList.sort((o1, o2) -> animal.compare(o1, o2));

        animalList.sort((o1, o2) -> o1.getAge() - o2.getAge());


    }

    protected static LinkedList<Animal> getAllThisType(LinkedList<Animal> AnimalList, String type) {
        LinkedList<Animal> thisTypeAnimals= new LinkedList<>();
        for (Animal animal : AnimalList)
            if (animal.getType().equalsIgnoreCase(type))
                thisTypeAnimals.add(animal);
        return thisTypeAnimals;
    }
}
