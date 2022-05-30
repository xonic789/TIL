## Spring AOP
### 프로젝트 적용
build.gradle
```groovy 
implementation 'org.springframework.boot:spring-boot-starter-aop'
```

>참고<br>
> `@Aspect`를 사용하려면 `@EnableAspectJAutoProxy`를 스프링 설정에 추가해야 하지만, 스프링 부트를 사용하면 자동으로 추가된다.



### 스프링 AOP 구현 1 - 시작
스프링 AOP를 구현하는 일반적인 방법은 앞서 학습한 `@Aspect`를 사용하는 방법이다.
- `@Around` 애노테이션의 값인 `execution(* ...*(..))`는 포인트 컷이 된다.
- `@Around` 애노테이션의 메서드는 어드바이스(`Advice`)가 된다.
- `execution(...)`는 AspectJ 포인트컷 표현식이다.
- 스프링은 프록시 방식의 AOP를 사용하므로 프록시를 통하는 메서드만 적용 대상이 된다.

>참고<br>
> 스프링 AOP는 AspectJ의 문법을 차용하고, 프록시 방식의 AOP를 제공한다. AspectJ를 직접 사용하는
것이 아니다.<br>
> 스프링 AOP를 사용할 때는 @Aspect 애노테이션을 주로 사용하는데, 이 애노테이션도 AspectJ가
제공하는 애노테이션이다.

>참고<br>
> `@Aspect` 를 포함한 `org.aspectj` 패키지 관련 기능은 `aspectjweaver.jar` 라이브러리가 제공하는
기능이다. 앞서 `build.gradle` 에 `spring-boot-starter-aop` 를 포함했는데, 이렇게 하면 스프링의
AOP 관련 기능과 함께 `aspectjweaver.jar` 도 함께 사용할 수 있게 의존 관계에 포함된다.<br>
> 그런데 스프링에서는 AspectJ가 제공하는 애노테이션이나 관련 인터페이스만 사용하는 것이고, 실제
AspectJ가 제공하는 컴파일, 로드타임 위버 등을 사용하는 것은 아니다. 스프링은 프록시 방식의 AOP를 사용한다.


### 스프링 AOP 구현2 - 포인트컷 분리
`@Around`에 포인트컷 표현식을 직접 넣을 수도 있지만, `@Pointcut` 애노테이션을 사용해서 별도로 분리할 수도 있다.

#### @Pointcut
- @Pointcut 에 포인트컷 표현식을 사용한다.
- 메서드 이름과 파라미터를 합쳐서 포인트컷 시그니처(signature)라 한다.
- 메서드의 반환 타입은 `void` 여야 한다. 
- 코드 내용은 비워둔다.
- 포인트컷 시그니처는 **메서드명** 이다. 이름 그대로 주문과 관련된 모든 기능을 대상으로 하는
포인트컷이다.
- `@Around` 어드바이스에서는 포인트컷을 직접 지정해도 되지만, 포인트컷 시그니처를 사용해도 된다.
- `private` , `public` 같은 접근 제어자는 내부에서만 사용하면 `private` 을 사용해도 되지만, 다른
애스팩트에서 참고하려면 `public` 을 사용해야 한다.

### 스프링 AOP 구현3 - 어드바이스 추가
`@Around("pointcutSignature1() && pointcutSignature2()`
- 포인트컷은 이렇게 조합 가능하다. `&&`(AND), `||`(OR), `!`(NOT) 3가지 조합이 가능하다.

### 스프링 AOP 구현4 - 포인트컷 참조
포인트컷을 외부 클래스에 모아두어도 된다. 참고로 외부에서 호출할 때는 포인트컷의 접근 제어자를 `public`으로 열어두어야 한다.
```java
package hello.aop.order.aop;
import org.aspectj.lang.annotation.Pointcut;
public class Pointcuts {
    //hello.springaop.app 패키지와 하위 패키지
    @Pointcut("execution(* hello.aop.order..*(..))")
    public void allOrder(){}
    //타입 패턴이 *Service
    @Pointcut("execution(* *..*Service.*(..))")
    public void allService(){}
    //allOrder && allService
    @Pointcut("allOrder() && allService()")
    public void orderAndService(){}
}
```
> 다만 풀패키지명.시그니쳐로 적어줘야한다.


