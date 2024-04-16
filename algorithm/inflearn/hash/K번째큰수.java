package algorithm.inflearn.hash;

import java.util.*;

public class K번째큰수 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        System.out.println(K번째큰수.solution(n,k,arr));

    }

    private static int solution(int n, int k, int[] arr) {
        Set<Integer> set = new TreeSet<>(Comparator.reverseOrder());
        int answer = 0;
        for (int i = 0; i < n; i++){
            for (int j = i + 1; j < n; j++){
                for (int l = j + 1; l < n; l++){
                    set.add(arr[i]+arr[j]+arr[l]);
                }
            }
        }
        if (set.size() <= k) return -1;
        Iterator<Integer> iterator = set.iterator();
        int tmp = 0;
        while(iterator.hasNext()){
            answer = iterator.next();
            if (tmp == k - 1) break;
            tmp++;
        }


        return answer;
    }


}