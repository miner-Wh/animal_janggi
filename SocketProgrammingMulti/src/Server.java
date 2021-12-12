import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
 
 public static void main(String[] args) {
  
  // 서버소켓 객체 선언
  ServerSocket serverSocket = null;
  Socket socket = null;

  //채팅룸 객체 생성
  ChatRoom room = new ChatRoom("Web & 스마트폰");
  
  //클라이언트 연결 임시 객체
  ServerChatter chatter = null;
  try{
   // 서버소켓 생성
   serverSocket = new ServerSocket(9003);
   while(true){
    room.display();
    
    System.out.println("***********클라이언트 접속 대기중*************");
    
    socket = serverSocket.accept();
    
    // 채팅 객체 생성
    chatter = new ServerChatter(socket, room);

    //쓰레드 작동시켜 1)로그인 처리 2)채팅 시작
    chatter.start();
  
    // 채팅 객체를 ArrayList에 저장한다.
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