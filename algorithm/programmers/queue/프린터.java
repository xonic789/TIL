package algorithm.Programmers.queue;

import java.util.*;

public class 프린터 {
    public static int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();

        for (int prioritie : priorities){
            queue.add(prioritie);
        }
        int currentLen = location;
        while (!queue.isEmpty()){
            int queueSize = queue.size();
            int prioritie = queue.poll();
            currentLen--;
            for (int p : queue){
                if (prioritie < p) {
                    queue.offer(prioritie);
                    if (currentLen == -1){
                        currentLen = queue.size() - 1;
                    }
                    break;
                }
            }
            if (queueSize != queue.size()){
                answer++;
                if (currentLen == -1){
                    break;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] priorities = {2, 1, 3, 2};
        int location = 2;

        System.out.println(solution(priorities,location));

    }
}
