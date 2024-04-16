package algorithm.barkingdog.basic;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class BOJ_2441_star4 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = sc.nextInt();
        int a = 0;
        for (int i = n; i >= 0; i--){

            for (int k = 0; k < a; k++){
                bw.write(" ");
            }

            for (int j = 0; j < i; j++){
                bw.write("*");
            }
            bw.write("\n");
            a++;
        }
        bw.flush();
    }
}
