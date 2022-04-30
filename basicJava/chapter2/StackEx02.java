package basicjava.chapter2;

/**
 * 정리 :
 */

public class StackEx02 {

  static int sum = 20; // 전역 변수 (static) main 메서드가 시작 되기 전에 sum이 static에 할당.
  int value = 50; // 전역 변수 (heap) // 더 이상 참조하지 않을 때 자동으로 사라진다.

  static void a() {
    // a 메서드가 실행 될 때 stack 공간에 n1이 할당되고 a 메서드가 종료되면 메모리에서 사라진다.
    int n1 = 1; // -> a 메서드의 stack 영역에 저장. 스택 내부에서만 접근 가능.
    System.out.println(n1);
  }

  public static void main(String[] args) {
    a();
    System.out.println(sum);
    StackEx02 s = new StackEx02();
    System.out.println(s.value);
    System.out.println();
  }
}
