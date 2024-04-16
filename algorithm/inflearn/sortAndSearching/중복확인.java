package algorithm.inflearn.sortAndSearching;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 중복확인 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        System.out.println(new 중복확인().solution(arr,n));
    }

    private char solution(int[] arr, int n) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        for (int key : map.keySet()){
            if (map.get(key) > 1){
                return 'D';
            }
        }
        return 'U';
    }
}
