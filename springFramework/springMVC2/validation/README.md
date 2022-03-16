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
- FieldError가 제공하는 생성자를 이용하여 거절된 값을 저장해두고, 뷰에서 렌더링할 때 사용 가능하다.
  - 이렇게 되면 사용자가 잘못 요청한 값을 다시 보여줄 수 있다.
