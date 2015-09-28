import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by MASK on 28/09/2015.
 */
public class DataBase {

    static String filepath = "resources/my_animals.txt";

    public static ArrayList<String> ReadFile() {
        ArrayList<String> stringBuffer = new ArrayList<>();
        try {
            File file = new File(filepath);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

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
}
