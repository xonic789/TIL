**Ethernet**

- **OSI Reference Model의 Physical Layer, Data-Link Layer와 밀접하게 관련이 있는 프로토콜로써 LAN, WAN에서 많이 사용되는 프로토콜**

**Broadcast domain = Network, 하나의 네트워크 단위와 브로드캐스트 도메인은 같다고 보면 된다.**

**교환 방식의 종류**

- **회선 교환(Circuit Switching)**
    - 출발지와 목적지의 물리적 회선을 연결 설정하여 전용으로 사용
    - 예) 유선 전화
- **패킷 교환(Packet Switching)**
    - 주고 받고자 하는 데이터를 패킷 형태로 전송하는 방식
    - 물리적 회선을 직접 연결하여 전용으로 사용하지 않고 패킷만 전송하는 방식

**IP(Internet Protocol) (OSI Reference Model에서 L3에 해당하는 Network Layer에 속한다.)**

- IP Address를 기반으로 Network, Host를 인식하여 목적지까지 전송하기 위한 프로토콜.
- 패킷교환 (Packet Switching) 방식을 사용.
- 비 연결형 프로토콜
- IP의 **Headers Field**
    - **Version** : IP 버전 (IPv4). 4bit 길이
    - **IHL(IP Header Length)** : IP 헤더의 길이를 표현하는 필드. 4bit 필드 길이
    - **Type of Service** : QoS(Quality of Service)를 위한 필드. 1Byte 필드 길이
    - **Total Length** : IP 패킷의 길이(0 ~ 65535Bytes). 2Bytes 필드 길이
    - **Identification** : IP 패킷의 식별자. 2Bytes 길이
    - **DF(Dont't Fragment)** : IP 패킷의 단편화 여부를 결정하는 플래그
        - 0 : 단편화 할 수 있음 1: 단편화 하지 않음
    - **MF(More Fragment)** : 단편 조각이 더 있는 지 여부를 나타내는 플래그
        - 0 : 더 이상 쪼개진 단 편 조각이 없음 1: 단편 조각이 더 있음
    - **Fragment Offset** : IP 패킷의 단편 조각의 원래 데이터의 위치를 나타내는 필드 13bit 필드 길이
    - **TTL(Time To Live)** : IP 패킷의 수명을 나타내는 필드 (0 ~ 255) 운영체제가 정해준다. (Windows 128, Linux/Unix 64, Cisco 255)  1Byte 필드 길이
    - **Protocol** : 상위 프로토콜을 나타내는 필드
    - **Header Checksum** : IP 헤더의 오류 검증을 위한 필드. 2Bytes 필드 길이
    - **Source Address** : 출발지 IP 주소. 4Bytes 필드 길이
    - **Destination Address** : 목적지 IP 주소. 4Bytes 필드 길이
    - **Options** : IP 헤더에 추가적으로 포함될  필드의 내용이 있는 경우에만 포함되며 가변길이 임.
    - **Padding :** Options 길이가 단위 4Bytes에 못 미치는 경우 나머지 값을 채워 4Bytes를 맞춰 주기 위한 필드

**IP Addressing**

- IP 주소는 Network ID + Host ID로 구성됨.
- IP 주소 : 호스트에 할당되는 IP 주소
- 서브넷 마스크 : IP 주소에서 Network ID와 Host ID를 구분하기 위한 마스크 값
- 게이트 웨이 : 외브 네트워크로 가기 위한 관문으로 보통 라우터가 그 역할을 수행함.
    - ex) 가정에서 IP 공유기가 라우터의 한 종류이다.
- 같은 네트워크이면 MAC Address를 바로 찾아서 통신하고, 아니라면 IP Address를 이용해야함.
- 예)
    - IP 주소 : 200.10.1.5
    - 서브넷마스크 : 255.255.255.0
    - 2진수로 바꿔 둘을 AND 연산 한다.
    - 내 IP 주소를 서브넷 마스크와 AND 연산하면 결과값은 네트워크 주소이며
    - 목적지 IP 주소를 서브넷 마스크와 AND 연산하여 네트워크 주소가 같다면 같은 네트워크이고, 아니라면 라우터의 도움을 받아 외부 네트워크에 접근한다.
- 네트워크 당 Host 갯수 : 2^H - 2 (**가장 마지막 주소는 Broadcast 주소로 할당이 된다**)
- Classful : IP주소를 클래스에 따라 관리하는 것
- Classless : IP 주소를 클래스에 상관 없이 관리하는 것
- 공인 IP 주소 (Public IP Address)
    - 인터넷에서 사용할 수 있는 유일한 IP 주소
- 사설 IP 주소 (Private IP Address)
    - 사설 네트워크에서 사용할 수 있는 IP 주소
    - 인터넷(공인 네트워크)에서 사용할 수 없는 주소(라우팅이 되지 않음)
    - 10.0.0.0/8
    - 172.16.0.0/16 ~ 172.31.0.0/16
    - 192.168.0.0/24 ~ 192.168.255.0/24

**NAT(Network Address Translation)**

- 사설 네트워크망에서 외부로 요청할 때 NAT를 사용한다.
- 라우터는 공인 IP를 가지고 있기 때문에, NAT로 사설 IP를 변환하여 목적지 주소에 보내고, 목적지 서버에서는 공인 IP로 응답을 보내며, 라우터는 다시 NAT 테이블을 살펴보고 변환된 이력이 있으면 그 사설 IP로 변환해주고 호스트에 전달해준다.

