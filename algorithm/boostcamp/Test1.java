import java.util.Arrays;

public class Test1 {

    public int solution(int[] grade) {
        int answer = -1;
        int n = grade.length;
        int sum = Arrays.stream(grade).sum();
        if (!checkAsc(grade)) {
            for (int i = 0; i < n; i++) {
                if (i + 1 == n) break;
                if (grade[i] > grade[i + 1]) {
                    int tmp = grade[i] - grade[i + 1];
                    grade[i] = grade[i] - tmp;
                    if ((i - 1 >= 0) && grade[i - 1] > grade[i]) {
                        int j = i;
                        // a가 0일때까지
                        while (j-- != 0) {
                            if (j == -1) break;
                            // grade[i - 1]이 i보다 적을때까지
                            if (grade[j] > grade[j + 1]) {
                                grade[j] = grade[j + 1];
                            } else {
                                break;
                            }
                        }
                    }
                }
            }
        }
        int sum1 = Arrays.stream(grade).sum();
        System.out.println(sum - sum1);

        return answer;
    }

    private boolean checkAsc(int[] grade) {
        int n = grade.length;
        for (int i = 0; i < n; i++) {
            if (i + 1 == n) break;
            if (grade[i] > grade[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // 투포인터 가자
        int[] grade = {7,4,2,1};
        System.out.println(new Test1().solution(grade));
    }
}
