import java.io.*;
import java.util.ArrayList;

public class test_jang {


    public static void main(String[] args) throws IOException, ClassNotFoundException {

        FileInputStream fileStream = new FileInputStream("./user_test.dat");

        ObjectInputStream objectInputStream = new ObjectInputStream(fileStream);


        ArrayList<user_info> my_user = (ArrayList<user_info>) objectInputStream.readObject();
        //user_info object = (user_info) objectInputStream.readObject();

        objectInputStream.close();



        String test1="sign/6/ab/b/c/d/e/abcdef@naver.com";
        messageHand(test1, my_user);
        String test2="dup/1/ab";
        messageHand(test2, my_user);


    }
    public static void messageHand(String a, ArrayList<user_info> user) throws IOException {
        //

        String oper = "";
        String num = "";
        int bg = a.indexOf("/");
        oper = a.substring(0,bg); // 식별자 빼냄
        a = a.substring(bg+1);

        bg= a.indexOf("/");
        num = a.substring(0,bg);
        a = a.substring(bg+1);


        String ID ="";
        String PW ="";
        String NAME ="";
        String NICK ="";
        String EMAIL ="";
        String SNS ="";
        String CONTENT ="";

        switch (oper){
            case "log":
                //System.out.println("in?");

                bg= a.indexOf("/");
                ID =a.substring(0,bg);
                a = a.substring(bg+1);

                PW =a.substring(0);

                System.out.println(is_my_user(user,ID,PW));
                //serverChatter.sendMSG(is_my_user(user,ID,PW))

                break;
            case "sign":
                bg= a.indexOf("/");
                ID =a.substring(0,bg);
                a = a.substring(bg+1);

                bg= a.indexOf("/");
                PW =a.substring(0,bg);
                a = a.substring(bg+1);

                bg= a.indexOf("/");
                NAME =a.substring(0,bg);
                a = a.substring(bg+1);

                bg= a.indexOf("/");
                NICK =a.substring(0,bg);
                a = a.substring(bg+1);

                if(num=="5"){

                    EMAIL =a.substring(0);
                }
                else {
                    bg= a.indexOf("/");
                    EMAIL =a.substring(0,bg);
                    a = a.substring(bg+1);
                    SNS = a.substring(0);
                }
                FileOutputStream fileStream = new FileOutputStream("./user_test.dat"); //파일 저장 위치

                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileStream);


                user_info sample= new user_info(ID,PW,NAME,NICK,EMAIL,SNS);
                System.out.println(1);
                user.add(sample);
                //serverChatter.sendMSG(1);
                objectOutputStream.writeObject(user);

                objectOutputStream.close();


                break;
            case "dup":
                //   admin
                ID =a.substring(0);
                is_dup(user,ID);
                System.out.println(is_dup(user,ID));


                break;
            case "all":
                bg= a.indexOf("/");
                NICK =a.substring(0,bg);
                a = a.substring(bg+1);

                CONTENT=a.substring(0);
                System.out.println("\n"+NICK+": "+CONTENT);

                break;
            default:
                break;
        }



        //for(int n=0;n<Integer.valueOf(num);n++){
        //
        //}
    }
    public static int is_my_user(ArrayList<user_info> user, String id, String pw) {
        for (int a = 0; a < user.size(); a++) {
            user_info temp = user.get(a);
            if (temp.ID.compareTo(id) == 0) {
                if (temp.PW.compareTo(pw) == 0) {
                    return 1;//비번 확인
                } else
                    return 3;

            }
        }
        return 2;
    }

    //중복확인//
    public static int is_dup(ArrayList<user_info> user, String id){
        for(int a=0;a<user.size();a++){
            user_info temp=user.get(a);
            if(temp.ID.compareTo(id)==0){
                return 1; //아이디가 같아요
            }
        }
        return 0; //달라요

    }

}