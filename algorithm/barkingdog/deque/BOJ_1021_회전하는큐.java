package algorithm.barkingdog.deque;

import java.util.*;
import java.util.Deque;

public class BOJ_1021_회전하는큐 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < m; i++){
            queue.offer(sc.nextInt());
        }

        System.out.println(new BOJ_1021_회전하는큐().solution(n, m, queue));

    }

    private int solution(int n, int m, Queue<Integer> queue) {
        int answer = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 1; i <= n; i++){
            deque.offer(i);
        }

        while (!queue.isEmpty()){
            int toFindE = queue.poll();
            int idx = 0;
            for (int e : deque){
                if (e == toFindE) break;
                idx++;
            }

            // 위치 찾아서 처음, 중간 비교

            if (idx <= deque.size() / 2){
                while (!deque.isEmpty() && toFindE != deque.peek()){
                    deque.offerLast(deque.pollFirst());
                    answer++;
                }
            }else {
                while (!deque.isEmpty() && toFindE != deque.peek()){
                    deque.offerFirst(deque.pollLast());
                    answer++;
                }
            }
            deque.poll();
        }


        return answer;
    }
}
/**포함이 되지 않으면 오른쪽으로 밀어도 됨.
 *
 *
 * 1 2 3 4 5 6 7 8 9 10
 * 3 4 5 6 7 8 9 10 /1
 * 10 3 4 5 6 7 8 /3
 * 6 7 8 10 3 4 /6
 *
 *
 *
 *1 2 3 4 5 6 7 8 9 10
 * 2 3 4 5 6 7 8 9 10
 * 7 8 9 10 2 3 4 5 /4
 * 4 5 7 8 9 10 2 /6
 * 4 5 7 8 9 10 /7
 * 8 9 10 4 5 /9
 * 9 10 4 5 8 /10
 * 10 4 5 8 /10
 * 10 4 5 /11
 * 5 10 /12
 * 5 /13
 *
 *
 *
 */
