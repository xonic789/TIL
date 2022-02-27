package algorithm.programmers;

public class 숫자의표현 {

    int solution(int n) {
        int answer = 0;
        int lt = 1, rt = 1;
        int tmp = 0;
        while (rt <= n) {
            tmp += rt;
            while (tmp >= n) {
                if (tmp == n) answer++;
                tmp -= lt;
                lt++;
            }
            rt++;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(new 숫자의표현().solution(15));
    }
}
