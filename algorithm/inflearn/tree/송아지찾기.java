package algorithm.inflearn.tree;

import java.util.LinkedList;
import java.util.Queue;

public class 송아지찾기 {
    public int solution(int root, int target){
        int answer = 0;
        answer = BFS(root,target);
        return answer;
    }

    public int BFS(int root, int target){
        int L = 0;
        boolean[] check = new boolean[10001];
        int[] move = {1, -1, 5};
        Queue<Integer> queue = new LinkedList<>();
        check[root] = true;
        queue.offer(root);
        while (!queue.isEmpty()){
            int len = queue.size();
            for (int i = 0; i < len; i++){
                int x = queue.poll();
                for (int j = 0; j < 3; j++){
                    int nx = x + move[j];
                    if (nx==target) return L+1;
                    if (nx >= 1 && nx <= 10000 && !check[nx]){
                        check[nx] = true;
                        queue.offer(nx);
                    }
                }
            }
            L++;
        }

        return L;
    }

    public static void main(String[] args) {
        송아지찾기 solution = new 송아지찾기();
        System.out.println(solution.solution(5,14));
    }
}
