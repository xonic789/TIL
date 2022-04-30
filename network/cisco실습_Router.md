Rollover cable : 네트워크 장비 관리를 위하여 시리얼 통신으로 콘솔과 연결하는 케이블

- 예) PC와 switch를 연결하여 interface를 CLI로 제어한다.

UTP Cable

- Straight Through Cable : 다른 종류의 장비들끼리 서로 연결하기 위한 케이블
    - 예) PC → switch 등
- Crossover Cable : 같은 종류의 장비들끼리 서로 연결하기 위한 케이블
    - 예) switch → switch
    - 예) router → router
    - 예) switch → router
      - 

DCE : WAN 구간에서 Serial 통신 시 Clock을 제공 **하는** 장비

- CSU, DSU

DTE : WAN 구간에서 Serial 통신시 Clock을 제공 **받는** 장비

- Router

---

**Cisco IOS**

- Cisco 사에서 개발한 네트워크 장비를 위한 운영체제
- CLI 기반에서 관리할 수 있는 인터페이스를 제공함.

**Cisco IOS Modes**

- User Exec Mode : 최소한의 기능만 수행할 수 있는 모드로 네트워크 장비에서 처음 진입하게 되는 모드.
- Privileged Mode(enable) : 네트워크의 상태 정보 및 설정을 확인 할 수 있는 모드
- Global Configuration Mode (configuration terminal) : 네트워크 장비의 전역적인 설정을 할 수 있는 모드

**설정 파일 종류**

- running-config : 현재 동작중인 설정 정보를 저장. RAM에 존재하며 전원이 종료되면 사라지는 설정 파일
- startup-config : 장비의 영구적인 설정을 저장하는 설정 파일. NVRAM에 존재하며 전원이 종료되더라도 유지되는 설정 파일

### **Command**

1. User Exec Mode
    - enable : User Mode → Privileged Mode
    - ping
2. Privilleged Mode
    - disable : Privileged Mode → User Mode
    - show running-config : 현재 동작 중인 설정값
    - copy running-config startup-config : NVRAM에 존재하는 startup-config에 복사
    - show ip route : 라우팅 테이블 확인
3. Global Configuration Mode
    - hostname Name : 네트워크 장비를 관리하기 위한 이름을 지정
    - interface GigabitEthernet 0/0
        - ip address <ip address> <subnet mask>
4. Cisco IOS 패스워드
    - enable password <number>
    - enable secret <number>: Privileged level secret (암호화된 비밀번호)

### Routing

- Static Routing : 네트워크 관리자가 라우팅 경로를 직접 설정
    - 규모가 작은 네트워크
- Dynamic Routing : Routing Protocol에 의해 라우팅 경로를 동적으로 계산.
    - 규모가 상대적으로 큰 네트워크

### Router

- 라우터에 직접 연결된 (스위치 등과 직접 연결) IP는 직접 설정하게 된다. 직접 설정하게 되면 자동으로 라우팅 테이블에 올라가고, 설정이 된다. 직접 IP를 설정할 경우 라우팅 테이블을 직접 구성하지 않아도 된다.
- 라우터와 라우터를 연결, 간접 연결하게 되면 라우팅 테이블을 직접 작성해줘야한다. (상대 라우터 게이트웨이 ip가 넘어옴)
    - A 라우터 네트워크에 있는 호스트에서 B라우터(게이트웨이)로 요청을 할 시에 서로 없는 라우팅에 대해서는 응답을 줄 수 없음.

정적 라우팅 설정 명령어

- Router(config)# ip route <NETWORK_address> <subnet-*mask> <NEXT_HOP_IP주소>*
    - NET_HOP : A 라우터 → B라우터로 가기 위해서 이웃라우터의 인터페이스 주소
    - B라우터 네트워크 주소로 가기 위해선 어떻게 가야하는지를 적어줘야함.

흐름 : 2개의 라우터가 존재하고, 해당 라우터를 감싸는 네트워크 인터페이스의 주소가 존재한다. 라우터는 해당 네트워크의 아이피를 부여받고, 해당 라우터 인터페이스의 네트워크가 존재하므로 해당 네트워크 주소가 존재한다. PC는 해당 네트워크의 호스트주소를 나눠받는다. 그러므로 A 라우터에선 B라우터 네트워크 인터페이스를 모르기 때문에 직접 A라우터에 B라우터로 가는 방법을 명세해야한다.

ex) interface serial 0/0/0

- ip address 192.168.30.0 255.255.255.0