---

### Transport

**Port** : 하나의 호스트 내에서 통신하는 프로세스를 구분하기 위한 논리 주소

- (포트 범위 : 0~65535)
- Well-known Port(0 ~ 1023)
    - 잘 알려진 포트로 주요 프로토콜이 사용하는 포트의 범위
- Registered Port(1024 ~ 49151)
    - 애플리케이션이 사용하는 포트의 범위
- Dynamic Port(49152 ~ 65535)
    - HTTP에서 목적지 포트는 80으로 보낼 때, 목적지에서 응답을 보내줄 포트 번호를 붙여야하는데, 랜덤으로 Dynamic port 범위 내에서 붙여서 요청한다.
    - 클라이언트 입장에서 운영체제가 임의로 할당하여 Source IP, Source Port, Destination IP, Destination Port를 명세하여 요청해주면, 요청을 받는 목적지 서버에서는 자신의 Source IP, Source Port, 요청한 측의 Destination IP, Destination Port를 명세하여 응답한다.

**TCP(Transmission Control Protocol)**

- 신뢰성 있는 데이터 전송을 하는 전송 프로토콜
- 데이터를 주고 받기 전에 반드시 연결을 수립하는 과정을 가짐
- 연결 지향형 프로토콜(Connection Oriented)
- TCP 3-way handshake : TCP 세션 수립 과정

  TCP 4-way Handshake : TCP 세션 종료 과정

  ![](/image/TCP통신과정.png)

  ![](/image/TCP_Header.png)

  **TCP 헤더 구조**

    - Source Port : 출발지 포트. 필드의 길이 2Bytes
    - Destination Port : 목적지 포트. 필드의 길이 2Bytes
    - Sequence Number :  TCP 세션 동기화를 위한 순서 번호. 필드의 길이는 4Bytes
    - Acknowledgement Number : 통신 상대가 보낸 패킷을 잘 받았다는 응답을 하기 위한 필드로 상대방에게 받은 Sequence Number, 수신한 데이터의 바이트 + 1로 지정함. 4Bytes
    - Offset : TCP Header의 길이. 필드의 길이는 4bit
    - Reserved(4bit) : 예약된 영역으로 사용하지 않음.
    - TCP Control Flags(8bit) : TCP 상태를 제어하기 위한 플래그의 모임
        - ~~CWR~~
        - ~~ECN~~
        - URG : 긴급 데이터의 유무를 나타내는 플래그
        - ACK : 요청에 대한 응답 여부를 나타내는 플래그
        - PSH : 전송할 데이터가 있는 경우
        - RST : TCP 연결을 강제로 초기화 하는 경우 사용
        - SYN : TCP 연결을 수립하는 과정에서 동기화를 하기 위한 플래그
        - FIN : TCP 연결을 정상 종료할 때 사용하는 플래그
    - Window : 수신 버퍼의 크기를 나타내는 필드. 필드의 길이는 2Bytes
        - A가 B에게 전송을 할 때 B의 입장에서 여유가 있을 땐 크기를 크게하고, 여유가 없을 때 크기를 작게 해서 데이터를 온전히 받아낼 수 있도록 쓰이는 필드
    - Checksum : TCP 헤더 및 데이터의 오류를 체크하기 위한 필드. 필드의 길이는 2Bytes
    - Urgent Point
        - TCP Control Flags 중 URG 플래그가 SET이 된 경우 긴급 데이터의 마지막 위치를 나타내는 필드.
        - 다른 데이터보다 우선해서 처리해야하는 경우에 긴급 데이터 필드를 사용한다.
    - Options : 추가적으로 기재할 필드가 있는 경우 사용하며 가변 길이다.
    - Padding : Options가 4Bytes로 딱 떨어지지 않는 경우에 나머지 부분을 `null` 값으로 채워준다.

QoS (Quality of Service) 여러 종류의 패킷들이 왔다갔다할때 서비스의 최소한의 품질을 유지하자. 먼저 처리를 하기 위해서 나오게된 필드

**UDP(User Datagram Protocol)**

### TCP

- 신뢰성 있는 데이터 전송을 지원하는 프로토콜
- 데이터를 주고 받기 전에 반드시 TCP 세션 연결을 수립함
- 연결 지향형 프로토콜
- TCP 3-way Handshake (연결)
    - Client → Server SYN (Clinet는 SYN sent 상태가 되고, Server는 SYN receive 상태가 된다)
    - Server → Client SYN, ACK
    - Client → Server ACK
- TCP 4-way Handshake (연결 종료)
    - Client → Server FIN, ACK
    - Server → Client ACK
    - Server→ Server FIN, ACK
    - Client → Server ACK

### UDP (ICMP를 이용해서 에러 점검을 한다._)

- 전송 프로토콜 중 비 신뢰적, 비 연결 지향형 프로토콜
- TCP에 비해 경량의 프로토콜로 빠른 데이터 전송에 초점을 둔 전송 프로토콜
- UDP 헤더 구조 (모두 2Bytes)
    - Source Port : 출발지 포트
    - Destination Port : 목적지 포트
    - Length : UDP 패킷의 길이 (UDP 헤더 + 데이터)
    - Checksum : UDP 헤더와 데이터의 오류 검증을 위한 필드