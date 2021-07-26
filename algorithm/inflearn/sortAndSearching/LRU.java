package algorithm.inflearn.sortAndSearching;

import java.util.Scanner;

public class LRU {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        for (int x : new LRU().solution(s, n, arr)){
            System.out.print(x + " ");
        }

    }

    private int[] solution(int size, int n, int[] arr) {
        int[] cache = new int[size];
        for (int x : arr){
            // cache miss 일 경우 -1로 있는다.
            int pos = -1;
            for (int i = 0; i < size; i++){
                //cache hit
                if (x == cache[i]) pos = i;
            }
            // cache miss
            if (pos == -1){
                for (int i = size - 1; i >= 1; i--){
                    cache[i] = cache[i - 1];
                }
                cache[0] = x;
            }else {
                for (int i = pos; i >= 1; i--){
                    cache[i] = cache[i - 1];
                }
                cache[0] = x;
            }
        }
        return cache;
    }
}
