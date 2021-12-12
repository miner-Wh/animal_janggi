import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;


public class test2  {

    @SuppressWarnings({ "rawtypes", "unchecked", "nls" })
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        FileInputStream fileStream = new FileInputStream("./user_test.dat");

        ObjectInputStream objectInputStream = new ObjectInputStream(fileStream);



        user_info object = (user_info) objectInputStream.readObject();

        objectInputStream.close();

        System.out.println(object.email);




    }
}
