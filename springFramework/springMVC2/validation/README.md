### 검증
- 컨트롤러의 중요한 역할중 하나는 HTTP 요청이 정상인지 검증하는 것이다.
- 클라이언트 검증은 조작 가능하므로 보안에 취약함.
- 서버만으로 검증하면, 즉각적인 고객 사용성이 부족해짐.
- 둘을 적절히 섞어서 사용하되, 최종적으로 서버 검증은 필수이다!

### 검증 방법 V1
- POST method로 요청한 add 컨트롤러에서, 직접적으로 모든 필드를 하드 코딩 후 Map에 담는다.
- 뷰에서는, model로 전달받은 error Map을 ? 문법, (Safe Navigation Operator)를 이용하여
  - 에러가 존재한다면 랜더링하고, 아니면 랜더링하지 않게 하드 코딩한다.

#### 문제점
- 뷰 템플릿에서 중복 처리가 많다.
- 타입 오류 처리가 안된다. -> 컨트롤러 자체에 진입이 안된다.
- 타입 오류가 나더라도, 뷰에 랜더링 해줘야한다!

### BindingResult1
- 반드시 ModelAttribute 바로 다음에 BindingResult가 와야한다. 파라미터 순서 중요!
#### 타임리프 스프링 검증 통합 기능
- 타임 리프는 스프링의 BindingResult를 활용해서 검증 오류를 표현하는 기능을 제공.
- `#fields`: `#fields`로 `BindingResult`가 제공하는 검증 오류에 접근할 수 있다.
- `th:errors`: 해당 필드에 오류가 있는 경우에 태그를 출력한다. `th:if`의 편의 버전
- `th:errorclass`: `th:field`에서 지정한 필드에 오류가 있으면 `class` 정보를 추가한다.

### BindingResult2
- 스프링이 제공하는 검증 오류를 보관하는 객체이다. 검증 오류가 발생하면 여기에 보관하면 된다.
- BindingResult가 있으면 @ModelAttribute에 데이터 바인딩 시 오류가 발생해도 컨트롤러가 호출된다.
- 예) @ModelAttribute에 바인딩 시 타입 오류 발생하면?
  - BindingResult 없으면 -> 400 오류가 발생하면서 컨트롤러 호출 X, 오류 페이지로 이동
  - BindingResult 있다면 -> 오류 정보 `FieldError`를 `BindingResult`에 담아서 컨트롤러를 정상 호출한다.
- BindingResult는 Error interface를 상속받고 있는데, Error를 써도 되지만 기능이 제한적이다.

### 오류 발생시 사용자 입력 값 유지
- 사용자의 입력 데이터가 컨트롤러의 `@ModelAttribute`에 바인딩 되는 시점에 오류가 발생하면, 모댈 객체에 사용자 입력값을 유지하기 어렵다.
- 예를 들어서 가격에 숫자가 아닌 문자가 입력된다면 가격은 Integer 타입이므로 문자를 보관할 수 있는 방법이 없다.
- 그래서 오류가 발생한 경우 사용자 입력 값을 보관하는 별도의 방법이 필요하다. 그리고 이렇게 보관한 사용자 입력 값을 검증 오류 발생시 화면에 다시 출력하면 된다.- FieldError가 제공하는 생성자를 이용하여 거절된 값을 저장해두고, 뷰에서 렌더링할 때 사용 가능하다.
  - 이렇게 되면 사용자가 잘못 요청한 값을 다시 보여줄 수 있다.
#### 타임리프의 사용자 입력 값 유지
- `th:field="*{price}"`
- 타임리프의 `th:field`는 매우 똑똑하게 동작하는데, 정상 상황에는 모델 객체의 값을 사용하지만, 오류가 발생하면 `FieldError`에서 보관한 값을 사용해서 값을 출력한다.
#### 스프링의 바인딩 오류 처리
- 타입 오류로 바인딩에 실패하면 스프링은 `FieldError`를 생성하면서 사용자가 입력한 값을 넣어둔다.
- 그리고 해당 오류를 `BindingResult`에 담아서 컨트롤러를 호출한다. 따라서 타입 오류 같은 바인딩 실패시에도 사용자의 오류 메시지를 정상 출력할 수 있다.

### 오류 코드와 메시지 처리1
#### 목표
- 오류 메시지를 체계적으로 다루어 보자.

