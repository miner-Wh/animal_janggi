import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;


public class test2  {

    @SuppressWarnings({ "rawtypes", "unchecked", "nls" })
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println("so happy");

        FileInputStream fileStream = new FileInputStream("./user_test.dat");

        ObjectInputStream objectInputStream = new ObjectInputStream(fileStream);


        ArrayList<user_info> objects = (ArrayList<user_info>) objectInputStream.readObject();
        //user_info object = (user_info) objectInputStream.readObject();

        objectInputStream.close();

        System.out.println(objects.size());




    }
}
