package algorithm.Programmers;

public class 땅따먹기 {

    int solution(int[][] land) {
        int answer = 0;
        int x = land.length;
        boolean[] check = new boolean[4];

        for (int i = 0; i < x; i++){
            int max = Integer.MIN_VALUE;
            int tmp = 0;
            for (int j = 0; j < 4; j++){
                if (!check[j] && land[i][j] > max){
                    max = land[i][j];
                    tmp = j;
                }
            }
            check = new boolean[4];
            check[tmp] = true;
            answer += max;
        }

        int answer2 = 0;
        check = new boolean[4];

        for (int i = x - 1; i >= 0; i--){
            int max = Integer.MIN_VALUE;
            int tmp = 0;
            for (int j = 0; j < 4; j++){
                if (!check[j] && land[i][j] > max){
                    max = land[i][j];
                    tmp = j;
                }
            }
            check = new boolean[4];
            check[tmp] = true;
            answer2 += max;
        }



        return answer > answer2 ? answer : answer2;
    }
    public static void main(String[] args) {
        int[][] land = {{1, 2, 3, 5}, {5, 6, 7, 8}, {4, 3, 2, 1}};
        System.out.println(new 땅따먹기().solution(land));
    }
}
