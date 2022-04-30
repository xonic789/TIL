**네트워크**

- 두개 이상의 호스트를 전송매체(Media)로 연결 하는 것

**네트워크 목적**

- 정보 공유, 분산 처리, 원격 제어 등

**네트워크 분류 (규모)**

- PAN (Personal Area Network) : 개인의 전자기기들이 무선의 형태로 연결된 작은 네트워크
- LAN (Local Area Network) : 조직 내에서 컴퓨터들을 연결하기 위해 사용하는 네트워크
- WAN (Wide Area Network) : 넓은 지역을 연결하는 광역 네트워크.

**네트워크 토폴리지**

- 네트워크의 요소들(링크, 노드 등)을 물리적으로 연결한 상태 또는 연결 방식

**네트워크 토폴리지 종류**

- 버스형
    - 모든 네트워크 노드와 주변 장치가 코어 회선(Bus)와 연결된 형태
    - 모든 노드는 T자 형태의 탭을 통해 버스와 연결되며 버스의 양 종단에 Terminator를 연결해야함.
    - 장점 : 설치가 간단하고 비용이 저렴하고 장비를 추가하기 쉬움
    - 단점
        1. 장비의 수가 많아지면 성능 저하가 발생하고 장비의 위치 변경이 어려움.
        2. 버스에 장애 발생시 모든 네트워크에 장애가 발생함.
- 링형
    - 노드가 링에 순차적으로 연결된 형태로 모든 노드를 하나의 링으로 연결한 형태
    - 장점 : 구조가 단순하며 설치와 재구성이 쉬우며 장애 발생시 복구시간이 빠름
    - 단점 : 장애 발생시 링 전체에 장애가 전파된다.
- 성형
    - 제어 노드(허브)가 중앙에 위차하여 다른 모든 노드를 연결한 형태
    - 장점 : 네트워크를 중앙에서 관리하기 용이함
    - 단점 : 제어 노드에 장애 발생시 모든 노드의 통신이 불가함
- 트리형
    - 성형의 변형으로 중앙의 제어 노드에 모든 노드를 연결하지 않고 계층적으로 연결함
    - 장점 : 네트워크를 제어하기 수월하며 확장이 용이함.
    - 단점 :  중앙에 트래픽이 집중되기 쉬워 병목현상이 발생할 수 있음
- 그물형(Mesh)
    - 중앙에 제어하는 노드 없이 모든 노드가 상호간 1:1로 연결된 형태
    - 장점 : 네트워크의 신뢰성이 높다.
    - 단점 : 비용이 많이 들고 복잡하다.

![](/image/네트워크%20토폴로지1.jpg)
![](/image/네트워크토폴로지2.jpg)
![](/image/네트워크토폴로지3.jpg)

**네트워크 통신 방식**

- Unicast : 1:1 통신 방식
- Multicast
    - 1:N 통신 방식
    - 특정 그룹에 대해 동일한 메시지를 전달
- Broadcast -
    - 1:ALL 통신 방식
    - 네트워크의 모든 호스트에게 동일한 메세지를 전달하는 방식

**Protocol**

- 규칙들 또는 상호 합의된 것들의 모임으로 데이터의 포맷과 전송에 대한 것을 정의하는 것
- 네트워크 내의 컴퓨터 끼리 통신을 효율적으로 하기 위한 여러가지 규칙

**네트워크 분류 (개념적)**

- Internet : 전 세계의 수 많은 LAN과 WAN을 연결하는 거대한 네트워크
- Intranet : 조직 내의 구성원이 사용하기 위하여 구성한 네트워크
- Extranet : Intranet이 확장된 개념으로 협력사 등과 협업 할 수 있도록 하는 네트워크

### **protocols**

**Ethernet 네트워크, Ethernet 프로토콜**

