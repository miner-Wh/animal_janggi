import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public class test {

    @SuppressWarnings({ "rawtypes", "unchecked", "nls" })
    public static void main(String[] args) throws IOException {

        FileOutputStream fileStream = new FileOutputStream("./user_test.dat"); //파일 저장 위치

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileStream);

        user_info sample1  = new user_info("admin1","admin1","min1", "min1", "whyuk1@naver.com");
        user_info sample2  = new user_info("admin2","admin2","min2", "min2", "whyuk2@naver.com");
        user_info sample3  = new user_info("admin3","admin3","min3", "min3", "whyuk3@naver.com");

        ArrayList<user_info> sample = new ArrayList<>();
        sample.add(sample1);
        sample.add(sample2);
        sample.add(sample3);

        objectOutputStream.writeObject(sample);

        objectOutputStream.close();
        System.out.println("ads");

    }
}
