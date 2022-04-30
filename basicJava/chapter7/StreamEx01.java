package basicJava.chapter7;

import java.io.InputStream;

public class StreamEx01 {

  public static void main(String[] args) {
    InputStream in = System.in; // -> 컴퓨터와 키보드를 연결시킨다.

    try {
      int data = in.read();
      System.out.println(data);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
