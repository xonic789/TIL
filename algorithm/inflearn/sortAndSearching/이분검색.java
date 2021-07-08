package algorithm.inflearn.sortAndSearching;

import java.util.Arrays;
import java.util.Scanner;

public class 이분검색 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        System.out.println(new 이분검색().binarySearch(arr, n, m));
    }

    private int binarySearch(int[] arr, int n, int m) {

        int idx;
        int answer = 0;
        int lt = 0, rt = n - 1;
        while (lt <= rt){
            int middle = (rt + lt) / 2;

            if (arr[middle] == m){
                answer = middle + 1;
                break;
            }

            if (arr[middle] > m) rt = middle - 1;
            else lt = middle + 1;

        }


        return answer;
    }
}
