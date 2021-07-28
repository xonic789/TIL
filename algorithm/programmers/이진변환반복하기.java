package algorithm.programmers;

public class 이진변환반복하기 {

    public int[] solution(String s) {
        int[] answer = {0,0};

        while (!s.equals("1")){
            int n = s.length();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++){
                if (s.charAt(i) == '1'){
                    sb.append(s.charAt(i));
                }else {
                    answer[1]++;
                }
            }
            s = Integer.toBinaryString(sb.length());
            answer[0]++;
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(new 이진변환반복하기().solution("110010101001")[0]);
    }
}
