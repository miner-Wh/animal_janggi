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


        ArrayList<user_info> is_my_user = (ArrayList<user_info>) objectInputStream.readObject();

        //FileInputStream fileStream = new FileInputStream("./user_test.dat");
//
        //ObjectInputStream objectInputStream = new ObjectInputStream(fileStream);
        //objectInputStream.close();
//
        //System.out.println(is_my_user.size());
        objectInputStream.close();
        System.out.println(is_my_user.size());
        //for(int a=0;a<objects.size();a++){
        //    user_info temp = objects.get(a);
        //    System.out.println("=======================");
        //    System.out.println("ID: "+temp.ID);
        //    System.out.println("PW: "+temp.PW);
        //    System.out.println("ID: "+temp.name);
        //    System.out.println("ID: "+temp.nick);
        //    System.out.println("ID: "+temp.email);
        //    System.out.println("=======================");
//
        //}

        System.out.println(is_my_user(is_my_user,"admin2","admin2"));
        System.out.println(is_my_user(is_my_user,"admin","admin"));
        System.out.println(is_my_user(is_my_user,"admin2","admin"));

    }
    // 1 있다
    // 0 없다
    // 2 아이디가 없다
    // 3 비번이 틀리다
    public static int is_my_user(ArrayList<user_info> user, String id,String pw){
        for(int a=0;a<user.size();a++){
            user_info temp = user.get(a);
            if(temp.ID.compareTo(id)==0){
                if(temp.PW.compareTo(pw)==0){
                    return 1;
                }
                else
                    return 3;
            }
        }
        return 2;
    }
}
