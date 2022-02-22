## Thymeleaf
- 공식 사이트: https://www.thymeleaf.org/

### [텍스트 - text, utext](src/main/resources/templates/basic/text-basic.html)
- HTML의 콘텐츠(contents)에 데이터를 출력할 때 다음과 같이 `th:text`를 사용하면 된다.

### [변수 - SpringEL](src/main/resources/templates/basic/text-variable.html)
- 자바 빈 프로퍼티에 따라 접근한다.
- 객체, 리스트, 맵 등 모두 가능
- 예)
```thymeleafexpressions
<li>${user.username} = <span th:text="${user.username}"></span></li>
<li>${users[0].username} = <span th:text="${users[0].username}"></span></li>
<li>${userMap['userA'].username} = <span th:text="${userMap['userA'].username}"></span></li>
```

### [기본 객체들](src/main/resources/templates/basic/basic-objects.html)
- request, session, response 등 타임리프가 직접 제공.
- request.getParameter를 하지 않아도 바로 사용 가능.

### [자바 8 날짜](src/main/resources/templates/basic/date.html)
- 자바 8에서 사용하는 date 지원 라이브러리 `thymeleaf-extras-java8time` 추가해야함
- 하지만 스프링 부트 타임리프에서 기본적으로 제공

### [링크 달기](src/main/resources/templates/basic/link.html)

### [리터럴](src/main/resources/templates/basic/literal.html)
- 소스코드 상에 고정된 값을 말하는 용어이다.
- 예) `String a = "Hello"` 여기서 Hello는 리터럴이다.
- 타임리프 리터럴
  - 문자: `'hello'`
  - 숫자: `10`
  - 불린: `true`, `false`
  - null: `null`

### [연산](src/main/resources/templates/basic/operation.html)
비교연산: HTML 엔티티를 사용해야 하는 부분을 주의하자,
- \> (gt), < (lt), >= (ge), <= (le), ! (not), == (eq), != (neq, ne)
- 조건식: 자바의 조건식과 유사하다.
- Elvis 연산자: 조건식의 편의 버전
- No-Operation: _ 인 경우 마치 타임리프가 실행되지 않는 것 처럼 동작한다. 이것을 잘 사용하면 HTML의 내용 그대로 활용할 수 있다. 마지막 예를 보면 데이터가 없습니다. 부분이 그대로 출력된다.

### [속성 값 설정](src/main/resources/templates/basic/attribute.html)
**속성 설정**
- `th:*` 속성을 지정하면 타임리프는 기존 속성을 `th:*` 로 지정한 속성으로 대체한다. 기존 속성이 없다면
새로 만든다.
`<input type="text" name="mock" th:name="userA" />`
타임리프 렌더링 후 `<input type="text" name="userA" />`

**속성 추가**
- `th:attrappend` : 속성 값의 뒤에 값을 추가한다.
- `th:attrprepend` : 속성 값의 앞에 값을 추가한다.
- `th:classappend` : class 속성에 자연스럽게 추가한다.
