O2O (Online-to-Offline) : 온라인에서 제품을 구매하고 오프라인에서 제품을 수령
(온라인 쇼핑, 배달앱)
O4O (Online-for-Offline) : 온라인 채널을 통해 오프라인으로 고객을 모으는 것

온프레미스 : 소프트웨어, 솔루션 등을 자체 전산실 등에 직접 설치하여 운영하는 형태

---

네트워크 : 2개 이상의 Host가 전송매체를 통해 서로 연결된 상태
자료 공유, 분산처리 등

### ISO  Open System Interconnection(OSI) Reference Model

**L7 : Application Layer**

- 애플리케이션이 구동되는 계층으로 사용자와 상호작용 하는 계층

**L6 : Presentation Layer**

- 데이터의 표현 방식을 정의함
- 데이터의 인코딩 방식, 데이터 압축, 데이터 암호화 등을 수행함

**L5 : Session Layer**

- 세션 연결, 유지, 종료에 결쳐서 세션의 관리를 담당함

**L4 : Transport Layer**

- 데이터의 전송 방식을 정의함
- 포트 번호
- 방화벽(Firewall)

**L3 : Network Layer**

- 패킷을 목적지까지 전달하는 역할을 수행함
- 경로 결정(라우팅)을 통해 목적지 네트워크를 찾아감
- 논리적 주소(IP), 패킷
- Router

**L2 : Data-Link Layer**

- 프레임을 인접 노드에 전달하는 역할을 수행함
- 물리적 주소(MAC), 프레임
- Switch, Bridge, NIC(Network Interface Card)

**L1 : Physical Layer**

- 네트워크의 물리적 연결에 대한 명세를 정의
- 전송매체, Hub

**TCP/IP Protocol suite**

- Aplication
    - Session Layer + Presentation Layer + Application Layer의 역할을 수행함
- Transport
    - 데이터의 전송 방식 결정 - TCP / UDP  (Transport Layer에 해당)
- Internet
    - Network Layer에 해당
- Network Access (=Network Interface)
    - Physical Layer + Data-Link Layer의 역할을 수행함

**Hub(Dummy Hub) L1**

- 두개 이상의 Host를 네트워크로 연결할 수 있도록 하는 네트워크 장비
- 입력 포트의 데이터(신호)를 나머지 모든 포트로 복제한다.
- 장비를 많이 연결할 수록 Collision 및 속도 저하가 발생한다.

**Switch(Switching Hub) L2**

- 두개 이상의 Host를 네트워크로 연결할 수 있도록 하는 네트워크 장비
- 각 포트마다 최대 대역폭 내에서 속도 저하 없이 빠른 통신이 가능하다.
- 입력 프레임의 MAC Address를 확인하여 스위치의 MAC Address Table에 있는 해당 포트로 전달한다.

**Switch의 기능**

- Learning - MAC Address를 학습하는 단계
- Flooding - 연결된 모든 포트로 프레임을 복제함

- Forwarding - MAC Address Table에 등록된 포트로 프레임을 직접 전달함
- Filtering - 목적지 호스트(포트)로 Forwarding할 때 나머지 포트로 전달되지 않도록 함
- Aging - 일정시간(5분) 이상 통신 이력이 없는 항목을 삭제함

**Router L3**

- 네트워크와 네트워크를 서로 연결하는 네트워크 장비
- 라우팅 테이블을 사용하여 목적지 네트워크까지 가는 경로를 결정함
- 라우터는 특정 인터페이스에서 들어온 패킷의 목적지 주소를 확인하고 목적지와 연결된
- 인터페이스로 전송할 것을 결정함

**Firewall L4**

- 외부로부터의 비인가된 접근을 차단하는 네트워크 보안 장비
- IP, Port 번호를 통해 접근을 제어할 수 있다.
- 특정 네트워크로 부터 접근하는 것을 허용하거나  허용된 서비스에만 접근하는 등의 보안 설정을 할 수 있음

**Encapsulation(캡슐화)**

**Decapsulation(역캡슐화)**

**MAC Address**

- 물리 주소로 네트워크 카드(NIC)에 물리적으로 부여된 전세계에서 유일한 주소
    - 48bit(6Bytes) 길이의 주소로 OUI(3Bytes) + Serial No(3Bytes)

**IP Address (IPv4)**

- 전세계에 걸쳐 인터넷으로 연결된 컴퓨터를 유일하게 구분하기 위한 인터넷 주소
- 논리적 주소로 IPv4, IPv6가 있음
- IPv4의 경우 2^32의 Address Space를 가짐.
- XXX.XXX.XXX.XXX (0 ~ 255)
- IP 주소는 Network ID(네트워크 주소부) + Host ID(호스트 주소부)로 구성됨
- 네트워크에서 Host ID bit가 모두 0인 IP주소는 네트워크 주소
- 네트워크에서 Host ID bit가 모두 1인 IP주소는 브로드캐스트 주소

**Class에 따른 네트워크 범위 (p.91)**

- 첫번째 Octet    기본 서브넷마스크
- Class A : 1 ~ 127        255.0.0.0
- Class B : 128 ~ 191     255.255.0.0
- Class C : 192 ~ 223     255.255.255.0
- Class D : 224 ~ 239
- Class E : 240 ~ 254

**IP Address (IPv6)**

- IPv6의 경우 2^128의 Address Space를 가짐.
- HHHH:HHHH:HHHH:HHHH:HHHH:HHHH:HHHH:HHHH