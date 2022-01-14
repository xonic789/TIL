package basicJava.chapter7;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class StreamEx02 {

  public static void main(String[] args) {
    InputStream in = System.in;
    InputStreamReader ir = new InputStreamReader(in);


    try {
      char[] data = new char[3];
      ir.read(data);
      System.out.println(data);
    } catch (IOException e) {
      e.printStackTrace();
    }

  }
}
