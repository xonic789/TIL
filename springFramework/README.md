아직 덜 작성됨.
# basic framework

## 좋은 객체 지향 설계의 5가지 원칙 적용


**SRP 단일 책임 원칙**

- **한 클래스는 하나의 책임만 가져야 한다!!**
  1. 클라이언트 객체는 직접 구현 객체를 생성하고, 연결하고, 실행하는 다양한 책임을 가지고 있음.
  2. SRP 단일 책임 원칙을 따르면서 관심사를 분리함.
  3. 구현 객체를 생성하고 연결하는 책임은 `Configuration`이 담당.
  4. 클라이언트 객체는 실행하는 책임만 담당.

**DIP 의존관계 역전 원칙**

- **프로그래머는 "추상화에 의존해야지, 구체화에 의존하면 안된다."**
- **의존성 주입은 이 원칙을 따르는 방법중 하나다.**
  1. 하나의 클래스에서 추상화와 구체화 둘다 의존하게 되면 안된다! 개발자는 추상화에 의존해야 한다.

**OCP**

- **소프트웨어 요소는 확장에는 열려 있으나 변경에는 닫혀 있어야 한다.**
  1. 다형성 사용하고 클라이언트가 DIP를 지킴.
  2. 애플리케이션을 사용 영역과 구성 영역으로 나눔.
  3. `Configuration`이 클라이언트 코드에 주입 하므로 클라이언트 코드는 변경하지 않아도 됨.
  4. 소프트웨어 요소를 새롭게 확장해도 사용 영역의 변경은 닫혀 있다.

### **IoC , DI, 그리고 컨테이너**

**제어의 역전 IoC(Inversion of Control)**

- 기존 프로그램은 클라이언트 구현 객체가 스스로 필요한 서버 구현 객체를 생성하고 , 연결하고 , 실행했다. 한마디로 구현 객체가 프로그램의 제어 흐름을 스스로 조종했다.
- 반면 `Configuration`이 등장한 후에 구현 객체는 자신의 로직을 실행하는 역할만 담당한다. 프로그램의 제어 흐름은 `Configuration`이 가져간다. 예를 들어 추상화에 의존하는 구현 객체인 `Impl`의 맴버필드중 `interface` 타입은 어떤 구현체가 주입될지 모른다. 그런 사실을 모른체 `Impl` 자기 자신의 로직만 수행한다.
- 이렇듯 프로그램의 제어 흐름을 직접 제어하는 것이 아니라 외부에서 관리하는 것을 **제어의 역전(IoC)라 한다.**

참고!

**프레임워크 vs 라이브러리**

- 프레임워크가 내가 작성한 코드를 제어하고, 대신 실행하면 그것은 **프레임워크**가 맞다.(JUnit)
- 반면에 내가 작성한 코드가 직접 제어의 흐름을 담당한다면 그것은 **라이브러리**이다.

**의존관계 주입 DI (Dependency Injection)**

- `Impl` 는 `interface` 에 의존한다. 실제 어떤 구현 객체가 사용될진 모른다.
- 의존관계는 **정적인 클래스 의존 관계와,** **실행 시점에 결정되는 동적인 객체(인스턴스) 의존 관계** 둘을 분리해서 생각해야 한다.

**정적인 클래스 의존관계**

클래스가 사용하는 import 코드만 보고 의존관계를 쉽게 판단할 수 있다. 정적인 의존관계는 애플리케이션을 실행하지 않아도 분석할 수 있다. 가령 어떠한 `Impl(구현체)`에서 어떠한 `interface`의 구현체를 주입 받는다 할때, 실제 어떤 객체가 `interface`에 주입될지 알 수 없다.

**동적인 객체 인스턴스 의존관계**

애플리케이션 실행 시점에 실제 생성된 객체 인스턴스의 참조가 연결된 의존 관계다.

- 애플리케이션 **실행 시점(런타임)**에 외부에서 실제 구현 객체를 생성하고 클라이언트에 전달해서 클라이언트와 서버의 실제 의존관계가 연결 되는 것을 **의존관계 주입이라 한다.**
- 객체 인스턴스를 생성하고, 그 참족값을 전달해서 연결된다.
- 의존관계 주입을 사용하면 클라이언트 코드를 변경하지 않고, 클라이언트가 호출하는 대상의 타입 인스턴스를 변경할 수 있다.
- 의존관계 주입을 사용하면 정적인 클래스 의존관계를 변경하지 않고, 동적인 객체 인스턴스 의존관계를 쉽게 변경할 수 있다.

**IoC 컨테이너, DI 컨테이너**

