package algorithm.barkingdog.array;

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_10807_갯수세기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int answer = 0;
        for (int e : arr){
            if (e == v) answer++;
        }
        System.out.println(answer);

    }
}
