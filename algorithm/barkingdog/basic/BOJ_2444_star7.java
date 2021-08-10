package algorithm.barkingdog.basic;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class BOJ_2444_star7 {

    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++){
            for (int j = 0; j < n - i; j++){
                bw.write(" ");
            }
            for (int j = 0; j < 2 * i - 1; j++){
                bw.write("*");
            }
            bw.write("\n");
        }
        int a = 1;
        for (int i = 1; i <= n - 1; i++){
            for (int j = 0; j < i; j++){
                bw.write(" ");
            }
            for (int j = 0; j < 2 * (n - 1) - a; j++){
                bw.write("*");
            }
            bw.write("\n");
            a+=2;
        }

        bw.flush();
    }
}
