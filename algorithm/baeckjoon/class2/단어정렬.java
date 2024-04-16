package algorithm.baeckjoon.class2;

import java.util.*;

public class 단어정렬 {

    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++){
            set.add(sc.nextLine());
        }
        List<String> list = new ArrayList<>();

        for (String tmp : set){
            list.add(tmp);
        }

        list.sort((o1, o2) -> {
            if (o1.length() == o2.length()){
                return o1.compareTo(o2);
            }else {
                return o1.length() - o2.length();
            }
        });

        for (String tmp : list){
            System.out.println(tmp);
        }
    }

}
