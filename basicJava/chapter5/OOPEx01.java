package basicJava.chapter5;

class Player {
  String name;
  private int thirsty;

  void 물마시기() {
    System.out.println("물마시기 행위");
    this.thirsty = this.thirsty - 50;
  }

  int 목마름상태확인() {
    return this.thirsty;
  }

  public Player(String name, int thirsty) {
    this.name = name;
    this.thirsty = thirsty;
  }
}

public class OOPEx01 {

  public static void main(String[] args) {
    Player p1 = new Player("홍길동", 100);
    System.out.println("이름은 : " + p1.name);
    System.out.println("갈증지수 : " + p1.목마름상태확인());

    // 1. 첫번째 시나리오 = 마법 (X)
//    p1.thirsty = 50; //마법 -> 원인없이 갈증지수 변경
//    System.out.println("갈증지수 : " + p1.thirsty);

    // 2. 두번째 시나리오 = 상태가 행위를 변경함 (X) - 실수할 수 있음
//    p1.물마시기();
//    System.out.println("갈증지수 : " + p1.thirsty);

    // 세번째 시나리오
    p1.물마시기();
    System.out.println("갈증지수 : " + p1.목마름상태확인());
  }

}
