## 타임리프 스프링 통합
### 스프링 통합으로 추가되는 기능들
- 스프링의 SpringEL 문법 통합
- `${@myBean.doSomething()}` 처럼 스프링 빈 호출 지원
- 편리한 폼 관리를 위한 추가 속성
  - `th:object` (기능 강화, 폼 커맨드 객체 선택)
  - `th:field` , `th:errors` , `th:errorclass` 
- 폼 컴포넌트 기능
- checkbox, radio button, List 등을 편리하게 사용할 수 있는 기능 지원
- 스프링의 메시지, 국제화 기능의 편리한 통합
- 스프링의 검증, 오류 처리 통합
- 스프링의 변환 서비스 통합(ConversionService)

- 스프링 프레임워크 사용시 타임리프 템플릿 엔진을 스프링 빈에 등록해야하고, 타임리프용 뷰 리졸버를 스프링 빈으로 등록해야한다.
- 하지만 스프링 부트는 이런 부분을 모두 자동화 해준다.
  build.gradle
```groovy
implementation 'org.springframework.boot:spring-boot-starter-thymeleaf'
```
### 입력 폼 처리
- `th:object`: 커맨드 객체를 지정한다.
- `*{...}`: 선택 변수 식이라고 한다. `th:object`에서 선택한 객체에 접근한다.
- `th:field`
  - HTML 태그의 id, name, value 속성을 자동으로 처리해준다.



