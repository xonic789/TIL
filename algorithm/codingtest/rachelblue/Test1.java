package rachelblue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Objects;

public class Test1 {

    enum Shape {
        DOT, SEGMENT, SQUARE, RECTANGLE
    }

    public Shape solution(int[] arr1, int[] arr2) throws IOException {
        if (Arrays.equals(arr1, arr2)) {
            return Shape.DOT;
        }
        // x축은 같고, y축은 서로 다르면
        if (arr1[0] == arr1[1] && arr2[0] != arr2[1]) {
            return Shape.SEGMENT;
        }
        int x = Math.abs(arr1[0] - arr2[0]);
        int y = Math.abs(arr1[1] - arr2[1]);
        //
        if (x == y) {
            return Shape.SQUARE;
        }

        return Shape.RECTANGLE;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr1 = new int[2];
        int[] arr2 = new int[2];

        String[] str = br.readLine().split(" ");
        arr1[0] = Integer.parseInt(str[0]);
        arr1[1] = Integer.parseInt(str[1]);

        str = br.readLine().split(" ");
        arr2[0] = Integer.parseInt(str[0]);
        arr2[1] = Integer.parseInt(str[1]);

        System.out.println(new Test1().solution(arr1, arr2));
    }
}
