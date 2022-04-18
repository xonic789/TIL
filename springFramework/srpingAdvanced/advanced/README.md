## ThreadLocal
- 싱글턴(JVM에 오직 하나인 인스턴스) 빈에서 공유변수 (멤버변수) 를 사용하게 되면, 동시성 문제가 있다.
- 이는 읽기만 한다면 상관이 없으나, 수정시 문제가 된다.
- 왜냐하면 여러 쓰레드가 동시에 접근하여 수정하게 되면, 다른 쓰레드가 덮어쓰거나 할 수 있다
- 이 문제를 해결하려면, ThreadLocal을 사용하면 된다.
- ThreadLocal은 java에서 제공해주는 `java.lang.ThreadLocal`이다.
- 각 쓰레드마다 저장 공간을 달리해서 할당하기 때문에 동시성 문제에서 안전하다.
- 하지만 여기도 문제가 있는데, 쓰레드가 종료될 때 ThreadLocal에 담긴 변수를 지워줘야 한다.
- 이유가 뭘까?

### ThreadLocal - 주의사항
- ThreadLocal을 사용 후 지우지 않으면 WAS 같은 ThreadPool을 사용할 때 문제가 생긴다.
- ThreadPool은 처음 WAS 가 실행될 때 Thread를 미리 생성해놓는데, 요청시마다 ThreadPool에 Thread를 꺼내서 요청에 사용하게 한다.
- 그리고 요청이 종료되면, ThreadPool에 해당 요청에 사용된 Thread를 반납한다.
- 그래서 ThreadLocal에 저장되어 삭제되지 않은 값들이 재사용된 Thread에서 사용될 수 있다.
- **꼭 제거해야한다!!!!!!!!!!**