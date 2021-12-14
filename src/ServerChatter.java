import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

// 소켓을 이용하여 클라이언트 1개와 직접 연결되어 있다.
// ArrayList<> 인 chatters 에 소속되어있는 또다른 소켓과 데이타를 주고받는 쓰래드 클래스
class ServerChatter extends Thread{
 // 클라이언트와 직접 연결되어 있는 소켓
 Socket socket;
 BufferedReader br; // 소켓으로부터의 최종 입력 스트림
 PrintWriter pw;  // 소켓으로부터의 최종 출력 스트림


 // 현재 서버에 접속된 전체 클라이언트 정보가 저장되어 있다.
 ArrayList<ServerChatter> chatters;
 String c_id;
 String id; // 아이디(별칭)--> 대화메세지에 보여질 id(대화명) ==> 로그인처리에 의해 구함
 boolean isLogin;
 ChatRoom room;

 public ServerChatter(Socket socket, ChatRoom room){
  this.socket = socket;
  this.room = room;

  // 소켓으로부터 최종 입출력 스트림 얻기
  try{
   br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
   pw = new PrintWriter(socket.getOutputStream());
  }catch(IOException e){
   System.out.println(e.getMessage());
  }
 }

 // 대화명을 입력받는 처리 --> 확장되어지면 데이타베이스에 id/pass 를 검색하여
 //         로그인 기능으로 확장할 수 있다.
 public void login(){

  String members[] = {"민우혁","홍의정","장윤영","강성연"}; //접속 가능한 아이디가 4개만 존재한다고 가정한다.
  String tempId = null;

  try{
   while(true){
    tempId = br.readLine();
    boolean isOk = false;

    for(int i=0;i<members.length;i++){
     if(tempId.equals(members[i])){
      isOk = true;
     }
    }
    if(isOk){
     this.id = tempId;
     this.isLogin = true;
     sendMessage("ok");
     System.out.println("서버 - 로그인 이름 확인");
     break;
    }
    else {
     sendMessage("error");
     System.out.println("서버 - 로그인 이름 XXX");
    }
   }
  }catch(IOException e){
   System.out.println(e.getMessage());
   System.out.println("login()처리에서 예외 발생.....");
  }
 }


 public void run(){
  String c_id="";
  try{
   FileInputStream fileStream = new FileInputStream("./user_test.dat");

   ObjectInputStream objectInputStream = new ObjectInputStream(fileStream);


   ArrayList<user_info> my_user = (ArrayList<user_info>) objectInputStream.readObject();


   objectInputStream.close();
   String message = "";
   System.out.println("in2");
   while(!message.equals("bye")){

    System.out.println("in3");
    System.out.println(id +" 클라이언트가 메세지를 기다립니다.");
    message = br.readLine();   // 받는 부분 인풋 스트림
    System.out.println("in4");
    System.out.println(message);
    System.out.println("받은 메세지 ==>" + id + ":" + message);
    messageHand(message, my_user);

    if(message.equals("bye")){
     room.broadCasting(id+"님이 퇴장하셨습니다.");}

   }
  }catch (FileNotFoundException e){

  }catch(IOException e){
   System.out.println(e.getMessage());
   System.out.println("메세지를 수신하여 송신중 예외 발생....");
  }catch (ClassNotFoundException e){

  }
  finally{
   room.exitRoom(this);
   close();
   System.out.println("연결을 닫고 쓰레드 종료....");
  }
 }
 //메세지를 보내는 메소드
 void sendMessage(String message){
  try{
   System.out.println("sever chatter sendMessage is run");
   pw.println(message);
   pw.flush();
  }catch(Exception e){
   System.out.println(e.getMessage());
   System.out.println("sendMessage()에서 예외 발생....");
  }
 }

 public void close(){
  try{
   br.close();
   pw.close();
   socket.close();
  }catch(Exception e){
   System.out.println("close()..도중 예외 발생!");
  }
 }
 public void messageHand(String a, ArrayList<user_info> user) throws IOException {
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
    System.out.println("in?");

    bg= a.indexOf("/");
    ID =a.substring(0,bg);
    a = a.substring(bg+1);

    PW =a.substring(0);

    System.out.println(is_my_user(user,ID,PW));
    sendMessage(is_my_user(user,ID,PW));
    c_id ="ID";

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
    sendMessage("1");
    objectOutputStream.writeObject(user);

    objectOutputStream.close();


    break;
   case "myin":

    System.out.println(c_id);

    sendMessage(c_id);


    break;
   case "dup":
    //   admin
    ID =a.substring(0);
    is_dup(user,ID);
    System.out.println(is_dup(user,ID));

    sendMessage(is_dup(user,ID));


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
 }
 public static String is_my_user(ArrayList<user_info> user, String id, String pw){
  for(int a=0;a<user.size();a++){
   user_info temp = user.get(a);
   if(temp.ID.compareTo(id)==0){
    if(temp.PW.compareTo(pw)==0){
     return "1";
    }
    else
     return "3";
   }
  }
  return "2";
 }
 //중복확인//
 public static String is_dup(ArrayList<user_info> user, String id){
  for(int a=0;a<user.size();a++){
   user_info temp=user.get(a);
   if(temp.ID.compareTo(id)==0){
    return "1"; //아이디가 같아요
   }
  }
  return "0"; //달라요

 }
}