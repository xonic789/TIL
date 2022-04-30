package basicjava.chapter7.socket1;

import java.io.*;
import java.net.Socket;

public class ClientFile {

  Socket socket;
  BufferedWriter bw;
  BufferedReader br;

  public ClientFile() {
    try {
      System.out.println("1. 클라이언트 소켓 시작 -------------");
      socket = new Socket("localhost", 10000);

      System.out.println("2. 버퍼(write) 연결 완료 -----------");
      bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

      System.out.println("3. 키보드 스트림 + 버퍼(read) 연결 완료 -----------");
      br = new BufferedReader(new InputStreamReader(System.in));

      String keyboardMsg = br.readLine();
      System.out.println("2. 메시지 입력 : ");
      bw.write(keyboardMsg + "\n");
      bw.flush();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    new ClientFile();
  }
}
