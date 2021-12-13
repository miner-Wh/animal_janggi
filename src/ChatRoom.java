import java.util.ArrayList;

class ChatRoom{
 ArrayList<ServerChatter> chatters = new ArrayList<ServerChatter>();

 String name;
 public ChatRoom(String name){
  this.name = name;

 }
 public void display(){
  System.out.println("���� ������ ���� : ������ �� -> " + chatters.size());
  //���� ���ӵ� ���� Ȯ�� - �����ڼ�, ������ ���̵� ���
  for(int i=0;i<chatters.size();i++){
   System.out.println(chatters.get(i).id);
  }
 }
 public void enterRoom(ServerChatter chatter){
  chatters.add(chatter);
 }
 //�����ڵ� ��ο��� �޼��� ����
 public void broadCasting(String message){
  ServerChatter chatter = null;

  for(int i=0;i<chatters.size();i++){
   chatter = chatters.get(i);
   chatter.sendMessage(message);
  }
 }
 //ä�ÿ��� ������ ó��
 public void exitRoom(ServerChatter chatter){
  boolean isDelete = chatters.remove(chatter);
  if( isDelete){
   System.out.println(chatter.id + " Ŭ���̾�Ʈ�� chatters���� ������");
  }
  else{
   System.out.println(chatter.id + " Ŭ���̾�Ʈ�� chatters���� ���Ž���");
  }
 }
}