### 스프링 AOP 구현5 - 어드바이스 순서
어드바이스는 기본적으로 순서를 보장하지 않는다. 순서를 지정하고 싶으면 `@Aspect` 적용 단위로 `org.springframework.core.annotation.@Order` 애노테이션을 적용해야한다.<br>
문제는 이 것을 어드바이스 단위가 아니라 **클래스 단위로 적용**할 수 있다는 점이다.
```java
public class GeneralAspect {
    
    @Aspect
    @Order(1)
    public static class Aspect1 {
        @Around("pointcutSignature()")
        public Object xxx(ProceedingJoinPoint joinPoint) throws Throwable {
            // ... 로직
            joinPoint.proceed();
            // ... 로직
        } 
    }

    @Aspect
    @Order(2)
    public static class Aspect2 {
        @Around("pointcutSignature()")
        public Object xxx(ProceedingJoinPoint joinPoint) throws Throwable {
            // ... 로직
            joinPoint.proceed();
            // ... 로직
        }
    }
}
```
> 숫자가 적을 수록 먼저 실행된다.

### 스프링 AOP 구현6 - 어드바이스 종류
어드바이스는 `@Around`외에도 여러가지 종류가 있다.

#### 어드바이스 종류
- `@Around` : 메서드 호출 전후에 수행, 가장 강력한 어드바이스, 조인 포인트 실행 여부 선택, 반환 값 변환, 
 예외 변환 등이 가능
- `@Before` : 조인 포인트 실행 이전에 실행
- `@AfterReturning` : 조인 포인트가 정상 완료후 실행
- `@AfterThrowing` : 메서드가 예외를 던지는 경우 실행
- `@After` : 조인 포인트가 정상 또는 예외에 관계없이 실행(finally)

#### 좋은 설계는 제약이 있는 것이다
좋은 설계는 제약이 있는 것이다. `@Around` 만 있으면 되는데 왜? 이렇게 제약을 두는가? 제약은 실수를<br>
미연에 방지한다. 일종에 가이드 역할을 한다. 만약 `@Around` 를 사용했는데, 중간에 다른 개발자가 해당<br>
코드를 수정해서 호출하지 않았다면? 큰 장애가 발생했을 것이다. 처음부터 `@Before` 를 사용했다면 이런<br>
문제 자체가 발생하지 않는다.<br>
제약 덕분에 역할이 명확해진다. 다른 개발자도 이 코드를 보고 고민해야 하는 범위가 줄어들고 코드의<br>
의도도 파악하기 쉽다.<br>

## 포인트컷 지시자 

AspectJ는 포인트컷을 편리하게 표현하기 위한 특별한 표현식을 제공한다.
예) `@Pointcut("execution(* hello.aop.order..*(..))")`
포인트컷 표현식은 AsepctJ pointcut expression. 즉 AspectJ가 제공하는 포인트컷 표현식을 줄여서 말하는 것이다.

#### 포인트컷 지시자
포인트컷 표현식은 `execution`같은 포인트컷 지시자(Pointcut Designator)로 시작한다. 줄여서 PCD라 한다.
#### 포인트컷 지시자의 종류
- `execution` : 메소드 실행 조인 포인트를 매칭한다. 스프링 AOP에서 가장 많이 사용하고, 기능도
복잡하다.
- `within` : 특정 타입 내의 조인 포인트를 매칭한다.
- `args` : 인자가 주어진 타입의 인스턴스인 조인 포인트
- `this` : 스프링 빈 객체(스프링 AOP 프록시)를 대상으로 하는 조인 포인트
- `target` : Target 객체(스프링 AOP 프록시가 가르키는 실제 대상)를 대상으로 하는 조인 포인트
- `@target` : 실행 객체의 클래스에 주어진 타입의 애노테이션이 있는 조인 포인트
- `@within` : 주어진 애노테이션이 있는 타입 내 조인 포인트
- `@annotation` : 메서드가 주어진 애노테이션을 가지고 있는 조인 포인트를 매칭
- `@args` : 전달된 실제 인수의 런타임 타입이 주어진 타입의 애노테이션을 갖는 조인 포인트
- `bean` : 스프링 전용 포인트컷 지시자, 빈의 이름으로 포인트컷을 지정한다.

