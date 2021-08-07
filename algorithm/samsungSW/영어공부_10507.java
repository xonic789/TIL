package algorithm.samsungSW;

import java.util.Scanner;
import java.util.Stack;

public class 영어공부_10507 {

    public static void main(String args[]) throws Exception {
		/*
		   아래의 메소드 호출은 앞으로 표준 입력(키보드) 대신 input.txt 파일로부터 읽어오겠다는 의미의 코드입니다.
		   여러분이 작성한 코드를 테스트 할 때, 편의를 위해서 input.txt에 입력을 저장한 후,
		   이 코드를 프로그램의 처음 부분에 추가하면 이후 입력을 수행할 때 표준 입력 대신 파일로부터 입력을 받아올 수 있습니다.
		   따라서 테스트를 수행할 때에는 아래 주석을 지우고 이 메소드를 사용하셔도 좋습니다.
		   단, 채점을 위해 코드를 제출하실 때에는 반드시 이 메소드를 지우거나 주석 처리 하셔야 합니다.
		 */
        //System.setIn(new FileInputStream("res/input.txt"));

		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/
        StringBuffer sb = new StringBuffer();
        for(int test_case = 1; test_case <= T; test_case++){
            sb.append("#" + test_case + " ");
            int n = sc.nextInt(), p = sc.nextInt();
            int[] arr = new int[n];
            for (int j = 0; j < n; j++){
                arr[j] = sc.nextInt();
            }
            sb.append(solution(arr,n,p));
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    public static int solution(int[] arr, int n, int p){
        int answer = 0;
        int pp = p;
        /**
         * 1. 연속된 숫자가 아니면 p--
         * 2. 연속된 숫자이면 pointer++
         * tmp가 변화하는 카운트를 센다.
         */
        int rt = 0, lt = 0;
        int cnt = 0;
        while (rt < n){
        }
        return answer;
    }
}


/**
 * 뒤에거까지 붙여야함!!
5
5 2
3 5 6 10 11
2 10
42 420
6 3
1 5 6 7 8 9
1 2
1
5 8
1 5 7 10 16
**/
// 4 `5 `6 `7 8 `9
// 12 `13 14 `15 16 17 18 `19 20 21 22 `23

