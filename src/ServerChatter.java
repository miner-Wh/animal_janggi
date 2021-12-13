import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

// ������ �̿��Ͽ� Ŭ���̾�Ʈ 1���� ���� ����Ǿ� �ִ�.
// ArrayList<> �� chatters �� �ҼӵǾ��ִ� �Ǵٸ� ���ϰ� ����Ÿ�� �ְ�޴� ������ Ŭ����
class ServerChatter extends Thread{
 // Ŭ���̾�Ʈ�� ���� ����Ǿ� �ִ� ����
 Socket socket;
 BufferedReader br; // �������κ����� ���� �Է� ��Ʈ��
 PrintWriter pw;  // �������κ����� ���� ��� ��Ʈ��

 // ���� ������ ���ӵ� ��ü Ŭ���̾�Ʈ ������ ����Ǿ� �ִ�.
 ArrayList<ServerChatter> chatters;

 String id; // ���̵�(��Ī)--> ��ȭ�޼����� ������ id(��ȭ��) ==> �α���ó���� ���� ����
 boolean isLogin;
 ChatRoom room;

 public ServerChatter(Socket socket, ChatRoom room){
  this.socket = socket;
  this.room = room;

  // �������κ��� ���� ����� ��Ʈ�� ���
  try{
   br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
   pw = new PrintWriter(socket.getOutputStream());
  }catch(IOException e){
   System.out.println(e.getMessage());
  }
 }

 // ��ȭ���� �Է¹޴� ó�� --> Ȯ��Ǿ����� ����Ÿ���̽��� id/pass �� �˻��Ͽ�
 //         �α��� ������� Ȯ���� �� �ִ�.
 public void login(){

  String members[] = {"�ο���","ȫ����","������","������"}; //���� ������ ���̵� 4���� �����Ѵٰ� �����Ѵ�.
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
     System.out.println("���� - �α��� �̸� Ȯ��");
     break;
    }
    else {
     sendMessage("error");
     System.out.println("���� - �α��� �̸� XXX");
    }
   }
  }catch(IOException e){
   System.out.println(e.getMessage());
   System.out.println("login()ó������ ���� �߻�.....");
  }
 }


 public void run(){
  login();  //�α��� ó��
  if(!isLogin){return;} //chatters ���� �ڽ��� �����ϰ� ������ �ݴ´�.
  try{
   String message = "";
   while(!message.equals("bye")){
    System.out.println(id +" Ŭ���̾�Ʈ�� �޼����� ��ٸ��ϴ�.");
    message = br.readLine();
    System.out.println("���� �޼��� ==>" + id + ":" + message);

    if(message.equals("bye")){
     room.broadCasting(id+"���� �����ϼ̽��ϴ�.");}
    room.broadCasting(id+" : "+message);
   }
  }catch(IOException e){
   System.out.println(e.getMessage());
   System.out.println("�޼����� �����Ͽ� �۽��� ���� �߻�....");
  }finally{
   room.exitRoom(this);
   close();
   System.out.println("������ �ݰ� ������ ����....");
  }
 }
 //�޼����� ������ �޼ҵ�
 void sendMessage(String message){
  try{
   pw.println(message);
   pw.flush();
  }catch(Exception e){
   System.out.println(e.getMessage());
   System.out.println("sendMessage()���� ���� �߻�....");
  }
 }

 public void close(){
  try{
   br.close();
   pw.close();
   socket.close();
  }catch(Exception e){
   System.out.println("close()..���� ���� �߻�!");
  }
 }
}