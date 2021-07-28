package algorithm.inflearn.timeComplexity;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 최대_길이_연속부분수열 {

    static int solution(int n,int k,int[] input){
        int answer = 0;
        List<Integer> list = new ArrayList<>();
        int lt = 0;
        int rt = 0;
        int cnt = 0;

        while (rt < n){
            // rt가 0일 때는 무조건 cnt++해준다.
            if (input[rt] == 0){
                cnt++;
            }
            // cnt가 k보다 크다면 lt를 0일 때 까지 증가시켜준다.
            if (k < cnt){
                while (cnt > k){
                    if (input[lt] == 0) cnt--;
                    lt++;
                }
            }
            if (answer < rt - lt + 1){
                answer = rt - lt + 1;
            }
            rt++;

        }
        

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] input = new int[n];
        for (int i=0; i<n; i++){
            input[i] = sc.nextInt();
        }
        System.out.println(solution(n,k,input));
    }
}
