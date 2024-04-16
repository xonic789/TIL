package algorithm.inflearn.tree;

import java.util.*;

public class 합이같은부분집합 {
    static String answer = "NO";
    static int n, total = 0;
    boolean flag = false;

    public void DFS(int L, int sum, int[] arr){
        if (flag) return;
        if (sum>total/2) return;
        if (L == n) {
            if (total-sum == sum){
                answer = "YES";
                flag=true;
            }
        }else {
            // sum에 누적시킨다, (사용한다)
            DFS(L + 1, sum+arr[L],arr);
            // sum에 누적시키지 않음 (사용하지 않음)
            DFS(L + 1, sum, arr);
        }



    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
            total += arr[i];
        }
        합이같은부분집합 dfs = new 합이같은부분집합();
        dfs.DFS(0,0,arr);
        System.out.println(answer);

    }
}
