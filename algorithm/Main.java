package algorithm;

import java.util.*;

public class Main {
    boolean[] check;
    boolean flag;
    String answer = "NO";
    int total;

    public String solution(int n, int[] arr){
        check = new boolean[n];
        DFS(0, arr, 0, n);

        return answer;
    }

    public void DFS(int L, int[] arr, int sum, int n){
        if (flag) return;
        if (sum > total/2) return;
        if (L == n){
            if (total - sum == sum){
                answer = "YES";
                flag = true;
                return;
            }
        }else {
            DFS(L + 1, arr, sum + arr[L], n);
            DFS(L + 1, arr, sum, n);

        }

    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Main main = new Main();
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
            main.total += arr[i];
        }
        System.out.println(main.solution(n,arr));

    }
}
