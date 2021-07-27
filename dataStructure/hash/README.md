# Hash Table (작성일 : 2021-07-27)
> 해당 구현 내용은, 프로그래밍 언어에 대한 기초가 있어야 이해 가능합니다.
>
>reference variable (비슷한 개념으로는 pointer 가 있음), 반복자, 등의 개념 설명은 따로 하지 않습니다.
>
>Java 1.5 이상 문법을 이용하여 작성한 것으로,
> 
>Iterable, Iterator, Generic 등을 이용하여 구현하였습니다.

<br/>
<img src="../../image/Hash_table.svg">

이미지 출처 : [https://ko.wikipedia.org/wiki/%ED%95%B4%EC%8B%9C_%ED%85%8C%EC%9D%B4%EB%B8%94](https://ko.wikipedia.org/wiki/%ED%95%B4%EC%8B%9C_%ED%85%8C%EC%9D%B4%EB%B8%94)

> ## 목차
>[1. What is Hash Table?](#1-what-is-hash-table)
>
> - [What is Hash Function?](#what-is-hash-function-)
>
>[2. Time Complexity](#2-LinkedList의-시간복잡도)
>
>[3. Code Description](#3-구현-코드-설명)
> - [load factor](#load-factor) 
> 
>[4. Implementation](#4-구현-코드)

## 1. What is Hash Table?

- [Hash function](#-What-is-Hash-Function-?) 을 사용하여 ```Key```를 통해 ```Value```를 저장하고 탐색하는 자료구조 이다.
- 아무리 ```Hash function```을 잘 작성한다고 해도 ```Hash Collision```(해쉬 충돌) 이 발생하게 되며 해결 방법은 여기선 2가지를 소개한다.
    1. ```Separate chaining```
       - 한국어로 분리 체이닝 기법이라 한다.
       - ```array index```는 [LinkedList](../list/README.md) 포인터를 가지며 ```hash function``` 을 통해 같은 ```index```가 나온다면 LinkedList에 이어준다.

    2. ```Open Addressing```
        - 데이터를 배열에 삽입하려는 해당 인덱스가 만약 사용되고 있다면, 다른 인덱스에 삽입하는 방식이다.
        - 여러 방식 중 대표적인 ```linear probing```만 간단 소개한다.
            - ```Linear probing```
                - ```linear probing``` 은 ```Hash function```으로 얻은 배열의 인덱스가 만일 사용되고 있다면
                - 그 다음 인덱스를 순차적으로 찾으며 데이터가 담겨져 있지 않은 배열에 데이터를 삽입한다.
            - ```Quadratic probing```
            - ```Double hashing```
    
    ### What is Hash Function ?
    
    - ```hash``` 사전적 의미로는 임의의 길이의 데이터를 고정된 길이의 데이터로 변환하는 과정을 말한다. (hash equals hash function)
    - 이 글에선 한정적으로 ```Key```를 통해, 배열의 인덱스로 만드는 해싱(hashing) 과정을 거친 후 배열의 ```index```로 사용된다.
    - 자바의 ```hashcode```를 사용하는데, ```hashcode```는 해당 객체가 생성된 인스턴스 주소를 기반으로 정수 값으로 변환하며 음수가 나올 가능성이 있다.
    - 그렇기 때문에 ```0x7FFFFFFF``` 를 이용하여 ```&``` 연산 해준다. -> 음수를 양수로 비트 연산 해주는 과정을 거친다.
    - 변환 한 뒤 ```table size %``` 연산을 하게 되면 배열의 index가 나올 것이다.

## 2. Hashtable Time Complexity
- 데이터의 추가 ```O(1)```
- 데이터의 삭제,탐색
  - Worst Case에 관하여  ```O(n)``` 를 가진다.
  - 하지만 보통은 ```O(1)```의 시간복잡도를 가진다. -> 여기서 ```load factor``` (흔히 적재율이라 한다) 에 관한 개념이 나온다.
    - ```load factor```란, ```HashTable``` 의 버킷이 얼마나 찼는가를 나타낸다.
    - 이 글은 ```Separate chaining``` 기법을 사용하므로, ```LinkedList```의 ```head```가 ```hashTable``` 크기 대비 얼마나 차있는가를 백분율로 나타낼 것이다.
    ### Load factor
    - ```LinkedList``` 탐색을 활용할 것이기 때문에 O(1) 에 가까운 탐색 성능을 보장하기 위해 ```load factor```를 도입한다.
    - 데이터 추가시 ```load factor``` 를 확인한다. (```load factor``` 는 ```array```의 ```LinkedList head```가 ```null``` 이 아닌 경우의 ```cnt / size```의 값을 말한다.)
    - ```maxLoadFactor``` 는 0.75로 설정한다. 만약 초과시 ```resize``` 해준다.
    - ```resize```시 ```tableSize``` 를 2배로 늘려주고, 배열의 깊은 복사를 한다.
        - 배열의  길이가 늘어났으니 당연히 ```hashcode``` 를 다시 호출하여 적재 해야한다.    

## 3. Code Description

- ```HashTable```
    - 내부 클래스로 ```HashElement``` 를 가진다.
        - ```HashElement```
            - ```Key```와 ```Value```를 가지는 내부 클래스.
            - ```Comparable``` 을 ```implements``` 해 ```CompareTo```를 ```@Override``` 한다.
    - ```Field```
        ```java
        int numElements // 요소의 갯수
        int tableSize // 배열의 크기
        double maxLoadFactor // 최대 적재율 (0.75)
        LinkedList<HashElement<K,V>>[] hashArray // LinkedList 배열
        ```
### 4. [Implementation](./Hash.java)
<br/>

### 구현을 마치며
- ```load factor``` 개념이나, ```add```, ```resize``` 등을 예외사항을 생각하며 구현하려니 상당히 힘든 과정이었다..
- 계속해서 버전업을 해볼 생각이다.