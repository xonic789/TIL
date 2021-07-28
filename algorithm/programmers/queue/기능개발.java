package algorithm.programmers.queue;

import java.util.*;

public class 기능개발 {
    public static List<Integer> solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        int n = progresses.length;
        Queue<Integer> queueProgresses = new LinkedList<>();

        for (int i = 0; i < n; i++){
            queueProgresses.offer(i);
        }

        int pointer = 0;
        while(queueProgresses.size() > 0){
            int cnt = 0;
            for (int i = pointer; i < n; i++){
                progresses[i] += speeds[i];
            }

            while (progresses[pointer] >= 100){
                cnt++;
                queueProgresses.poll();
                pointer++;
                if (pointer >= n) break;
            }
            if (cnt != 0) answer.add(cnt);
        }


        return answer;
    }

    public static void main(String[] args) {
        int[] progresses1 = {93, 30, 55};
        int[] speeds1 = {1, 30, 5};
        int[] progresses2 = {95, 90, 99, 99, 80, 99};
        int[] speeds2 = {1, 1, 1, 1, 1, 1};


        System.out.println(solution(progresses1,speeds1));
        System.out.println(solution(progresses2,speeds2));


    }

}
