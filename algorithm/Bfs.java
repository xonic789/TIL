package algorithm;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Bfs {



    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();


        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.remove();

        for (int a : queue){
            System.out.println(a);
        }
    }
}
