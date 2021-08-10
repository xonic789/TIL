아직 덜 작성됨.
# basic framework

## 좋은 객체 지향 설계의 5가지 원칙 적용

**SRP 단일 책임 원칙**

- **한 클래스는 하나의 책임만 가져야 한다!!**
    1. 클라이언트 객체는 직접 구현 객체를 생성하고, 연결하고, 실행하는 다양한 책임을 가지고 있음.
    2. SRP 단일 책임 원칙을 따르면서 관심사를 분리함.
    3. 구현 객체를 생성하고 연결하는 책임은 ```Configuration```이 담당.
    4. 클라이언트 객체는 실행하는 책임만 담당.

**DIP 의존관계 역전 원칙**

- **프로그래머는 "추상화에 의존해야지, 구체화에 의존하면 안된다."**
- **의존성 주입은 이 원칙을 따르는 방법중 하나다.**
    1. 하나의 클래스에서 추상화와 구체화 둘다 의존하게 되면 안된다! 개발자는 추상화에 의존해야 한다.

**OCP**

- **소프트웨어 요소는 확장에는 열려 있으나 변경에는 닫혀 있어야 한다.**
    1. 다형성 사용하고 클라이언트가 DIP를 지킴.
    2. 애플리케이션을 사용 영역과 구성 영역으로 나눔.
    3. ```Configuration```이 클라이언트 코드에 주입 하므로 클라이언트 코드는 변경하지 않아도 됨.
    4. 소프트웨어 요소를 새롭게 확장해도 사용 영역의 변경은 닫혀 있다.
    5. 