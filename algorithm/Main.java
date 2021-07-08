package algorithm;

import java.util.*;

public class Main {

    public List<Integer> solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        Queue<Integer> progressQ = new LinkedList<>();
        Queue<Integer> speedQ = new LinkedList<>();


        for(int i=0; i<progresses.length; i++){
            progressQ.add(progresses[i]);
            speedQ.add(speeds[i]);
        }   // 큐 만들기



        // 이 코드가
        int days = 0;
        while (!progressQ.isEmpty()) {
            int progress = progressQ.peek();    // 첫 기능
            int speed = speedQ.peek();  // 첫 기능의 speed
            if(progress < 100){
                // 첫 기능이 출시될 때까지 필요한 날을 days에 더한다

                // 이거 형변환 왜 하셨어요?

                days += Math.ceil((double)(100-progress)/(double)speed);
            }
            // 의미 없는 코드.
            else {
                days += 0;
            }

            int count = 0;  // 출시된 기능수
            while (!progressQ.isEmpty() && progressQ.peek() + days * speedQ.peek() >= 100) {
                // days일 때 기능의 진행도가 100 이상이면 progressQ와 speedQ를 poll하고 출시된 기능수를 더한다.
                progressQ.poll();
                speedQ.poll();
                count++;
            }

            answer.add(count);
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1, 1, 1, 1, 1, 1};
        System.out.println(new Main().solution(progresses,speeds));
    }
}
