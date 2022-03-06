package algorithm.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 거리두기확인하기 {

    // 동남서북
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};
    int[] ddx = {0, 2, 0, -2};
    int[] ddy = {2, 0, -2, 0};

    public List<Integer> solution(String[][] places) {
        List<Integer> answer = new ArrayList<>(5);

        for (String[] place : places) {
            for (int i = 0; i < 5; i++) {

            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String[][] places = {
                {"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}
        };
        System.out.println(new 거리두기확인하기().solution(places));
    }
}
