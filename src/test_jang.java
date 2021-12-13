import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class test_jang {


    public static void main(String[] args) throws IOException, ClassNotFoundException {

        FileInputStream fileStream = new FileInputStream("./user_test.dat");

        ObjectInputStream objectInputStream = new ObjectInputStream(fileStream);


        ArrayList<user_info> my_user = (ArrayList<user_info>) objectInputStream.readObject();
        //user_info object = (user_info) objectInputStream.readObject();

        objectInputStream.close();



        String test1="log/2/admin1/admin1";
        messageHand(test1, my_user);


    }
    public static void messageHand(String a, ArrayList<user_info> user){
        //

        String oper = "";
        String num = "";
        int bg = a.indexOf("/");
        oper = a.substring(0,bg); // 식별자 빼냄
        a = a.substring(bg+1);

        bg= a.indexOf("/");
        num = a.substring(0,bg);
        a = a.substring(bg+1);



        switch (oper){
            case "log":
                System.out.println("in?");
                String ID ="";
                String PW ="";
                bg= a.indexOf("/");
                ID =a.substring(0,bg);
                a = a.substring(bg+1);

                PW =a.substring(0);

                System.out.println(is_my_user(user,ID,PW));
                //serverChatter.sendMSG(is_my_user(user,ID,PW))
                break;
            case "SIGN":
            default:
                break;
        }



        //for(int n=0;n<Integer.valueOf(num);n++){
        //
        //}
    }
    public static int is_my_user(ArrayList<user_info> user, String id, String pw){
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
