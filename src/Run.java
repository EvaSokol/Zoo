import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;


public class Run {

    public static void main(String[] args) {

        LinkedList<Animal> AnimalList = DataFile.getAnimalList();

        System.out.println("There are " + DataFile.getAnimalCount() + " animals");

//        allAnimalPresentation(AnimalList);

//        AnimalList.forEach(animal -> getAllParameters(animal));

//        AnimalList.forEach(animal -> animal.getAnimalDescription());

//        getAbilities(AnimalList.get(3));

//        PrintAnimalList(AnimalList);
//        System.out.println("-------------");

//        SortByAge(AnimalList);

//        PrintAnimalList(AnimalList);

        printAnimalList(getSingleAnimals1(AnimalList));

        System.out.println("-----------");

        removeSingleAnimals(AnimalList);

//        printOldestAnimals(AnimalList);


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
        int wolf_male_men = 0;
        int parrot_male_men =0;

        LinkedList<Animal> singleAnimals = new LinkedList<>();

        for (Animal animal : AnimalList) {
            if (animal.getType().equalsIgnoreCase("Wolf")) {
                if (animal.getSex().contains("female"))
                    wolf_male_men --;
                else wolf_male_men ++;
            }
            if (animal.getType().equalsIgnoreCase("parrot")) {
                if (animal.getSex().contains("female"))
                    parrot_male_men --;
                else parrot_male_men ++;
            }
        }

        if (wolf_male_men > 0) {
            System.out.println("There are " + wolf_male_men + " single wolf boy(s).");
            for (Animal animal : AnimalList) {
                if ((wolf_male_men >0) & animal.getType().equalsIgnoreCase("wolf") & animal.getSex().equalsIgnoreCase("male")) {
                    singleAnimals.add(animal);
                    wolf_male_men--;
                    }
                }

            }
        else if (wolf_male_men < 0) {
            System.out.println("There are " + Math.abs(wolf_male_men) + " single wolf girl(s).");
                for (Animal animal : AnimalList) {
                    if ((wolf_male_men <0) & animal.getType().equalsIgnoreCase("wolf") & animal.getSex().equalsIgnoreCase("female")) {
                        singleAnimals.add(animal);
                        wolf_male_men++;
                    }
            }
        }

        if (parrot_male_men > 0) {
            System.out.println("There are " + parrot_male_men + " single parrot boy(s).");
                for (Animal animal : AnimalList) {
                    if (parrot_male_men >0 & animal.getType().equalsIgnoreCase("parrot") & animal.getSex().equalsIgnoreCase("male")) {
                        singleAnimals.add(animal);
                        parrot_male_men--;
                    }
                }
        }
        else if (parrot_male_men < 0) {
            System.out.println("There are " + Math.abs(parrot_male_men) + " single parrot girl(s).");
                for (Animal animal : AnimalList) {
                    if ((parrot_male_men <0) & animal.getType().equalsIgnoreCase("parrot") & animal.getSex().equalsIgnoreCase("female")) {
                        singleAnimals.add(animal);
                        parrot_male_men++;
                    }
                }
        }
        return singleAnimals;
    }

    static LinkedList<Animal> getSingleAnimals1(LinkedList<Animal> AnimalList) {
        LinkedList<Animal> SingleAnimals = new LinkedList<>();

        HashSet<String> types = DataFile.getTypeSet();
        ArrayList<String> ArrTypes = new ArrayList<>();

        types.forEach(type -> ArrTypes.add(type));

        int typesCount = types.size();
        ArrayList<Animal>[][] PairAnimals = new ArrayList[typesCount][2];

        for (int i=0; i<typesCount; i++) {
            PairAnimals[i] = new ArrayList[2];
        }

        int index;
        ArrayList<Animal> TypeSex = new ArrayList<>();

        for (Animal animal : AnimalList) {
            String type = animal.getType();
            index = ArrTypes.indexOf(type);
            if (animal.getSex().equalsIgnoreCase("male")) {
                TypeSex.clear();
                TypeSex.add(animal);
                PairAnimals[index][0] = TypeSex;
            }
            else if (animal.getSex().equalsIgnoreCase("female"))
                TypeSex.clear();
                TypeSex.add(animal);
                PairAnimals[index][1] = TypeSex;
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
                    SingleAnimals.add(one_type[1].get(singles - 1));
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

    protected static void PrintAnimalList(LinkedList<Animal> AnimalList) {
        AnimalList.forEach(animal -> animal.getAnimalData());
    }

    protected static void SortByAge(LinkedList<Animal> AnimalList) {
        Animal animal = new Wolf("a", 1, 1, "a", "a", "a");
        AnimalList.sort((o1, o2) -> animal.compare(o1, o2));
    }
}
