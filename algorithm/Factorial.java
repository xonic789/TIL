package algorithm;

public class Factorial {

    public int DFS(int n){
        if (n == 1) return 1;
        return n * DFS(n-1);
    }

    public static void main(String[] args) {
        System.out.println(new Factorial().DFS(5));
        // D5
        // 5*D4 return 120
        // 4*D3 return 24
        // 3*D2 return 6
        // 2*D1 return 2
        // return 1
    }
}
