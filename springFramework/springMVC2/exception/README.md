# 스프링 예외 처리

## 스프링 예외 처리 - 시작
- 스프링이 아닌 순수 서블릿 컨테이너는 예외를 어떻게 처리 하는가?

#### 서블릿은 다음 2가지 방식으로 예외 처리를 지원한다.
- `Exception`(에외)
- `response.sendError(HTTP 상태 코드, 오류 메시지)`

### Exception(예외)

#### 자바 직접 실행
자바 메인 메서드를 실행하는 경우에는, main이라는 이름의 쓰레드가 생성됨.<br>
main 메서드에서 엑셉션을 잡지 못하면 예외 정보를 남기고 메인 쓰레드가 종료됨.
#### 웹 애플리케이션
웹 애플리케이션은 사용자 요청별로 별도의 쓰레드가 할당되고, 서블릿 컨테이너 안에서 실행된다.<br>
만약 애플리케이션에서 예외를 잡지 못하고, 서블릿 밖으로까지 예외가 전달되면 어떻게 동작할까?
```text
WAS(여기까지 전파) <- 필터 <- 서블릿 <- 인터셉터 <- 컨트롤러 (예외발생)
```
결국 톰캣 같은 WAS까지 예외가 전달된다.

### response.sendError(HTTP 상태 코드, 오류 메시지)
- 오류가 발생했을 때, `HttpServletResponse`가 제공하는 `sendError`라는 메서드를 사용해도 된다.
- 당장 예외가 발생하는 것은 아니지만, 서블릿 컨테이너에게 오류가 발생했다는 점을 전달할 수 있다.
- HTTP 상태 코드와 오류 메시지도 추가할 수 있다.
<br><br>
- `response.sendError(HTTP 상태 코드)`
- `response.sendError(HTTP 상태 코드, 오류 메시지)`
#### sendError 흐름
```text
WAS(sendError 호출 기록 확인) <- 필터 <- 서블릿 <- 인터셉터 <- 컨트롤러
(response.sendError())
```
`response.sendError()`를 호출하면, `response` 내부에는 오류가 발생했다는 상태를 저장.<br>
그리고 서블릿 컨테이너는 고객에게 응답 전에 `response`에 `sendError()`가 호출되었는지 확인한다.<br>
그리고 호출되었다면 설정한 오류 코드에 맞추어 기본 오류 페이지를 보여준다.

## 서블릿 예외처리 - 오류 페이지 작동 원리
서블릿은 `Exception`이 발생해서 서블릿 밖으로 전달되거나 또는 `response.sendError()`가 호출 되었을 때, 설정된 오류 페이지를 찾는다.
#### 예외 발생 흐름
```text
WAS(여기까지 전파) <- 필터 <- 서블릿 <- 인터셉터 <- 컨트롤러(예외발생)
```
#### sendError 흐름
```text
WAS(sendError 호출 기록 확인) <- 필터 <- 서블릿 <- 인터셉터 <- 컨트롤러
(response.sendError())
```
WAS는 해당 예외를 처리하는 오류 페이지 정보 확인!
#### 오류 페이지 요청 흐름
```text
WAS `/error-page/500` 다시 요청 -> 필터 -> 서블릿 -> 인터셉터 -> 컨트롤러(/error-page/500) -> view
```
#### 예외 발생과 오류 페이지 요청 흐름
```text
1. WAS(여기까지 전파) <- 필터 <- 서블릿 <- 인터셉터 <- 컨트롤러(예외 발생)
2. WAS `/error-page/500` 다시 요청 -> 필터 -> 서블릿 -> 인터셉터 -> 컨트롤러(/error-page/500) -> view
```
**중요한 점은, 웹 브라우저(클라이언트)는 서버 내부에서 이런 일이 일어나는지 전혀 모른다는 점이다.<br>
오직 서버 내부에서 오류 페이지를 찾기 위해 추가적인 호출을 한다.**<br>
정리하면?
1. 예외가 발생해서 WAS까지 전파된다.
2. WAS는 오류 페이지 경로를 찾아서 내부에서 오류 페이지를 호출한다. 이 때 오류 페이지 경로로 필터, 서블릿, 인터셉터, 컨트롤러가 모두 다시 호출된다.

