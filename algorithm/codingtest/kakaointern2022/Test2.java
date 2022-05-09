package algorithm.codingtest.kakaointern2022;

import java.util.*;
import java.util.stream.Collectors;

public class Test2 {

    Deque<Integer> q1;
    Deque<Integer> q2;
    List<Integer> answerSheet;
    int n;

    public int solution(int[] queue1, int[] queue2) {
        n = queue1.length;
        long q1Sum = Arrays.stream(queue1).sum();
        long q2Sum = Arrays.stream(queue2).sum();
        if (q1Sum == q2Sum) return 0;
        if ((q1Sum + q2Sum) % 2 != 0) return -1;
        q1 = Arrays.stream(queue1).boxed().collect(Collectors.toCollection(ArrayDeque::new));
        q2 = Arrays.stream(queue2).boxed().collect(Collectors.toCollection(ArrayDeque::new));
        answerSheet = new ArrayList<>();
        long expected = (q1Sum + q2Sum) / 2;
        DFS(0, q1Sum, q2Sum, expected);
        if (answerSheet.size() == 0) return -1;
        answerSheet.sort(Comparator.comparingInt(o -> o));
        return answerSheet.get(0);
    }


    void DFS(int level, long q1Sum, long q2Sum, long expected) {
        if (q1Sum == expected && q2Sum == expected) {
            answerSheet.add(level);
            return;
        }
        if (q1.size() == 0 || q2.size() == 0 || q1Sum <= 0 || q2Sum <= 0 || level >= n * n) {
            return;
        }
        // q1을 빼고 q2에 넣는 시나리오
        int e1 = q1.pollFirst();
        q2.offerLast(e1);
        DFS(level + 1, q1Sum - e1, q2Sum + e1, expected);
        // 복구 시키기
        q1.offerFirst(e1);
        q2.pollLast();
        int e2 = q2.pollFirst();
        q1.offerLast(e2);
        DFS(level + 1, q1Sum + e2, q2Sum - e2, expected);
        q2.offerFirst(e2);
        q1.pollLast();
//        int e2 = q2.pollFirst();
//        q1.offerLast(e2);
//        DFS(level, q1Sum + e2, q2Sum - e2, expected);
    }

    public static void main(String[] args) {
        int[] q1 = {3, 2, 7, 2};
        int[] q2 = {4, 6, 5, 1};
        System.out.println(new Test2().solution(q1, q2));
//        int[] q1 = {1, 2, 1, 2};		;
//        int[] q2 = {1, 10, 1, 2};
//        System.out.println(new Test2().solution(q1, q2));
//        int[] q1 = {1, 1};
//        int[] q2 = {1, 5};
//        System.out.println(new Test2().solution(q1, q2));
    }
}
