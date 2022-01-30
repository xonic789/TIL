## Nested class와 Inner class
- 기본적으로 클래스 내에 정의되는 모든 클래스를 가리켜 `Nested class`, 즉 중첩 클래스라 한다.
- `Nested class`의 static 여부에 따라 Static, Non-static `Nested class`로 나뉜다.
- 이 중에서 Non-static `Nested class`가 Inner class이다.

## Inner class의 구분
1. 멤버 클래스 (Member class)
2. 로컬 클래스 (Local class)
3. 익명 클래스 (Anonymous class)

- 이 중에서 멤버, 로컬 클래스는 정의된 위치에 따라서 구분이 된다.
> 참고
> 멤버 클래스 : 인스턴스 변수, 인스턴스 메서드와 동일한 위치에 정의
> 로컬 클래스 : 중괄호 내, 특히 메서드 내에 정의

ex)
 ```java
 class Outer {
 	class MemberInner {} // 멤버 클래스
	void method() {} // 로컬 클래스
 }
```

## 멤버 클래스를 사용하는 이유?
- 클래스의 정의를 감추기 위함이다.
- 다형성을 이용하여 멤버 클래스를 외부에서 감추고 `getter` 등으로 외부에서 `interface`, (즉 메시지를 보낸다.. 정도) 할 수 있게 된다면 `getter`에서 반환하는 인스턴스가 다른 클래스의 인스턴스로 변경되어도, 외부에선 코드를 전혀 수정할 필요가 없게 된다.
- 우리는 이미 자바에서 컬렉션 프레임워크의 표준 중 하나인 `Iterator<E>` `interface`를 알고 있다
- 실제로, 자바 컬렉션 중 하나인 `List` 등에도 Iterator를 구현한 어떤 멤버 클래스의 정의는 감추어져 있으며 그저 우리는 컬렉션의 반복자라는 것만 알면 된다.
=> 알려고 노력할 필요도 없고, 알아도 별 의미가 없다. `Iterator`를 `implement`한 인스턴스를 제공만 받아 사용하면 되기 때문이다.
=> 우리는 표준 컬렉션의 반복자가 어떻게 사용되는지, 사용 방법만 알면 되지 굳이 인스턴스의 클래스가 무엇인지 알 필요가 없다는 말이다. 
> 참고 
List에서 iterator()의 인스턴스 클래스의 이름은 `Itr`이다.

## 로컬 클래스를 사용하는 이유?
- 간단하게 말해서, 멤버 클래스보다 더 클래스의 정의를 더 깊숙히 감춘다는 의미이다.(특정 블록 안으로 감춘다)

> 참고
> 간단하게 OOP에서 중요한 점은 캡슐화(encapsulation)이라는 것은 누구나 다 알고 있는 사실이다.
> 이는 무조건적으로 모든 걸 감추는게 아니라, 사용자에게 제공되는 공개 인터페이스는 누가 봐도 그 기능, 그 책임만을 확실히 **하나만** 할 수 있도록 하고, 외부에는 최대한 감추는게 호출하는 사용자 입장에선 좋다.
왜냐하면, 언젠간 그 공개 인터페이스를 수정함으로써 오는 유지보수를 최소화 하기 위함이다. (여러가지 이유가 더 있겠다..)

## 익명 클래스
간단한 예제를 보고 가자.
```java
import java.util.*;

class StrComp implements Comparator<String> {
  @override
  public int compare(String s1, String s2) {
    return s1.length() - s2.length();
   }
}

class Anonymous {
  public static void main(String[] args) {
    List<String> list = new ArrayList<>();
    list.add("ABC");
    list.add("AB");
    list.add("A");
    
    Comparator cmp = new StrComp();
        
    Collections.sort(list, cmp);
    System.out.println(list);
        // => 결과 : A, AB, ABC
    }
}

```
- 우리는 여기서 한가지 사실을 알 수 있다.
- `Comparator` `interface`에는 추상 메서드가 하나 뿐인데, `Comparator`를 `implements` 받은 인스턴스 클래스를 장황하게 만들어 `sort()` 메서드에 던져 줄 필요가 없다. 그래서 바로 인스턴스 생성과 동시에 구현하여 할당시켜 준다.

### 익명 클래스로 변경

```java
import java.util.*;
class Anonymous {
  public static void main(String[] args) {
    List<String> list = new ArrayList<>();
    list.add("ABC");
    list.add("AB");
    list.add("A");
        
    Comparator<String> cmp = new Comparator<String>() {
      @Override
      public int compare(String s1, String s2) {
        return s1.length() - s2.length();
      }
    };        
    Collections.sort(list, cmp);
    System.out.println(list);
    // => 결과 : A, AB, ABC
  }
}
```


{} 중괄호 내에 포함된 블럭이, **익명 클래스**라 한다.
```java
new Comparator<String>() {
      @Override
      public int compare(String s1, String s2) {
        return s1.length() - s2.length();
      }
    };        
```
- 우리는 여기서 한가지 사실을 알 수 있다.
- 굳이 `Comparator` `interface`에 메서드가 하나인데, 저렇게 길게 적을 필요가 있나?
- 그래서 자바 8에서 람다가 등장하게 되었다.

## 람다로 변경
```java
import java.util.*;

class Anonymous {
	public static void main(String[] args) {
    	List<String> list = new ArrayList<>();
        list.add("ABC");
        list.add("AB");
        list.add("A");
        
        Comparator<String> cmp = (s1, s2) -> s1.length() - s2.length();
        
        Collections.sort(list, cmp);
        System.out.println(list);
        // => 결과 : A, AB, ABC
    }
}
```

- 여기서 또 한가지 눈 여겨 볼 부분은, 왜 굳이 참조변수에 할당시켜 참조 변수를 던져 줘야 하나?
- 그럼 또 줄일 수 있다.

### 리팩토링
```java
class Anonymous {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("ABC");
        list.add("AB");
        list.add("A");

        Collections.sort(list, (s1, s2) -> s1.length() - s2.length());
        System.out.println(list);
        // => 결과 : A, AB, ABC
    }
}
```

### 정리
1. 이렇듯 자바 언어의 특성을 전혀 버리지 않으면서 함수형 패러다임을 가져온 건 정말 혁명이었다고 한다.
2. 각 클래스의 쓰임새만 잘 알아둬도 개발하는데에 도움이 될거라 생각한다.
3. 람다와 스트림에 관해 자세하게 한 번 더 정리할 예정이다.
