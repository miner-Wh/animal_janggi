import java.io.*;
import java.net.*;

public class Client {

 public static void main(String[] args) {
  ClientChatter chatter = new ClientChatter();

  chatter.login();  // ��ȭ�� �Է�
  //chatter.ready();  // ��ȭ ������ ��ٸ���.
  chatter.start();
  chatter.chatProcess();
 }

}

