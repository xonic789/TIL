package algorithm.inflearn.datastructure;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class 공주구하기 {

    public int solution(int n, int k){
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++){
            queue.offer(i);
        }

        int tmp = 1;
        while (!queue.isEmpty()){
            int prince = queue.poll();
            if (tmp != k){
                queue.offer(prince);
            }else {
                tmp = 0;
                answer = prince;
            }
            tmp++;
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        System.out.println(new 공주구하기().solution(n,k));
    }
}
