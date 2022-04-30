package basicjava.chapter7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class StreamEx03 {

  public static void main(String[] args) {
    InputStream in = System.in;
    InputStreamReader ir = new InputStreamReader(in);
    BufferedReader br = new BufferedReader(ir);

    try {
      br.readLine();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
