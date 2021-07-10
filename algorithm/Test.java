package algorithm;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Test {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int e = sc.nextInt();
        System.out.println(new Test().BFS(s,e));
    }

    private int BFS(int s, int e) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] check = new boolean[10001];
        queue.offer(s);
        int[] move = {1, -1, 5};
        int L = 0;

        while (!queue.isEmpty()){
            int len = queue.size();
            for (int i = 0; i < len; i++){
                int current = queue.poll();
                for (int j = 0; j < 3; j++){
                    int nx = current+move[j];
                    if (nx == e) return L+1;
                    if (nx <= 0 || nx > 10000){
                        continue;
                    }
                    if (!check[nx]) {
                        queue.offer(current + move[j]);
                        check[nx] = true;
                    }
                }
            }
            L++;
        }
        return L;
    }


}
