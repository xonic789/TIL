package algorithm;

public class Recursion1 {

    public void DFS(int n){
        if (n == 0){
            return;
        }
        System.out.print(n + " ");
        DFS(n - 1);
    }

    public static void main(String[] args) {
        new Recursion1().DFS(3);

    }

}
