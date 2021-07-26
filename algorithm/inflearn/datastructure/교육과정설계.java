package algorithm.inflearn.datastructure;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 교육과정설계 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nec = sc.nextLine();
        String design = sc.nextLine();

        System.out.println(new 교육과정설계().solution(nec,design));
    }

    private String solution(String nec, String design) {
        String answer = "NO";
        Queue<Character> queue = new LinkedList<>();
        for (int i = 0; i < nec.length(); i++){
            queue.offer(nec.charAt(i));
        }

        for (int i = 0; i < design.length(); i++){
            if (queue.peek() == design.charAt(i)){
                queue.poll();
            }
            if (queue.isEmpty()){
                answer = "YES";
                break;
            }
        }

        return answer;
    }
}
