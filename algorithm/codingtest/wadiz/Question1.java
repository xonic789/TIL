package algorithm.codingtest.wadiz;

public class Question1 {
    public int solution(int[][] passwords, String s) {
        int answer = 0;
        String[] tmp = s.split("#");
        boolean[] check = new boolean[tmp.length + 1];

        for (int i = 0; i < passwords.length; i++){
            int unit = passwords[i][0];
            int password = passwords[i][1];
            for (int j = 0; j < tmp.length; j++){
                int inputUnit = Integer.parseInt(tmp[j]);
                int inputPw = 0;
                if (j+1 >= tmp.length){
                    break;
                }
                inputPw = Integer.parseInt(tmp[j+1]);
                if (!check[j] && unit == inputUnit && inputPw == password){
                    answer++;
                    check[j] = true;
                    check[j+1] = true;
                }
            }
        }

        return answer;
    }
    public static void main(String[] args) {

    }
}
