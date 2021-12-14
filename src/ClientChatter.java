import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

class ClientChatter extends Thread{
 Socket socket;
 String id;

 BufferedReader stdin; // 표준입력객체(키보드)

 BufferedReader br;  // 소켓 입력 객체
 PrintWriter pw;   // 소켓 출력 객체

 public ClientChatter(){
  try{
   socket = new Socket("localhost", 9003);

   br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
   pw = new PrintWriter(socket.getOutputStream());
  }catch(Exception e){
   System.out.println(e.getMessage());
   System.out.println("Socket 생성 및 i/o stream얻기에서 예외발생..");
   //예외발생시 다시 실행하던지 종료하던지 처리
  }
 }

 public void ready(){
  // 입력 기능만 수행하면 된다.
  try{
   String  msg = br.readLine();
   System.out.println(msg);
  }catch(Exception e){
   System.out.println(e.getMessage());
   System.out.println("ready() 에서 예외 발생....");
  }
 }

 public void login(){
  try{
   //로그인 처리
   stdin = new BufferedReader(new InputStreamReader(System.in));
   String result;
   do{
    System.out.print("id를 입력하시오 ==> ");
    id = stdin.readLine();
    pw.println(id);
    pw.flush();

    result = br.readLine();
   }while(!result.equals("ok"));

  }catch(Exception e){
   System.out.println(e.getMessage());
   System.out.println("login()중 예외 발생....");
  }
 }

 public void chatProcess(){
  try{
   // 채팅 처리
   String msg="";
   while(!msg.equals("bye")){
    System.out.println("메세지를 입력하시오==>");
    msg = stdin.readLine();
    pw.println(msg);
    pw.flush();
   }

  }catch(Exception e){
   System.out.println(e.getMessage());
   System.out.println("메세지를 입력받아 전송중 예외 발생....");
  }finally{
   close();
   System.out.println("chatProcess() 종료....");
  }
 }


 public void run(){
  // 입력 기능만 수행하면 된다.
  try{
   String msg="";
   while(!msg.equals("bye")){
    msg = br.readLine();
    System.out.println(msg);
   }
  }catch(Exception e){
   System.out.println(e.getMessage());
   System.out.println("쓰레드에서 예외 발생....");
  }finally{
   close();
  }
 }


 public int sendMSG(String message) throws IOException {
  try {
   pw.println(message);
   pw.flush();
   System.out.println("before read");
   String serverMSG = br.readLine();
   System.out.println("serverMSG: "+serverMSG);
   return Integer.parseInt(serverMSG);
  } catch (Exception e) {
   System.out.println(e.getMessage());
   System.out.println("sendMSG()에서 예외 발생....");
   return -1;
  }
 }
 public String sendMSG_s(String message) throws IOException {
  try {
   pw.println(message);
   pw.flush();
   System.out.println("before read");
   String serverMSG = br.readLine();
   System.out.println("serverMSG: "+serverMSG);
   return serverMSG;
  } catch (Exception e) {
   System.out.println(e.getMessage());
   System.out.println("sendMSG()에서 예외 발생....");
   return null;
  }
 }


 public void close(){
  try{
   br.close();
   pw.close();
   socket.close();
  }catch(Exception e){
  }
 }
}