package algorithm.inflearn.datastructure;

import java.util.*;

public class 응급실 {

    public int solution(int n, int m, int[] arr){
        Queue<List<Integer>> queue = new LinkedList<>();


        for (int i = 0; i < n; i++){
            List<Integer> list = new ArrayList<>();
            list.add(arr[i]);
            list.add(i);
            queue.offer(list);
        }
        int answer = 0;

        while (!queue.isEmpty()){
            // 환자 꺼냄
            int len = queue.size();
            List<Integer> tmp = queue.poll();
            int p = tmp.get(0);
            int idx = tmp.get(1);

            for (List<Integer> list : queue){
                if (p < list.get(0)){
                    queue.offer(tmp);
                    break;
                }
            }

            if (len > queue.size()){
                answer++;
                if (idx == m){
                    break;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        System.out.println(new 응급실().solution(n,m,arr));
    }
}
