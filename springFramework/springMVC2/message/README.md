### 메시지 국제화
- 스프링은 기본적으로 MessageSource가 messages.properties를 default로 사용하게 빈을 등록한다.
- Locale 정보를 알아야 언어를 선택할 수 있는데, 스프링은 기본으로 `Accept-Language` 헤더의 값을 사용한다.
- 그래서, 타임리프는 `th:text="#{}"`를 통해 messages_xx.properties의 값을 사용한다.

**LocaleResolver**
- 스프링은 `Locale` 선택 방식을 변경할 수 있도록 `LocaleResolver`라는 인터페이스를 제공한다.
- 스프링 부트는 기본으로 `Accept-Language`를 활용하는 `AcceptHeaderLocaleResolver`를 사용한다.
- Locale 선택 방식을 변경하려면, `LocaleResolver`의 구현체를 변경해서 쿠키나 세션 기반의 `Locale` 선택 기능을 사용할 수 있다.

