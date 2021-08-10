package algorithm.barkingdog.basic;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class BOJ_2443_star6 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = sc.nextInt();
        int a = 1;

        for (int i = 1; i <= n; i++){
            for (int j = 0; j < i - 1; j++){
                bw.write(" ");
            }
            // -1 -3 -5 -7 -9
            // 9 7 5 3 1
            for (int j = 0; j < 2 * n - a; j++){
                bw.write("*");
            }
            bw.write("\n");
            a+=2;
        }

        bw.flush();
    }
}
