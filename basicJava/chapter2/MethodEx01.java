package basicjava.chapter2;

class 손님 {

  void 커피마시기() {
    System.out.println("손님이 커피를 마심");
  }
}

public class MethodEx01 {

  static void start() {
    System.out.println("만나서 반갑습니다.");
    System.out.println("스타드 메서드 종료");
  }

  public static void main(String[] args) {
    MethodEx01.start();
    손님 s = new 손님();
    s.커피마시기();
  }
}