## 서블릿 예외 처리 - 필터
#### "목표"
예외 처리에 따른 필터와 인터셉터 그리고 서블릿이 제공하는 `DispatchType` 이해하기

- 오류가 발생하면 오류 페이지를 출력하기 위해 WAS 내부에서 다시 한 번 호출이 발생한다.
- 이 때 필터, 서블릿, 인터셉터도 모두 다시 호출된다.
- 근데 인증같은 경우를 생각해보면, 이미 한 번 필터나 인터셉터에서 인증 체크를 했다.
- 따라서 서버 내부에서 오류 페이지를 호출한다고 해서 해당 필터나 인터셉터가 한 번 더 호출 되는 것은 매우 비효율적!!!!
- 결국 클라이언트로부터 발생한 정상 요청인지, 오류 페이지를 출력하기 위한 내부 요청인지 구분할 수 있어야 한다.
- 서블릿은 이런 문제를 해결하기 위해 `DispatchType`이라는 추가 정보를 제공한다.

#### DispatchType
서블릿 필터는 이런 경우를 위해서 `dispatcherTypes`라는 옵션을 제공.<br>
<br>
고객이 처음 요청하면 `dispatcherType=REQUEST`이다.
`javax.servlet.DispatcherType`
```java
public enum DispatcherType {
    FORWARD,
    INCLUDE,
    REQUEST,
    ASYNC,
    ERROR
}
```
#### DispatcherType
- REQUEST : 클라이언트 요청
- ERROR : 오류 요청
- FORWARD : MVC에서 배웠던 서블릿에서 다른 서블릿이나 JSP를 호출할 때 <br>
RequestDispatcher.forward(request, response);
- INCLUDE : 서블릿에서 다른 서블릿이나 JSP의 결과를 포함할 때<br>
RequestDispatcher.include(request, response);
- ASYNC : 서블릿 비동기 호출

## 서블릿 예외 처리 - 인터셉터
- 앞서 필터의 경우에는, 필터를 등록할 때 어떤 `DispatcherType`인 경우에 필터를 적용할 지 선택할 수 있었다.
- 그런데 인터셉터는 서블릿이 제공하는 기능이 아니라 스프링이 제공하는 기능이다.
- 따라서 `DispatcherType`과 무관하게 항상 호출된다.
- 대신 인터셉터는 요청 경로에 따라서 추가하거나 제외하기 쉽게 되어있다.
- 설정을 통해 (`excludePathPatterns`)빼주면 된다.

#### 전체 흐름 정리
`/hello` 정상 요청
```text
WAS(/hello, dispatchType=REQUEST) -> 필터 -> 서블릿 -> 인터셉터 -> 컨트롤러 -> View
```

