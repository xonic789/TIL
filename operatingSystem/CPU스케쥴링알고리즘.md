## CPU Scheduling

Ready-Queue 안에 있는 프로세스들중 어느 프로세스를CPU 서비스 받게 할 것인가?

### Preemptive vs Non-Preemptive

- Preemptive : CPU가 프로세스를 실행하고 있는데, 강제로 쫓아내고 새로운 프로세스를 실행시키는 것
    - 병원에서 의사가 이미 환자를 진료하고 있는데 응급환자가 들어왔을 때.
- Non-Preemptive : 이미 프로세스가 실행중에 있으면 끝나거나 I/O를 만나기 전에는 절대 스케쥴링이 일어나지 않는 것
    - 일반적으로 병원에서 의사가 환자를 진료하고 있을 때까진 스케쥴링이 일어나지 않음.
- 선점 : 비선점

### Scheduling criteria (CPU 스케쥴링의 기준, 척도)

- CPU Utilization (CPU 이용률) : CPU가 놀지않고 얼마나 일하느냐. CPU 이용률 (단위 %, 높을 수록 좋음)
- Throughtput (처리율) : 단위 시간안에 처리한 작업수 (jobs/sec) → 시간당 많이 처리할 수록 좋음
- Thrnaround time (반환 시간) : 프로세스가 들어오고 종료되기까지의 시간 (시간) → 짧을수록 좋음
- Waiting time (대기 시간) : CPU의 서비스를 받기 위해서 얼마나 기다렸는가?
- Response time (응답 시간) : interactive한 시스템에서 중요한 척도임. (대화형 컴퓨터에서 척도로 삼음)

## CPU Scheduling Algorithms

### First-Come, First Served (FCFS)

- 먼저 들어온 프로세스를 먼저 서비스 한다.

### Shortest-Job-First (SJF)

- Shortest-remaining-Time-First
- 작업시간이 짧은 프로세스를 먼저 서비스한다.

### Priority

- 우선순위가 높은 프로세스를 먼저 서비스한다.

### Round-Robin (RR)

- 돌면서 순서대로 서비스한다.

### Multilevel Queue

- Queue를 여러개 둔다.

### Multilevel Feedback Queue

- Queue를 여러개 둔다.

## First-Come, First Served

- 공평한데, 정말 좋은 방법인가?
- Simple & Fair
- Example: Find **A**verage **W**aiting **T**ime
    - AWT = (0+24+27)/3 = 17msec
    - cf. AWT = (0 + 3 + 6)/3 = 3msec
    - 오히려 P3부터 거꾸로 먼저 시작했으면 더 나았다..
    - P1은 0초, P2는 24초, P3는 27초를 기다린셈.
- Gantt Chart

    | Process | Burst Time (msec) |
    | --- | --- |
    | P1 | 24 |
    | P2 | 3 |
    | P3 | 3 |

- 호위효과: 선점 시간이 긴 프로세스 뒤를 따르는 것
- Non-Preemptive Scheduling

## Shortest-Job-Frist(1)

- 짧은 작업을 먼저하면 기다리는 시간이 줄어든다?
- Example: AWT = (3+16+9+0)/4 = 7msec
    - cf. 10.25 msec
- provably optimal → 증명된 최적, 대기 시간을 줄이는 방법에 있어서는 이 방법은 가장 좋은 방법이다.
- Not realistic(비현실적이다), prediction may be needed(예측을 할 수 밖에 없음)
- context switching 비용이 커질 수 있다. 왜냐하면 프로세스가 CPU 서비스를 제공받는 시간까지도 예측해야하고, 그 예측을 기록해야하기 때문이다. (PCB)

| Process | Burst Time (msec) |
| --- | --- |
| P1 | 6 |
| P2 | 8 |
| P3 | 7 |
| P4 | 3 |

## Shorttest-Job-Frist(2)

- Preemptive or Non-Preemptive
    - cf. Shortest-Remaining-Time-First (최소 잔여시간 우선)
