import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

class ClientChatter extends Thread{
 Socket socket;
 String id;

 BufferedReader stdin; // ǥ���Է°�ü(Ű����)

 BufferedReader br;  // ���� �Է� ��ü
 PrintWriter pw;   // ���� ��� ��ü

 public ClientChatter(){
  try{
   socket = new Socket("localhost", 9003);

   br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
   pw = new PrintWriter(socket.getOutputStream());
  }catch(Exception e){
   System.out.println(e.getMessage());
   System.out.println("Socket ���� �� i/o stream��⿡�� ���ܹ߻�..");
   //���ܹ߻��� �ٽ� �����ϴ��� �����ϴ��� ó��
  }
 }

 public void ready(){
  // �Է� ��ɸ� �����ϸ� �ȴ�.
  try{
   String  msg = br.readLine();
   System.out.println(msg);
  }catch(Exception e){
   System.out.println(e.getMessage());
   System.out.println("ready() ���� ���� �߻�....");
  }
 }

 public void login(){
  try{
   //�α��� ó��
   stdin = new BufferedReader(new InputStreamReader(System.in));
   String result;
   do{
    System.out.print("id�� �Է��Ͻÿ� ==> ");
    id = stdin.readLine();
    pw.println(id);
    pw.flush();

    result = br.readLine();
   }while(!result.equals("ok"));

  }catch(Exception e){
   System.out.println(e.getMessage());
   System.out.println("login()�� ���� �߻�....");
  }
 }

 public void chatProcess(){
  try{
   // ä�� ó��
   String msg="";
   while(!msg.equals("bye")){
    System.out.println("�޼����� �Է��Ͻÿ�==>");
    msg = stdin.readLine();
    pw.println(msg);
    pw.flush();
   }

  }catch(Exception e){
   System.out.println(e.getMessage());
   System.out.println("�޼����� �Է¹޾� ������ ���� �߻�....");
  }finally{
   close();
   System.out.println("chatProcess() ����....");
  }
 }

 public void run(){
  // �Է� ��ɸ� �����ϸ� �ȴ�.
  try{
   String msg="";
   while(!msg.equals("bye")){
    msg = br.readLine();
    System.out.println(msg);
   }
  }catch(Exception e){
   System.out.println(e.getMessage());
   System.out.println("�����忡�� ���� �߻�....");
  }finally{
   close();
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