#### 파라미터 목록
- `objectName` : 오류가 발생한 객체 이름 
- `field` : 오류 필드 
- `rejectedValue` : 사용자가 입력한 값(거절된 값)
- `bindingFailure` : 타입 오류 같은 바인딩 실패인지, 검증 실패인지 구분 값 
- `codes` : 메시지 코드 
- `arguments` : 메시지에서 사용하는 인자 
- `defaultMessage` : 기본 오류 메시지


- `FieldError` , `ObjectError` 의 생성자는 `errorCode` , `arguments` 를 제공한다. 이것은 오류 발생시 오류
  코드로 메시지를 찾기 위해 사용된다.

#### error 메시지 파일 생성
- `messages.properties`를 사용해도 되지만, 오류 메시지를 구분하기 쉽게 `errors.properties`라는 별도의 파일로 관리해보자.
- 먼저 스프링 부트가 해당 메시지 파일을 인식할 수 있게 다음 설정을 추가한다. 이렇게 하면 `messages.properties`, `errors.properties `두 파일을 모두 인식한다 (생략하면 `message.properties`를 기본으로 인식한다)
#### 스프링 부트 메시지 설정 추가
`application.properties`
```properties
spring.message.basename=messages,errors
```
> 참고
> 
> errors_en.properties 파일을 생성하면 오류 메시지도 국제화 처리를 할 수 있다.

### 오류 코드와 메시지 처리 2
목표
- `FieldError`, `ObjectError`는 다루기 너무 번거롭다.
- 오류 코드도 좀 더 자동화 할 수 있지 않을까? 예) `item.itemName` 처럼?


컨트롤러에서 `BindingResult` 는 검증해야 할 객체인 `target` 바로 다음에 온다. 따라서
  `BindingResult` 는 이미 본인이 검증해야 할 객체인 `target` 을 알고 있다.
#### `rejectValue()`, `reject()`
- `BindingResult`가 제공하는 `rejectValue()`, `reject()`를 사용하면 `FieldError`, `ObjectError` 직접 생성하지 않고, 깔끔하게 검증 오류를 다룰 수 있음.

#### 축약된 오류 코드
- `FieldError()`를 직접 다룰 때는 오류 코드를 `range.item.price`와 같이 모두 입력했다.
- 그런데 `rejectValue()`를 사용하고 부터는 오류 코드를 `range`로 간단하게 입력했다. 그래도 오류 메시지를 잘 찾아서 출력한다.
- 무언가 규칙이 있는 것 처럼 보인다. 이 부분을 이해하려면 `MessageCodesResolver`를 이해해야 한다.

### 오류 코드와 메시지 처리 3
- 오류 코드를 만들 때 다음과 같이 자세히 만들 수도 있고, 

  `required.item.itemName`: 상품 이름은 필수 입니다.
- 또는 다음과 같이 단순하게 만들 수도 있다.

  `required`: 필수 값 입니다.

단순하게 만들면 범용성이 좋아서 여러곳에서 사용할 수 있지만, 메시지를 세밀하게 작성하기 어렵다. 반대로 너무 자세하게 만들면 범용성이 떨어진다.<br>
가장 좋은 방법은 범용성으로 사용하다가, 세밀하게 작성해야 하는 경우에는 세밀한 내용이 적용되도록 메시지에 단계를 두는 방법이다.

스프링은 `MessageCodesResolver`라는 것으로 이러한 기능을 지원한다.

### 오류 코드와 메시지 처리 4
#### MessageCodesResolver
- 검증 오류 코드로 메시지 코드들을 생성한다.
- `MessageCodesResolver` 인터페이스이고, `DefaultMessageCodesResolver`는 구현체이다.
- 주로 다음과 함께 사용 `ObjectError`, `FieldError`
#### DefaultMessageCodesResolver의 기본 메시지 생성 규칙
**객체 오류**

```text
객체 오류의 경우 다음 순서로 2가지 생성
1.: code + "." + object name
2.: code

예) 오류 코드: required, object name: item
1.: required.item
2.: required
```
**필드 오류**
```text
필드 오류의 경우 다음 순서로 4가지 메시지 코드 생성
1.: code + "." + object name + "." + field
2.: code + "." + field
3.: code + "." + field type
4.: code

예) 오류 코드: typeMismatch, object name "user", field "age", field type: int
1. "typeMismatch.user.age"
2. "typeMismatch.age"
3. "typeMismatch.int"
4. "typeMismatch"
```

