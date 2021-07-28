> 해당 구현 내용은, 프로그래밍 언어에 대한 기초가 있어야 이해 가능합니다.
>
>reference variable (비슷한 개념으로는 pointer 가 있음), 반복자 등의 개념 설명은 따로 하지 않습니다.
>
>Java 1.5 이상 문법을 이용하여 작성한 것으로,
>Iterable, Iterator, Generic 등을 이용하여 구현하였습니다.

<br/>

<img src="../../image/LinkedList.png">

이미지 출처 : [https://www.java67.com/2016/01/how-to-implement-singly-linked-list-in-java-using-generics-example.html](https://www.java67.com/2016/01/how-to-implement-singly-linked-list-in-java-using-generics-example.html)

## 🔗 LinkedList란?

간단하게 설명하자면, **같은 형태의 데이터**가 담겨져 있고,
**다음 데이터**를 <span style="color: red">**포인터**</span>로 가리키는 자료구조를 말한다.

> ## 목차
>[1. 배열과의 차이점은?](#1-배열과의-차이점은)
> 
>[2. LinkedList의 시간복잡도](#2-LinkedList의-시간복잡도)
>
>[3. 구현 코드 설명](#3-구현-코드-설명)
>
>[4. 구현 코드](#4-구현-코드)


<br/>

## 1. 배열과의 차이점은?
- 배열은 생성부터 크기를 지정해야하고, -> **크기를 지정하지 않는다.**
- 연속된 메모리 공간을 사용한다. -> **Node라는 클래스의 next 포인터로 연결하므로 연속된 메모리 공간은 아니다.**
- 그렇기 때문에 배열의 추가 및 삭제는 실질적으로 불가능하다 (가능은 하지만 해당 인덱스를 null이나 0으로 초기화 하는 수 밖에 없다.) -> **추가는 tail의 next를 연결하는 방법으로 가능하다. 삭제는 해당 index 또는 해당 value를 비교하여 이 전 Node의 next를 해당 index 또는 value의 Node의 next로 바꿔주며 삭제한다. (garbage collection 이 처리)**
- 한번 선언된 길이는 변경할 수 없다. -> **크기를 지정하지 않는다.**
  <br/>
  
## 2. LinkedList의 시간복잡도
- 데이터의 탐색 ```O(n)```
- 데이터의 추가 ```O(1)```
    1. 처음과 끝 추가 ```O(1)```
    2. 중간 요소 추가 ```O(n)```
       <br/>
- 데이터의 삭제
    1. 처음과 끝 삭제 ```O(1)```
    2. 중간 요소 삭제 ```O(n)```
       <br/>
## 3. 구현 코드 설명

구현해본 ```LinkedList``` 는,

```Node``` 라는 ```class``` 를 작성한다.

```Node```의 ```field```에는 ```data``` 와 ```next``` 라는 포인터를 가진다.

```LinkedList```의 ```field```에는
```head```, ```tail``` 이 존재하고, 해당 ```field``` 모두 ```Node``` 의 포인터 역할을 한다.

```head```는
자료구조가 비어 있을 때 (```head == null```),
하나만 있을 때, (```head != null```),
시작점의 요소 추가 / 제거 (``` head != null```) 등에서 사용할 것이다.

```tail```은
하나만 있을 때, (```head == tail```),
끝점의 요소 추가 / 제거 등에 사용할 것이다.

<br/>

## [4. 구현 코드](./LinkedList.java)

<br/>

### 구현을 마치며
- 다음 자료구조 포스팅에서는 구현된 ```LikedList```를 이용하여 ```Hash Table``` 을 구현할 예정이다.
- 막상 직접 구현하려니 어려웠다🤣

