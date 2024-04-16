package algorithm.barkingdog.linkedList;

import java.util.*;

public class BOJ_1158_요세푸스문제 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        List<Integer> list = new LinkedList<>();
        for (int i = 1; i <= n; i++){
            list.add(i);
        }
        ListIterator<Integer> iter = list.listIterator();
        List<Integer> answer = new ArrayList<>();
        while(!list.isEmpty()){
            int num = 0;
            boolean removed = false;
            for (int i = 0; i < k; i++){
                if (iter.hasNext()){
                    num = iter.next();
                }
                if (list.size() == iter.nextIndex()) {
                    if (i == k - 1) {
                        iter.remove();
                        removed = true;
                    }
                    iter = list.listIterator(0);
                }
            }
            answer.add(num);
            if (!removed) {
                iter.remove();
            }


        }
        StringBuilder sb = new StringBuilder();
        sb.append('<');
        answer.stream().forEach((num) -> sb.append(num+", "));
        System.out.println(sb.substring(0, sb.length()-2)+">");

    }
}
