package algorithm.programmers;

public class 나머지가1이되는수찾기 {

    public int solution(int n) {
        int answer = n;
        for (int i = n; i >= 1; i--){
            if (n % i == 1) {
                answer = Math.min(answer, i);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(new 나머지가1이되는수찾기().solution(10));
    }
}
