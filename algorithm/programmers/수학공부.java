package algorithm.programmers;

public class 수학공부 {

    public static int solution(int n) {
        int answer = 0;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = i + 1;
        }
        int lt = 0;
        int rt = 0;
        int sum = 0;
        for (int i = 0; i < n; i++){
            sum += arr[i];
            if (sum == n) {
                answer++;
                rt = i;
                break;
            }
        }
        for (rt = rt + 1; rt < n; rt++){
            sum += arr[rt];
            if (sum > n){
                while (true){
                    sum -= arr[lt++];
                    if (sum == n) {
                        answer++;
                        break;
                    }
                }
            }
        }



        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(15));
    }
}
