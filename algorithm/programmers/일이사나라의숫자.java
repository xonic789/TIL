package algorithm.Programmers;

public class 일이사나라의숫자 {

    public String solution(int n){
        String answer = "";
        convert(n);
        return answer;
    }


    public String convert(int n){
        String tag = "";
        String tmp = "";
        String[] tmpArr = {"4", "1", "2"};
        while (n > 0){
            tag = tmpArr[n % 3];
            tmp = tag + tmp;
            if (n % 3 == 0){
                n = (n / 3) - 1;
            }else {
                n /= 3;
            }

        }
        return tmp;
    }

    public static void main(String[] args) {

        for (int i = 3; i < 500; i += 3){
            System.out.println(i + " " + Integer.toString(i,3));
        }

        System.out.println(new 일이사나라의숫자().solution(9));
    }
}
