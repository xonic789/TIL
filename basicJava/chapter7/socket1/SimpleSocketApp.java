package basicjava.chapter7.socket1;

public class SimpleSocketApp {

  public static void main(String[] args) {
    new Thread(ServerFile::new).start();
    new Thread(ClientFile::new).start();
  }
}
