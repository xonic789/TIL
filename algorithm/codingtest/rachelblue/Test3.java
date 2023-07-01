package rachelblue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Test3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        int[] dy = new int[n + 1];
        dy[0] = 0;
        dy[1] = 1;
        dy[2] = dy[1] + 1;
        for(int i = 3; i <= n; i++) {
            dy[i] = dy[i - 1] + dy[i - 2];
        }
        System.out.println(Arrays.toString(dy));
        System.out.println(dy[n]);
    }

}
