package algorithm.Programmers;

public class 신규아이디추천 {
    public static String solution(String new_id) {
        String answer = "";
        //1단계
        answer = new_id.toLowerCase();
        // 2단계
        char[] tempArray = answer.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char alpha : tempArray){
            if ('a' <= alpha && 'z' >= alpha || '.' == alpha || '0' <= alpha && '9' >= alpha || alpha == '-')
                sb.append(alpha);
        }

        // 3단계
        answer = sb.toString().replace("..",".");
        while (answer.contains("..")){
            answer = answer.replace("..",".");
        }

        // 4단계

        if (answer.length() > 0){
            if (answer.charAt(0) == '.'){
                answer = answer.substring(1);
            }
        }
        if (answer.length() > 0){
            if (answer.charAt(answer.length()-1) == '.'){
                answer = answer.substring(0, answer.length()-1);
            }
        }


        // 5단계

        if (answer.length() == 0){
            answer += "a";
        }

        if (answer.length() >= 16){
            answer = answer.substring(0,15);
            if (answer.charAt(answer.length()-1) == '.'){
                answer = answer.substring(0, answer.length()-1);
            }
        }


        sb = new StringBuilder(answer);
        if (sb.length() <= 2) {
            char last = sb.charAt(sb.length() - 1);

            while (sb.length() < 3){
                sb.append(last);
            }
        }

        answer = String.valueOf(sb);
        return answer;
    }

    public static void main(String[] args){
        System.out.println(solution("...!@BaT#*..y.abcdefghijklm"));
        System.out.println(solution("z-+.^."));
        System.out.println(solution("=.="));
        System.out.println(solution("123_.def"));
        System.out.println(solution("abcdefghijklmn.p"));

    }

}
