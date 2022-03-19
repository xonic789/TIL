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
