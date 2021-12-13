import java.util.ArrayList;

class ChatRoom{
 ArrayList<ServerChatter> chatters = new ArrayList<ServerChatter>();

 String name;
 public ChatRoom(String name){
  this.name = name;

 }
 public void display(){
  System.out.println("현재 접속자 정보 : 접속자 수 -> " + chatters.size());
  //현재 접속된 정보 확인 - 접속자수, 접속자 아이디 명단
  for(int i=0;i<chatters.size();i++){
   System.out.println(chatters.get(i).id);
  }
 }
 public void enterRoom(ServerChatter chatter){
  chatters.add(chatter);
 }
 //접속자들 모두에게 메세지 전달
 public void broadCasting(String message){
  ServerChatter chatter = null;

  for(int i=0;i<chatters.size();i++){
   chatter = chatters.get(i);
   chatter.sendMessage(message);
  }
 }
 //채팅에서 나갈때 처리
 public void exitRoom(ServerChatter chatter){
  boolean isDelete = chatters.remove(chatter);
  if( isDelete){
   System.out.println(chatter.id + " 클라이언트를 chatters에서 제거함");
  }
  else{
   System.out.println(chatter.id + " 클라이언트를 chatters에서 제거실패");
  }
 }
}