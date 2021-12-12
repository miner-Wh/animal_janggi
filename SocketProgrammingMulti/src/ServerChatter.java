import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
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
  
  String members[] = {"강아지","송아지","고양이"}; //접속 가능한 아이디가 3개만 존재한다고 가정한다.
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
  login();  //로그인 처리
  if(!isLogin){return;} //chatters 에서 자신을 제거하고 소켓을 닫는다.
  try{
   String message = "";
            while(!message.equals("bye")){
             System.out.println(id +" 클라이언트가 메세지를 기다립니다.");
             message = br.readLine();
             System.out.println("받은 메세지 ==>" + id + ":" + message);
    
             if(message.equals("bye")){
              room.broadCasting(id+"님이 퇴장하셨습니다.");}
             room.broadCasting(id+" : "+message);
             }
  }catch(IOException e){
   System.out.println(e.getMessage());
   System.out.println("메세지를 수신하여 송신중 예외 발생....");
  }finally{
   room.exitRoom(this);
   close();
   System.out.println("연결을 닫고 쓰레드 종료....");
  }    
 }
 //메세지를 보내는 메소드
 void sendMessage(String message){
  try{
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
}