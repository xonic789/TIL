package wadiz;

import java.util.Arrays;

public class Question3 {
    public int solution(int[] arr) {
        int answer = -1;
        int n = arr.length;
        int[] tmp = new int[arr.length];
        while (!Arrays.equals(arr,tmp)){
            int lt = 0;
            int rt = n - 1;
            while (lt <= rt){
                if (arr[lt] == arr[rt]){
                    lt++;
                    rt--;
                }else if (arr[lt] < arr[rt]){

                }

            }
        }


        return answer;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 8, 4, 2, 1};
        // 배열 초기화 상태에서 최저 단계 찾기
        new Question3().solution(arr);
    }
}