- Example
    - Preemptive: AWT = (9+0+15+2)/4 = 26/4 = 6.5msec
    - Non-preemptive: 7.75 msec

  | Process | Arrival Time | Burst Time (msec) | 
  | --- | --- | --- |
  | P1 | 0 | 8 |
  | P2 | 1 | 4 |
  | P3 | 2 | 9 |
  | P4 | 3 | 5 |

## Priority (1)

- Priority (우선순위): typically an integer number
    - Low number represents high priority in general (Unix/Linux)
- Example
    - AWT = 8.2 msec

  | Process | Burst Time (msec) | Priority |
      | --- | --- | --- |
  | P1 | 10 | 3 |
  | P2 | 1 | 1 |
  | P3 | 2 | 4 |
  | P4 | 1 | 5 |
  | P5 | 5 | 2 |

## Priority (2)

- Priority
    - Internal(내부): time limit(시간 한계 기준), memory requirement(메모리 기준으로), i/o to CPU burst (i/o 길고 CPU 짧은 기준).....
    - External(외부): amount of funds being paid(돈 많이 낸 쪽 기준으로), political factors(정치적인 요소, ), ....
- Preemptive or Non-preemptive
- Problem
    - **Indefinite blocking**: starvation (기아) → 계속해서 프로세스가 들어오면, 우선순위가 낮으면 계속 기다릴 수 있다.
    - **Solution**: againg (Ready Queue에서 기다린 시간이 오래 머물고 있다면 점진적으로 우선순위를 높힌다)

## Round-Robin (1)

- Time-sharing system (시분할/시공유 시스템)
- Time quantum 시간 양자 = time slice (10 ~ 100msec), 너무 작게하면 안된다.
- Preemptive scheduling
- Example
    - AWT = 17/3 = 5.66msec

  | Process | Burst Time (msec) |
      | --- | --- |
  | P1 | 24 |
  | P2 | 3 |
  | P3 | 3 |

## Round-Robin (2)

- Performance depends on the size of the time quantum(성능은 양자 시간 크기에 의존된다.)
    - 델타 → 무한대 : FCFS와 같다
    - 델타 → 0 Processor sharing (* context switching overhead)
- Example: Average turnaround time (ATT) → 프로세스가 끝난 시간
    - ATT = 11.0 msec (델타 = 1), 12.25 msec (델타 = 5)

  | Process | Burst Time (msec) |
  | --- | --- |
  | P1 | 6 |
  | P2 | 3 |
  | P3 | 1 |
  | P4 | 7 |

## Multilevel Queue Scheduling

### Process groups

- System processes ↔ Student processes (사용자 프로세스)
    - O/S 나름의 작업 (가상 메모리 매핑, 파일 읽기, 통신 등)
- Interactive processes ↔ Batch processes
    - 대화형 프로세스
    - 대화형과 배치는 서로 반대되는 의미다.
- Interactive editing processes
    - 대표적인 대화형 프로세스는 에디터이다.
- Batch processes
    - 일괄적 처리 → 인터렉션을 안하니 좀 나중에 처리해도됨.
- Student processes

→ 이렇게 묶어서 보면, 프로세스끼리 그룹을 지을 수 있다는 것! CPU 서비스를 받기 위해 대기하는 프로세스 레디 큐를 여러 개를 두자.

### Single ready queue → Several separate queues (여러 별도의 큐)

- 각각의 Queue에 **절대적 우선순위 존재**
- 또는 CPU time을 각 Queue에 차등 배분
- 각 Queue는 **독립**된 **scheduling 정책**

## Multilevel Feedback(뒤에서 앞으로 오는 것) Queue Scheduling

- 복수개의 Queue
- 다른 Queue로의 점진적 이동
    - 모든 프로세스는 하나의 입구로 진입
    - 너무 많은 CPU time 사용 시 다른 Queue로
    - 기아 상태 우려 시 우선 순위 높은 Queue로