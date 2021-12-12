import java.io.*;
import java.net.*;

public class Client {
 
 public static void main(String[] args) {
  ClientChatter chatter = new ClientChatter();

  chatter.login();  // 대화명 입력
  //chatter.ready();  // 대화 시작을 기다린다.
  chatter.start();  
  chatter.chatProcess();
 }

}

