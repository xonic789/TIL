package algorithm.baeckjoon;

import java.util.Arrays;
import java.util.Scanner;

public class 놀이공원 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();

        long[] arr = new long[m];
        for (int i = 0; i < m; i++){
            arr[i] = sc.nextInt();
        }
        // 사람이 놀이기구 수보다 적으면 당연히 마지막 사람은 n번째 놀이기구를 탄다.
        if (n <= m){
            System.out.println(n);
            return;
        }

        // 모든 사람이 탔을 시간의 -1분
        long time = binarySearch(arr,n,m) - 1;
        // 맨 처음 0분에 놀이기구만큼 사람이 다 탔음.
        long children = m;

        // 최소 시간을 구했기 때문에 그 시간을 놀이기구 시간으로 나눈 몫을 취한다
        // -> 해당 시간에 사람이 얼마나 탔는지 모두 더 해준다.
        for (int i = 0; i < m; i++){
            children += time / arr[i];
        }

        int child = n - (int)children;
        int cnt = 0;
        int answer = 0;
        //나머지 애들 다 태움
        while (true){
            if (((time + 1) / arr[answer]) != (time / arr[answer])){
                cnt++;
            }
            answer++;
            if (cnt == child){
                break;
            }
        }

        System.out.println(answer);
    }

    private static long binarySearch(long[] arr, int n, int m){
        long left = 0, right = 2000000000L * 30L;
        long index = -1;
        while (left <= right){
            long middle = (left+right) / 2;
            long sum = m;
            for (int i = 0; i < m; i++){
                sum += middle / arr[i];
            }
            if (sum >= n) {
                index = middle;
                right = middle - 1;
            }else left = middle + 1;
        }
        return index;
    }
}
