package algorithm.barkingdog.queue;

import java.util.*;

public class BOJ_2164_카드2 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Queue<Integer> cards = new LinkedList<>();
        for (int i = 1; i <= n; i++){
            cards.offer(i);
        }

        while (cards.size() > 1){
            cards.poll();
            cards.offer(cards.poll());
        }
        System.out.println(cards.peek());
    }
}
