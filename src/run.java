import java.util.ArrayList;
import java.util.Iterator;

/**
  Created by MASK on 23/09/2015.
 */
public class run {

    enum Animaltype {wolf, parrot}
    public static void main(String[] args){

//        getNewAnimal(new wolf(5, 2, "Gray", "Jack", "male"));
//        getNewAnimal(new parrot(1, 1, "Green", "Koki", "female"));
//        getNewAnimal(new wolf(4, 3, "Dark", "Vasya", "male"));
//        getNewAnimal(new parrot(1, 1, "Blue", "Mario", "male"));

        //get data from file to string
        ArrayList<String> stringBuffer = DataBase.ReadFile();
        stringBuffer.remove(0); //remove first service string

        // get array of animals and their parameters
        int animalcount = stringBuffer.size(); // number of animals
        String[][] array = new String[animalcount][6];
        Iterator<String> iterator = stringBuffer.iterator();
        String line;
        for (int i=0; i<animalcount; i++) {
            line = iterator.next();
            array[i] = line.split(",");
//            for (String s : array[i])
//                System.out.println(s);
        }

        Animaltype animalclass = Animaltype.wolf;
        String[] thisanimal;
        for (int j=0; j<animalcount; j++){
            thisanimal = array[j];
            for (String item : thisanimal)
                System.out.println(item);
            switch (animalclass) {  //get class of new animal
                case wolf:
//                    getNewAnimal(new wolf(Integer.parseInt(array[j][1]), Integer.parseInt(array[j][2]), array[j][3], array[j][4], array[j][5]));
                    getNewAnimal(new wolf(5, 2, "Gray", "Jack", "male"));
                    break;
                default:
                    System.out.println("Nevedoma zverushka");
            }
        }

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
