package algorithm.Programmers;

public class 타겟넘버 {
    private boolean[] check;
    private int n;
    private int answer;

    public int solution(int[] numbers, int target){
        check = new boolean[numbers.length];
        DFS(numbers,1);

        return answer;
    }

    public void DFS(int[] numbers,int L){
        if (L == n+1){

        }else{

            DFS(numbers,L+1);
        }
    }

    public static void main(String[] args){
        타겟넘버 solution = new 타겟넘버();

        int[] numbers = {1,1,1,1,1};
        System.out.println(solution.solution(numbers,3));
    }
}