#### 동작 방식
- `rejectValue()` , `reject()` 는 내부에서 `MessageCodesResolver` 를 사용한다. 여기에서 메시지 코드들을 생성한다.
- `FieldError` , `ObjectError` 의 생성자를 보면, 오류 코드를 하나가 아니라 여러 오류 코드를 가질 수 있다.
`MessageCodesResolver` 를 통해서 생성된 순서대로 오류 코드를 보관한다.

#### 오류 메시지 출력
타임리프 화면을 렌더링 할 때 th:errors 가 실행된다. 만약 이때 오류가 있다면 생성된 오류 메시지
코드를 순서대로 돌아가면서 메시지를 찾는다. 그리고 없으면 디폴트 메시지를 출력한다.

### 오류 코드와 메시지 처리 5

#### 오류 코드 관리 전략
**핵심은 구체적인 것에서 덜 구체적인 것으로**<br>
`MessageCodesResolver`는 `required.item.itemName` 처럼 구체적인 것을 먼저 만들어주고,<br>
`required`처럼 덜 구체적인 것을 가장 나중에 만든다.<br>
이렇게 하면 앞서 말한 것 처럼 메시지와 관련된 공통 전략을 편리하게 도입할 수 있다.

**왜 이렇게 복잡하게 사용하는가?**<br>
모든 오류 코드에 대해서 메시지를 각각 다 정의하면 개발자 입장에서 관리하기 너무 힘들다.<br>
크게 중요하지 않은 메시지는 범용성 있는 `requried` 같은 메시지로 끝내고, 정말 중요한 메시지는 꼭
필요할 때 구체적으로 적어서 사용하는 방식이 더 효과적이다.

#### 정리
1. rejectValue() 호출
2. MessageCodesResolver 를 사용해서 검증 오류 코드로 메시지 코드들을 생성
3. new FieldError() 를 생성하면서 메시지 코드들을 보관
4. th:erros 에서 메시지 코드들로 메시지를 순서대로 메시지에서 찾고, 노출

### 오류 코드와 메시지 처리 6
#### 스프링이 직접 만든 오류 메시지 처리
검증 오류 코드는 다음과 같이 2가지로 나눌 수 있다.
- 개발자가 직접 설정한 오류 코드 -> `rejectValue()`를 직접 호출.
- 스프링이 직접 검증 오류에 추가한 경우 (주로 타입 정보가 맞지 않음)
- 스프링은 타입 오류가 발생하면 `typeMismatch`라는 오류 코드를 사용한다. 이 오류 코드가 `MessageCodesResolver`를 통해서 4가지 메시지 코드가 생성되었다.
  - `typeMismatch.item.price`
  - `typeMismatch.price`
  - `typeMismatch.java.lang.Integer `
  - `typeMismatch`
- `errors.properties` 즉 message.basename에 설정한 프로퍼티 파일에 `typeMismatch`와 관련된 프로퍼티를 삽입하게 되면, 정상적으로 동작한다.


### Validator 분리 1
- 복잡한 검증 로직을 컨트롤러에서 별도로 분리.
- `Validator`라는 `interface`를 상속 받은 클래스를 컨트롤러에서 의존성 주입 받아 사용한다.

### Validator 분리 2
스프링이 Validator 인터페이스를 별도로 제공하는 이유는 체계적으로 검증 기능을 도입하기 위해서다.<br
그런데 앞에서는 검증기를 직접 불러서 사용했고, 이렇게 사용해도 된다. 그런데 Validator 인터페이스를<br>
사용해서 검증기를 만들면 스프링의 추가적인 도움을 받을 수 있다.

**WebDataBinder를 통해서 사용하기**<br>
`WebDataBinder` 는 스프링의 파라미터 바인딩의 역할을 해주고 검증 기능도 내부에 포함한다
#### 동작 방식
`@Validated` 는 검증기를 실행하라는 애노테이션이다.<br>
이 애노테이션이 붙으면 앞서 `WebDataBinder` 에 등록한 검증기를 찾아서 실행한다. 그런데 여러 검증기를<br>
등록한다면 그 중에 어떤 검증기가 실행되어야 할지 구분이 필요하다. 이때 `supports()` 가 사용된다.<br>
여기서는 `supports(Item.class)` 호출되고, 결과가 `true` 이므로 `ItemValidator` 의 `validate()` 가
호출된다.o