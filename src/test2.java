import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class test2  {

    @SuppressWarnings({ "rawtypes", "unchecked", "nls" })
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        FileInputStream fileStream = new FileInputStream("./user_test.ser");

        ObjectInputStream objectInputStream = new ObjectInputStream(fileStream);



        Object object = objectInputStream.readObject();

        objectInputStream.close();

        System.out.println("읽어온 객체의 type->"+ object.getClass());


    }
}
