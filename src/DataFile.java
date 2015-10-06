import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;


public class DataFile {

    static String filepath = "resources/my_animals.txt";

    static int AnimalCount = 0;
    static HashSet<String> typeSet = new HashSet<>();

    protected static LinkedList<Animal> getAnimalList() {
        String animal_type;
        LinkedList<String[]> data_list = getArrayData();
        LinkedList<Animal> AnimalList = new LinkedList<>();

        for (String[] line : data_list) {
            animal_type = line[0];
            typeSet.add(animal_type);
            if (animal_type.equalsIgnoreCase("Wolf"))
                AnimalList.add(new Wolf(
                        line[0], Integer.parseInt(line[1]), Integer.parseInt(line[2]),
                        line[3], line[4], line[5]));
            else if (animal_type.equalsIgnoreCase("Parrot"))
                AnimalList.add(new Parrot(
                        line[0], Integer.parseInt(line[1]), Integer.parseInt(line[2]),
                        line[3], line[4], line[5]));
            else
                System.out.println(line[0] + " " + "Nevedoma zverushka");
        }
        AnimalCount = AnimalList.size();
        return AnimalList;
    }

    public static int getAnimalCount() {
        return AnimalCount;
    }

    public static ArrayList<String> ReadFile(){
        ArrayList<String> stringBuffer = new ArrayList<>();
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(filepath))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuffer.add(line);
                }
        } catch (IOException e) {
            e.printStackTrace();}

        return stringBuffer;
    }

    protected static LinkedList<String[]> getArrayData() {
        //get data from file to string
        ArrayList<String> stringBuffer = ReadFile();
        stringBuffer.remove(0); //remove first service string

        LinkedList<String[]> animal_list = new LinkedList<String[]>();
        Iterator<String> iterator = stringBuffer.iterator();
        String[] temp_string_array;
        String temp_string;
        while (iterator.hasNext()) {
            temp_string = iterator.next();
            temp_string_array = temp_string.split(",");
            animal_list.add(temp_string_array);
        }
        return animal_list;
    }

    protected static HashSet<String> getTypeSet() {
        return typeSet;
    }
}
