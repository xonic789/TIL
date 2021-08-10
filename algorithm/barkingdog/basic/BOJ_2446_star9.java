package algorithm.barkingdog.basic;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class BOJ_2446_star9 {

    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = sc.nextInt();
        int a = 1;
        for (int i = 1; i <= n - 1; i++){
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

        for (int i = 1; i <= n; i++){
            for (int j = 0; j < n - i; j++){
                bw.write(" ");
            }
            for (int j = 0; j < 2 * i - 1; j++){
                bw.write("*");
            }
            bw.write("\n");
        }


        bw.flush();

    }
}
