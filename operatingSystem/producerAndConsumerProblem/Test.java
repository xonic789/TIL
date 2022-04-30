package operatingsystem.producerAndConsumerProblem;

import java.util.concurrent.Semaphore;

class Buffer {
  int[] buf;
  int size; // 버퍼 크기
  int count; // 데이터가 들어간 횟수 (데이터 갯수)
  int in; // 데이터가 들어간 배열 인덱스
  int out; // 데이터가 나간 배열 인덱스
  Semaphore mutex; // critical section을 보호하기 위한 Semaphore
  Semaphore empty; // 생산자 세마포, 버퍼가 비어있냐? 버퍼가 꽉차있으면(생산하면 안됨) 세마포 큐에 들어가고, 소비자가 깨워줘야함.
  Semaphore full; // 소비자 세마포, 버퍼가 차있냐? 버퍼가 비어있으면(꺼내면 안됨) 세마포 큐에 들어가고, 생산자가 깨워줘야함.


  Buffer(int size) {
    buf = new int[size];
    this.size = size;
    count = in = out = 0;
    mutex = new Semaphore(1);
    empty = new Semaphore(size);
    full = new Semaphore(0);
  }

  void insert(int item) {
    /* check if buf is full*/
    //while (count == size) => busy wait이다.
    //  ;
    // 무한 루프 돌면서 빌 때까지 기다림

    /* buf is not full*/
    try {
	empty.acquire();

    	mutex.acquire();
	////////////////
    	buf[in] = item;
    	in = (in + 1) % size; // 계속해서 버퍼를 사용하기 위해
    	count++;
    	mutex.release();
	///////////////
	
	full.release();
    } catch (InterruptedException e) {}
  }

  int remove() {
    /* check if buf is empty */
    //while (count == 0) => busy wait이다.
    //  ;
      // 데이터가 들어간게 없으면 무한루프로 들어올 때까지 기다림

      /* buf is not empty */
    try {
	
	full.acquire();

	mutex.acquire();
	////////////////////
    	int item = buf[out];
    	out = (out + 1) % size; // 계속해서 버퍼를 사용하기 위해
    	count--;
	mutex.release();
	///////////////////
	empty.release();
    	return item;
    } catch (InterruptedException e) {return -1;}
  }
}
/* 생산자 */
class Producer extends Thread {
  Buffer b;
  int N;
  Producer(Buffer b, int N) {
    this.b = b;
    this.N = N;
  }

  public void run() {
    for (int i = 0; i < N; i++) {
      b.insert(i);
    }
  }
}

/* 소비자 */
class Consumer extends Thread {
  Buffer b;
  int N;
  Consumer(Buffer b, int N) {
    this.b = b;
    this.N = N;
  }

  public void run() {
    int item;
    for (int i = 0; i < N; i++) {
      item = b.remove();
    }
  }
}

public class Test {

  public static void main(String[] args) {
    Buffer b = new Buffer(100);
    Producer p = new Producer(b, 10000);
    Consumer c = new Consumer(b, 10000);
    p.start();
    c.start();

    try {
      p.join();
      c.join();
    } catch (InterruptedException e) {}
    System.out.println("Number of items in the buf is " + b.count);


  }
}
