package algorithm;

public class Fibonacci {
    static int[] fibo;

    public int DFS(int n) {
        //메모리제이션
        if (fibo[n]>0) return fibo[n];
        if (n == 1) return fibo[n] = 1;
        else if (n == 2) return fibo[n] = 1;
        else return fibo[n] = DFS(n - 2) + DFS(n - 1);
    }

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        int n = 45;
        fibo = new int[n+1];
        fibonacci.DFS(n);
        for (int i = 1; i <=n; i++){
            System.out.print(fibo[i]+" ");
        }

    }
}
