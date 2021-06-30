package algorithm.boostcamp;


import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++){
            arr[i] = in.nextInt();
        }
        int lt = 0;
        int rt = k - 1;
        int sum = 0;

        for (int i = 0; i < k; i++){
            sum += arr[i];
        }


        int answer = sum;
        while (rt < n){
            sum -= arr[lt++];
            sum += arr[rt++];
            if (sum > answer){
                answer = sum;
            }
        }

        System.out.println(answer);


        return ;
    }
}


