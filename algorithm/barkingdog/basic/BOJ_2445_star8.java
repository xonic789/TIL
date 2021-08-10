package algorithm.barkingdog.basic;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class BOJ_2445_star8 {

    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = sc.nextInt();

        //8 6 4 2
        int a = 2;
        for (int i = 1; i <= n; i++){
            for (int j = 0; j < i; j++){
                bw.write("*");
            }
            for (int j = 0; j < 2 * (n) - a; j++){
                bw.write(" ");
            }
            for (int j = 0; j < i; j++){
                bw.write("*");
            }
            bw.write("\n");
            a+=2;
        }

        for (int i = 1; i <= n - 1; i++){
            for (int j = 0; j < n - i; j++){
                bw.write("*");
            }
            for (int j = 0; j < 2 * i; j++){
                bw.write(" ");
            }
            for (int j = 0; j < n - i; j++){
                bw.write("*");
            }
            bw.write("\n");
        }


        bw.flush();
    }
}
