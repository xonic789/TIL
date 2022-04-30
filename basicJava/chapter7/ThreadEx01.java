package basicJava.chapter7;

class SubThread implements Runnable{

  // 자바의 서브 스레드
  @Override
  public void run() {
    for (int i = 1; i < 10; i++) {
      try {
        Thread.sleep(1000);
        System.out.println("서브 스레드 : " + i);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}

public class ThreadEx01 {

  // 자바의 메인 스레드
  public static void main(String[] args) {

    SubThread subThread = new SubThread();
    Thread t1 = new Thread(subThread);
    t1.start();

    for (int i = 1; i < 10; i++) {
      try {
        Thread.sleep(1000);
        System.out.println("메인 스레드 : " + i);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