`execution`을 가장 많이 사용한다.

### execution 1
execution 문법
```text
execution(modifiers-pattern? ref-type-pattern declaring-type-pattern?name-
pattern(param-pattern)
          throws-pattern?)

execution(접근제어자? 반환타입 선언타입?메서드이름(파라미터) 예외?)
```
- 메서드 실행 조인 포인트를 매칭한다.
- ?는 생략할 수 있다.
- `*`같은 패턴을 지정할 수 있다.

#### 가장 상세한 포인트컷
`"execution(public String com.example.MemberServiceImpl.hello(String))`<br>

**매칭 조건**
- 접근제어자? :`public`
- 반환타입 : `String`
- 선언타입? : `com.example.MemberServiceImpl`
- 메서드이름 : `hello`
- 파라미터 : `(String)`
- 예외? : 생략
#### 가장 많이 생략한 포인트컷
`("execution(* *(..))"`<br>

**매칭 조건**
- 접근제어자? : 생략
- 반환타입 : `*`
- 선언타입? : 생략
- 메서드이름 : `*`
- 파라미터 : `(..)`
- 예외? : 없음
<br>


- `*`은 와일드카드 역할을 한다.
- 파라미터에서, `..`은 파라미터의 타입와 파라미터 수가 상관없다는 뜻이다.
- `*`는 메서드 이름에서 앞뒤로 사용 가능하다.

#### 패키지 관련 포인트컷
`com.example.*(1).*(2)`
- (1) : 타입
- (2) : 메서드 이름

패키지에서 `.`,`..`의 차이를 이해해야 한다.
- `.`: 정확하게 해당 위치의 패키지
- `..`: 해당 위치의 패키지와 그 하위 패키지도 포함.

### execution2
#### 타입 매칭 - 부모 타입 허용
1. 부모 타입으로 execution 하게 되면 상속 받은 자식 타입까지 적용된다.
`execution(* com.example.MemberService.*(..))`
2. 하지만 부모 타입에는 정의되지 않은, 자식 타입에만 정의된 메소드는 적용되지 않는다.

#### 파라미터 매칭
#### execution 파라미터 매칭 규칙은 다음과 같다.
- `(String)` : 정확하게 String 타입 파라미터
- `()` : 파라미터가 없어야 한다.
- `(*)` : 정확히 하나의 파라미터, 단 모든 타입을 허용한다.
- `(*, *)` : 정확히 두 개의 파라미터, 단 모든 타입을 허용한다.
- `(..)` : 숫자와 무관하게 모든 파라미터, 모든 타입을 허용한다. 참고로 파라미터가 없어도 된다. 0..* 로 
  이해하면 된다.
- `(String, ..)` : String 타입으로 시작해야 한다. 숫자와 무관하게 모든 파라미터, 모든 타입을 허용한다.
  - 예) `(String)` , `(String, Xxx)` , `(String, Xxx, Xxx)` 허용
                                        
### within
within 지시자는 특정 타입 내의 조인 포인트에 대한 매칭을 제한한다.<br>
즉 해당 타입이 매칭되면 그 안의 메서드(조인 포인트) 들이 자동으로 매칭된다.<br>
`execution`에서 타입 부분만 사용한다고 보면 된다.
> 주의: 정확한 타입으로만 매칭하므로 부모 타입을 지정하면 안된다.

### args
- `args`: 인자가 주어진 타입의 인스턴스인 조인 포인트로 매칭
- 기본 문법은 `execution`의 `args`부분과 같다.<br>
**execution과 args의 차이점**
  - `execution`은 파라미터 타입이 정확하게 매칭되어야 한다. `execution`은 클래스에 선언된 정보를 기반으로 판단한다.
  - `args`는 부모 타입을 허용한다. `args`는 실제 넘어온 파라미터 객체 인스턴스를 보고 판단한다.
