import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;


public class DataBase {

    static String filepath = "resources/my_animals.txt";

    protected static LinkedList<Animal> getAnimalList() {
        String animal_type;
        LinkedList<String[]> data_list = getArrayData();
        LinkedList<Animal> AnimalList = new LinkedList<>();
        for (String[] line : data_list) {
            animal_type = line[0];
            if (animal_type.equalsIgnoreCase("Wolf"))
                AnimalList.add(new Wolf(
                        Integer.parseInt(line[1]), Integer.parseInt(line[2]),
                        line[3], line[4], line[5]));
            else if (animal_type.equalsIgnoreCase("Parrot"))
                AnimalList.add(new Parrot(
                        Integer.parseInt(line[1]), Integer.parseInt(line[2]),
                        line[3], line[4], line[5]));
            else
                System.out.println(line[0] + " " + "Nevedoma zverushka");
        }
        System.out.println("There are " + AnimalList.size() + " animals.");
        return AnimalList;
    }

    public static ArrayList<String> ReadFile() {
        ArrayList<String> stringBuffer = new ArrayList<String>();
        try {
            File file = new File(filepath);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

//            FileInputStream inputStream = new FileInputStream(file);
//            String line1 = inputStream.;

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuffer.add(line);
            }
            fileReader.close();
//            System.out.println("Contents of file:");
//            Iterator<String> iterator = stringBuffer.iterator();
//            while (iterator.hasNext()){
//                System.out.println(iterator.next());
//            }
        } catch (IOException e) {
            e.printStackTrace();
        }
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
            for (String str : temp_string_array) {
//                System.out.println(str);
            }
        }
        return animal_list;
    }
}
