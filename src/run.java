import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/**
  Created by MASK on 23/09/2015.
 */
public class run {

    public static void main(String[] args){

//        getNewAnimal(new wolf(5, 2, "Gray", "Jack", "male"));
//        getNewAnimal(new parrot(1, 1, "Green", "Koki", "female"));
//        getNewAnimal(new wolf(4, 3, "Dark", "Vasya", "male"));
//        getNewAnimal(new parrot(1, 1, "Blue", "Mario", "male"));

        //get data from file to string
        ArrayList<String> stringBuffer = DataBase.ReadFile();
        stringBuffer.remove(0); //remove first service string

        LinkedList<String[]> animal_list = new LinkedList<String[]>();
        Iterator<String> iterator = stringBuffer.iterator();
        String[] temp_string_array;
        String temp_string;
        while (iterator.hasNext()) {
            temp_string = iterator.next();
            temp_string_array = temp_string.split(",");
            animal_list.add(temp_string_array);
            for (String str : temp_string_array) {
                System.out.print(str.length() + " : ");
                System.out.println(str);
            }
        }

        String animal_type;
        String[] try_array;
        for (String[] one_animal : animal_list) {
            animal_type = one_animal[0];
            if (animal_type.equalsIgnoreCase("wolf"))
                    getNewAnimal(new wolf(
                            Integer.parseInt(one_animal[1]), Integer.parseInt(one_animal[2]),
                            one_animal[3], one_animal[4], one_animal[5]));
            if (animal_type.equalsIgnoreCase("parrot"))
                getNewAnimal(new wolf(5, 2, "Gray", "Jack", "male"));
            else
                    System.out.println(one_animal[0] + " " + "Nevedoma zverushka");
            }
        }


//        Animal_type animalclass = Animaltype.wolf;
//        String[] thisanimal;
//        for (int j=1; j<animalcount; j++){
//            thisanimal = array[j];
//            for (String item : thisanimal)
//                System.out.println(item);
//            switch (animalclass) {  //get class of new animal
//                case wolf:
////                    getNewAnimal(new wolf(Integer.parseInt(array[j][1]), Integer.parseInt(array[j][2]), array[j][3], array[j][4], array[j][5]));
//                    System.out.println(thisanimal[1]);
//
////                    getNewAnimal(new wolf(5, 2, "Gray", "Jack", "male"));
//                    break;
//                default:
//                    System.out.println("Nevedoma zverushka");
//            }
//        }



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
