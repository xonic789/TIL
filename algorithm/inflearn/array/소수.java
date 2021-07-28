package algorithm.inflearn.array;

import java.util.Scanner;

public class 소수 {

    static int solution(int n){
        int answer = 0;
        int[] ch = new int[n+1];
        for (int i=2; i<=n; i++){
            if(ch[i]==0) {
                answer++;
                for (int j=i;j<=n; j=j+i) ch[j]=1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(solution(sc.nextInt()));
    }
}
