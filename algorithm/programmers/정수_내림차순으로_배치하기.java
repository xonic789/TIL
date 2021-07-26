package algorithm.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class 정수_내림차순으로_배치하기 {
    public long solution(long n) {
        long answer = 0;
        char[] tmp = String.valueOf(n).toCharArray();
        Arrays.sort(tmp);

        return Long.parseLong(new StringBuilder(new String(tmp)).reverse().toString());
    }

    public static void main(String[] args) {
        long n = 118372;
        System.out.println(new 정수_내림차순으로_배치하기().solution(n));
    }
}

