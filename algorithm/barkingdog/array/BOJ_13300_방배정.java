package algorithm.barkingdog.array;

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_13300_방배정 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[][] students = new int[N][2];
        for (int i = 0; i < N; i++){
            students[i][0] = sc.nextInt();
            students[i][1] = sc.nextInt();
        }
        int[][] tmp = new int[6][2];
        for (int i = 0; i < N; i++){
            int sex = students[i][0];
            int grade = students[i][1];
            tmp[grade-1][sex]++;
        }

        System.out.println(solution(tmp,K));
        // 성별 여 0 남 1

    }

    private static int solution(int[][] tmp, int k) {
       int cnt = 0;
       for (int i = 0; i < 6; i++){
           int s1 = tmp[i][0];
           int s2 = tmp[i][1];
           while (s1 > 0){
               s1 -= k;
               cnt++;
           }
           while (s2 > 0){
               s2 -= k;
               cnt++;
           }
       }
       return cnt;
    }

}
