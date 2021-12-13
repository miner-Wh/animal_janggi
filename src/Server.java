import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

 public static void main(String[] args) {

  // �������� ��ü ����
  ServerSocket serverSocket = null;
  Socket socket = null;

  //ä�÷� ��ü ����
  ChatRoom room = new ChatRoom("Web & ����Ʈ��");

  //Ŭ���̾�Ʈ ���� �ӽ� ��ü
  ServerChatter chatter = null;
  try{
   // �������� ����
   serverSocket = new ServerSocket(9003);
   while(true){
    room.display();

    System.out.println("***********Ŭ���̾�Ʈ ���� �����*************");

    socket = serverSocket.accept();

    // ä�� ��ü ����
    chatter = new ServerChatter(socket, room);

    //������ �۵����� 1)�α��� ó�� 2)ä�� ����
    chatter.start();

    // ä�� ��ü�� ArrayList�� �����Ѵ�.
    room.enterRoom(chatter);
   }
  }catch(IOException e){
   System.out.println(e.getMessage());
  }finally{
   try{
    serverSocket.close();
   }catch(IOException e){
   }
  }
 }
}