1. **Ethernet**
    - OSI Reference Model Physical Layer, Data-Link Layer에 대해 정의하는 프로토콜 (하드웨어 측면)
    - LAN, WAN에서 많이 사용이 되는 규격

   ![](/image/이더넷.png)

    - Ethernet Frame의 구조
        - Preamble (10101010) * 7번을 보낸다.
            - 패킷이 전달이 되기 위해서 물리적으로 전달이 될 때 프레임을 전송하는 쪽이 있고, 받는 쪽이 있을텐데, 데이터를 통신하는 두 호스트가 있을 때, 수신지가 데이터 송신을 받을 준비가 안되어 있을때, 온전한 데이터를 받을 수 없다.
            - 여기서 데이터 통신의 종류는 동기, 비동기로 나뉘게 된다(Synchronous, ASyncrhonous)
            - 매번 정해진 타이밍에 통신을 하는건 동기 통신이라 하고,
            - 비동기 통신 :
            - 그러므로 **Preamble은 프레임 전송의 시작을 알리는 신호**이다.
            - 7Byte나 보내는 이유는 한 번에 목적지 호스트가 받아들이지 못하기 때문이다.
        - SFD(Start Frame Delimeter) : 프레임의 시작을 알리는 필드. 1Byte(10101011)
        - **Preameble, SFD는 비동기 통신의 데이터가 소실되지 않게 한다.**
        - **Ethernet Frame의 데이터 구조**
        - **DST**(Destination Address) : 목적지 주소(물리 주소). 필드의 길이는 6Bytes (48bit)
        - **SRC**(Source Address) : 출발지 주소(물리 주소). 필드의 길이는 6Bytes (48bit)
        - **Type** (Length) : Ehternet Protocol의 상위 프로토콜. 필드의 길이는 2Bytes
        - **Data** : 상위 계층에서 받은 데이터(Payload), 가변길이 (상위 프로토콜의 헤더 + 데이터)
        - **FCS**(Frame Check Sequence) : Ethernet Frame에 오류 발생 여부를 확인. 필드의 길이는 4Bytes
2. **ARP (Address Resolution Protocol)**
    - 논리 주소(IP Address)를 물리 주소(MAC Address)로 변경해주는 프로토콜

      ![](/image/ARP.png)

    - 처음 전송할 땐 전송측에선 IP Address는 알지만, MAC Address는 모르기 때문에 ARP를 이용해서 수신측 MAC Address를 알아낸다.
        1. Broadcast Frame으로 해당 MAC Address 질의
        2. Unicast Frame으로 IP에 해당하는 MAC Address를 전달함.
    - **ARP Message** 구조
        - **Hardware Type** : 물리적인 네트워크 종류를 지정하는 필드. ex) Ethernet(1) 필드의 길이는 2Bytes
        - **Protocol Type** : 논리주소를 제공하는 프로토콜을 지정하는 필드. 필드의 길이는 2Bytes. IPv4 (0x0800)
        - **Hardware Address Length** : 물리주소의 길이를 지정하는 필드(Bytes 단위로 표기). 6 (MAC Address는 2^10)
        - **Protocol Address Length** : 논리주소의 길이를 지정하는 필드 4 (IPv4이므로 2^8)
        - **OP Code**
            - ARP 메시지의 종류를 나타내는 필드. 필드의 길이는 2Bytes
            - ARP Request (1), ARP Reply (2)
        - **Sender Hardware Address** : 송신자의 물리 주소(MAC Address). 필드의 길이는 6Bytes
        - **Sender Protocol Address** : 송신자의 논리 주소 (IP Address). 필드의 길이는 4Bytes
        - **Target Hardware Address** : 대상의 물리 주소 (MAC Address). 필드의 길이는 6Bytes
        - **Target Protocol Address** : 대상의 논리 주소 (IP Address). 필드의 길이는 4Bytes
    - ARP 동작 순서
        1. ARP Cache Table에서 목적지 IP주소에 해당하는 MAC주소 존재 여부 확인
        2. ARP Cache Table에 존재하지 않으면 ARP Request Broadcast
        3. ARP Reply 수신시 ARP Cache Table에 기록 후 원래 보내고자 하는 데이터 전달

