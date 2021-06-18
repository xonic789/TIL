package algorithm.inflearn.tree;

public class 부분집합 {
    static int n;
    static int[] ch;
    public static void DFS(int L){
        if(L == n + 1){
            StringBuilder tmp = new StringBuilder();
            for (int i = 1; i <= n; i++){
                if(ch[i] == 1) tmp.append(i + " ");
            }
            if (tmp.length() > 0) System.out.println(tmp);
        }else {
            ch[L] = 1;
            DFS(L+1);
            ch[L] = 0;
            DFS(L+1);
        }
    }

    public static void main(String[] args) {
        n = 3;
        // 1부터 3까지 사용 할 것.
        ch = new int[n + 1];
        DFS(1);
    }
}
