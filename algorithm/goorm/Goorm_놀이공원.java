package algorithm.goorm;

import java.io.*;
import java.lang.*;
import java.util.*;

public class Goorm_놀이공원 {

    public static final Scanner scanner = new Scanner(System.in);

    public static void testCase(int caseIndex) {
        int N = scanner.nextInt();  // 지도의 크기
        int K = scanner.nextInt();  // 놀이공원의 크기

        int[][] wastes = new int[N][N]; // 각 칸의 쓰레기 존재 여부
        for (int r = 0; r < N; r += 1) {
            for (int c = 0; c < N; c += 1) {
                wastes[r][c] = scanner.nextInt();
            }
        }

        int answer = Integer.MAX_VALUE;
        int x = 0, y = 0;

        // x는 열, y는 행이다.
        while (true) {
            if (x + K >= N) {
                break;
            }

            int sum = 0;
            for (int i = x; i < x + K; i++) {
                for (int j = y; j < y + K; j++) {
                    sum += wastes[i][j];
                }
            }
            if (answer > sum) {
                answer = sum;
            }
            // x를 증가시킬 땐
            // y를 증가 시킬 땐 반복할 때마다 이어야 한다.
            // 만약 y + K가 length보다 크다면 0으로 초기화 해준다.
            if (y + K >= N) {
                y = 0;
                x++;
            } else {
                y++;
            }
        }


        System.out.println(answer);
    }

    public static void main(String[] args) throws Exception {
        int caseSize = scanner.nextInt();

        for (int caseIndex = 1; caseIndex <= caseSize; caseIndex += 1) {
            testCase(caseIndex);
        }

    }

}