`/error-ex` 오류 요청
- 필터는 `DispatchType`으로 중복 호출 제거 (`dispatchType=REQUEST`)
- 인터셉터는 경로 정보로 중복 호출 제거(`excludePathPatterns("/error-page/**"))
```text
1. WAS(/error-ex, dispatchType=REQUEST) -> 필터 -> 서블릿 -> 인터셉터 -> 컨트롤러
2. WAS(여기까지 전파) <- 필터 <- 서블릿 <- 인터셉터 <- 컨트롤러(예외발생)
3. WAS 오류 페이지 확인
4. WAS(/error-page/500, dispatchType=ERROR) -> 필터(x) -> 서블릿 -> 인터셉터(x) ->
컨트롤러(/error-page/500) -> View
```

## API 예외 처리 - 시작

keyword: `BasicErrorController`, `HandlerExceptionResolver`<br>

- `BasicErrorController`: 스프링이 제공해주는 기본 에러 처리 컨트롤러.
  - produces를 활용해서 Request Header의 `Accept` 필드를 보고 html과 json중 결정해준다.
- `HandlerExceptionResolver`: 컨트롤러에서 예외를 WAS로 아예 전달하지 않고 서블릿 디스패처에서 `ExceptionResolver`를 호출해서 처리한다.
  - 컨트롤러에서 예외가 발생하면 인터셉터의 `postHandle()`은 호출 되지 않는다.
  - 대신 `ExceptionHandler`를 호출하여 처리할 수 있는지 보고, 처리 할 수 있으면 처리하게 맡긴다.

#### 정리
- `ExceptionResolver` 를 사용하면 컨트롤러에서 예외가 발생해도 `ExceptionResolver` 에서 예외를 처리해버린다.
- 따라서 예외가 발생해도 서블릿 컨테이너까지 예외가 전달되지 않고, 스프링 MVC에서 예외 처리는 끝이 난다.
- 결과적으로 WAS 입장에서는 정상 처리가 된 것이다. 이렇게 예외를 이곳에서 모두 처리할 수 있다는 것이 핵심이다.
- 서블릿 컨테이너까지 예외가 올라가면 복잡하고 지저분하게 추가 프로세스가 실행된다. 반면에 `ExceptionResolver` 를 사용하면 예외처리가 상당히 깔끔해진다.

## API 예외 처리 - 스프링이 제공하는 ExceptionResolver1
**ExceptionHandlerExceptionResolver**<br>
@ExceptionHandler 을 처리한다. API 예외 처리는 대부분 이 기능으로 해결한다.<br>
<br>
**ResponseStatusExceptionResolver**<br>
HTTP 상태 코드를 지정해준다.<br>
예) @ResponseStatus(value = HttpStatus.NOT_FOUND)<br>
<br>
**DefaultHandlerExceptionResolver**<br>
스프링 내부 기본 예외를 처리한다.<br>

### ResponseStatusExceptionResolver
- Exception 클래스 정의부에 `@ResponseStatus` 를 달 수 있다.
- 해당 예외가 발생할 경우 `ExceptionResolver` 해당 예외를 보고 처리할 수 있다.

### DefaultHandlerExceptionResolver
- 스프링이 기본적으로 제공하는 기본 Exception Resolver
- 무수히 많은 기본 Exception 이 정의가 되어있다.

### ExceptionHandlerExceptionResolver
- 스프링에서 가장 중요한 `ExceptionResolver`다.
#### @ExceptionHandler
- 스프링은 API 예외 처리 문제를 해결하기 위해 `@ExceptionHandler` 라는 애노테이션을 사용하는 매우 편리한 예외 처리 기능을 제공하는데, 이것이 바로 `ExceptionHandlerExceptionResolver` 이다.t
- 스프링은 `ExceptionHandlerExceptionResolver` 를 기본으로 제공하고, 기본으로 제공하는
- `ExceptionResolver` 중에 우선순위도 가장 높다. 실무에서 API 예외 처리는 대부분 이 기능을 사용한다
#### 우선순위
- 스프링의 우선순위는 항상 자세한 것이 우선권을 가진다. 예를 들어서 부모, 자식 클래스가 있다면
- `@ExceptionHandler`가 붙은 메서드가 호출 될 때, 같은 인스턴스 타입(부모, 자식 타입)이라면 자세한 것, 즉 자식 타입이 우선권을 가진다.

#### 실행 흐름
- 컨트롤러를 호출한 결과 예를 들어 `IllegalArgumentException` 예외가 컨트롤러 밖으로 던져지면?
- 예외가 발생했으로 `ExceptionResolver` 가 작동한다. 가장 우선순위가 높은 `ExceptionHandlerExceptionResolver` 가 실행된다.
- `ExceptionHandlerExceptionResolver` 는 해당 컨트롤러에 `IllegalArgumentException` 을 처리할 수 있는 `@ExceptionHandler` 가 있는지 확인한다.
- `illegalExHandle()` 를 실행한다. `@RestController` 이므로 `illegalExHandle()` 에도 `@ResponseBody` 가 적용된다. 따라서 HTTP 컨버터가 사용되고, 응답이 다음과 같은 JSON으로 반환된다.<br>
`@ResponseStatus(HttpStatus.BAD_REQUEST)` 를 지정했다면, HTTP 상태 코드 400으로 응답한다.