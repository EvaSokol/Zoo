import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;


public class DataBase {

    static String filepath = "resources/my_animals.txt";

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

    protected static LinkedList<String[]> getAnimalList() {
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
