package algorithm;

import java.util.Vector;

public class Recursion2 {

    void DFS(int n){
        if (n == 0) return;

        DFS(n / 2);
        System.out.print(n%2);
    }

    public static void main(String[] args){
        new Recursion2().DFS(11);
    }

}
