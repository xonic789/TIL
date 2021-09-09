package algorithm.barkingdog;

public class Func1 {

    public static void main(String[] args) {
        int n = 100;
        System.out.println(new Func1().func1(n));
        System.out.println(new Func1().func4(n));

    }

    public int func1(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 || i % 5 == 0)
                sum += i;
        }
        return sum;
    }

    public int func4(int N) {

        int max = 0;
        for (int i = 2; i <= N; i *= 2) {
            if (max < i)
                max = i;
        }
        return max;
    }
}