- AppConfig 처럼 객체를 생성하고 관리하면서 의존관계를 연결 해주는 것을 IoC 컨테이너 또는 DI 컨테이너라한다.
- 의존 관계 주입에 초점을 맞추어 최근에는 주로 DI 컨테이너라한다.
- 또는 어샘블러, 오브젝트 팩토리 등으로 불리기도 한다.

```@Configuration``` 을 ```Class```위에 달고,

```@Bean```을 ```Method```위에 단다.
```java
ApplicationContext applicationContext=new AnnotationConfigApplicationContext(AppConfig.class);

applicationContext.getBean("<Method Name>", <Return Type>.class);
```
**스프링은** **BeanDefinition을 이용하여 다양한 형태의 설정 정보 (어노테이션 기반 자바소스코드 or xml 등 ) 를 BeanDefinition으로 추상화해서 사용한다.**

### **빈 생명주기 콜백**

DB 커넥션 풀이나 네트워크 소켓처럼 애플리케이션 시작 시점에 연결을 미리 해두고, 종료시점에 연결을 모두 종료하는 작업을 진행하려면, 객체의 초기화와 종료 작업이 필요하다.

스프링 빈의 이벤트 라이프사이클

스프링 컨테이너 생성 → 스프링 빈 생성 → 의존관계 주입 → 초기화 콜백 → 사용 → 소멸전 콜백 → 스프링 종료

"초기화 콜백" : 빈이 생성되고 빈의 의존관계 주입이 완료된 후 호출

"소멸전 콜백" : 빈이 소멸되기 직전에 호출

참고! : 객체의 생성과 초기화를 분리하자.

```java
InitializingBean, DisposableBean
```

Spring에서 제공하는 의존관계 주입 후 호출해주고, 스프링 컨테이너가 소멸하기 직전 호출해주는 메서드 제공.

```java
@Configuration
static class LifeCycleConfig{

    @Bean(initMethod = "init", destroyMethod = "close")
    public NetworkClient networkClient(){
        NetworkClient networkClient = new NetworkClient();
        networkClient.setUrl("http://hello-spring.dev");
        return networkClient;
    }
}
```

Configuration에 @Bean 어노테이션에 initMethod 이름, destoryMethod 이름을 주면 알아서 호출해준다. 해당 Bean에 Method 이름으로.

최근은

`@PostConstruct,@PreDestroy`

을 가장 권장!!

### Spring Container의 Scope

Singleton,ProtoType

- Singleton Bean은 컨테이너 생성 시점에 초기화 메서드가 실행되지만, Prototype Bean은 스프링 컨테이너에서 빈을 조회할 때 생성되고, 초기화 메서드도 실행된다.
- Singleton Bean은 스프링 컨테이너의 관리 대상이기 때문에, 스프링 컨테이너가 종료될 때 빈의 종료 메서드가 실행되지만, Prototype Bean은 스프링 컨테이너가 생성과 의존관계 주입 그리고 초기화까지만 관여하고, 더는 관여하지 않는다. **따라서 Prototype Bean은 스프링 컨테이너가 종료될 때 @PreDestory 같은 종료 메서드가 실행되지 않는다**

Singleton과 Prototype을 같이 쓸 때 **주의점!**

- Singleton Bean의 생성 시점에 Prototype의 Bean이 주입되기 때문에 (singleton 생성자 주입을 통해) 계속 유지되는 상태이다.

`ObjectProvider<T>` 를 주입받으면 프로토타입 주입 가능. (부모 객체인 `ObjectFactory<T>`

을 상속받아 만들어짐)

### Web Scope

Request,Session,Application,Websocket 등이 있다.

→스프링에서 해당 스코프에 따라 생성되고 자동 소멸되게끔 해준다.

@Component

@Scope(value = "request",proxyMode = ScopedProxyMode.TARGET_CLASS)

→ 가짜 프록시 객체를 이용하여 Bean을 주입해준다.

→ 가짜 프록시 빈은 내부에 실제 Bean의 찾는 방법을 가지고 있다.

→ 클라이언트가 빈의 메서드를 호출하게 되면 가짜 프록시 객체의 메서드를 호출한 것이다.

→ 가짜 프록시 객체는 request 스코프의 진짜 메서드를 호출한다.

→ 이 객체를 사용하는 클라이언트 입장에서는 사실 원본인지 아닌지도 모르게, 동일하게 사용할 수 있다(다형성)

**"동작 정리"**

- CGLIB라는 라이브러리로 내 클래스를 상속 받은 가짜 프록시 객체를 만들어서 주입한다.
- 이 객체는 실제 요청이 오면 그때 내부에서 실제 빈을 요청하는 위임 로직이 들어있다.
- **진짜 객체 조회를 꼭 필요한 시점까지 지연처리 한다는 점이다.**