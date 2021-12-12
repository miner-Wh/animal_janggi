import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;


public class test {

    @SuppressWarnings({ "rawtypes", "unchecked", "nls" })
    public static void main(String[] args) throws IOException {

        FileOutputStream fileStream = new FileOutputStream("./user_test.dat");

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileStream);

        user_info sample  = new user_info("admin","admin","min", "min", "whyuk47@naver.com");



        objectOutputStream.writeObject(sample);

        objectOutputStream.close();

    }
}
