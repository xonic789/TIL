package algorithm.Programmers.dfs;

public class 타겟넘버 {
    private int n;
    private int answer;

    public int solution(int[] numbers, int target){

        DFS(numbers,0,target);
        return answer;
    }

    public void DFS(int[] numbers,int L,int target){
        if (L == n){
            int tmp = 0;
            for (int a : numbers){
                tmp += a;
            }
            if (tmp == target) answer++;
        }else{
            numbers[L] = +(numbers[L]);
            DFS(numbers,L + 1,target);
            numbers[L] = -(numbers[L]);
            DFS(numbers,L + 1,target);
        }
    }

    public static void main(String[] args){
        타겟넘버 solution = new 타겟넘버();
        int[] numbers = {1,1,1,1,1};
        solution.n = numbers.length;
        System.out.println(solution.solution(numbers,3));
    }
}