> 예를 들어 `public void hello(String)` 이라는 메서드가 있다면,<br>
> `args(String)` => 매칭됨 `args(java.io.Serializable)` => 매칭됨<br>
> 하지만 `exeuction`은 `execution(* *(String))`만 매칭되고 Serializable은 매칭되지 않음.<br>

### @target, @within
**정의**<br>
- `@Target`: 실행 객체의 클래스에 주어진 타입의 애노테이션이 있는 조인 포인트
- `@Within`: 주어진 애노테이션이 있는 타입 내 조인 포인트

**설명**<br>
`@target` , `@within` 은 다음과 같이 타입에 있는 애노테이션으로 AOP 적용 여부를 판단한다.<br>
<br>
- `@target(com.example.annotation.ClassAop)`
- `@within(com.exapple.annotation.ClassAop)`
```java
@ClassAop
class Target {}
```

> 쉽게 얘기하면 `@target`은 부모 클래스의 메서드까지 어드바이스를 다 적용.<br>
> `@within`은 자기 자신의 클래스에 정의된 메서드에만 어드바이스를 적용.

> **주의**<br>
> `args, @args, @target` 포인트컷 지시자는 단독으로 사용하면 안된다.<br>
> 위 포인트컷 지시자는 실제 객체 인스턴스가 생성되고 실행될 때 어드바이스 적용 여부를 확인할 수 있다<br>
> 실행 시점에 일어나는 포인트컷 적용 여부도 결국 프록시가 있어야 실행 시점에 판단할 수 있다<br>
> 프록시가 없다면 판단 자체가 불가능!<br>
> 그런데 스프링 컨테이너가 프록시를 생성하는 시점은 스프링 컨테이너가 만들어지는 애플리케이션 로딩 시점에 적용할 수 있다<br>
> 따라서 위 3가지 같은 포인트컷 지시자가 있으면 스프링은 모든 스프링 빈에 AOP를 적용하려고 시도하기 때문에 프록시가 없으면 실행 시점에 판단 자체가 불가능.<br>
> 그래서 이러한 표현식은 최대한 프록시 적용 대상을 축소하는 표현식과 함께 사용해야한다.


### @annotation, @args
#### @annotation
**정의**<br>
- `@annotation`: 메서드가 주어진 애노테이션을 가지고 있는 조인 포인트를 매칭
**설명**<br>
- `@annotation(com.example.annotation.MethodAop)`

#### @args
**정의**<br>
- `@args`: 전달된 실제 인수의 런타임 타입이 주어진 타입의 애노테이션을 갖는 조인포인트
**설명**<br>
- 전달된 인수의 런타임 타입에 `@Check` 애노테이션이 있는 경우에 매칭
- `@args(test.Check)`

### bean
**정의**<br>
- `bean`: 스프링 전용 포인트컷 지시자, 빈의 이름으로 지정한다.
**설명**<br>
- 스프링 빈의 이름으로 AOP 적용 여부를 지정한다. 스프링에서만 사용할 수 있는 특별한 지시자이다.
- `bean(orderService) || bean(*Repository)`
### 매개변수 전달
**this, target, args, @target, @within, @annotation, @args**
```java
@Before("allMember() && args(arg,..)")
public void logArgs3(String arg) {
 log.info("[logArgs3] arg={}", arg);
}
```
- 포인트컷의 이름과 매개변수의 이름을 맞추어야 한다. 여기 예제는 `arg`로 맞춤.
- 추가로 타입이 메서드에 지정한 타입으로 제한됨. 여기서는 메서드 타입이 `String`으로 되어 있기 때문에 다음과 같이 정의됨
  - `args(arg,..) -> args(String, ..)`

### this, target
**정의**<br>
- `this` : 스프링 빈 객체(스프링 AOP 프록시)를 대상으로 하는 조인 포인트
- `target` : Target 객체(스프링 AOP 프록시가 가르키는 실제 대상)를 대상으로 하는 조인 포인트

#### 프록시 생성 방식에 따른 차이가 있다. 