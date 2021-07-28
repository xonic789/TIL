package algorithm;

public class BruteForce1 {
    static int bfMatch(String text, String pattern){
        int ptxt = 0; // txt 커서
        int ppattern = 0; // pat 커서


        // text pointer 가 text 길이와 같다면 모두 검사하였기 때문에 검사를 중단.
        // pattern pointer 가 pattern 길이와 같다면 검사가 완료 (해당 패턴이 존재한다) 되었기 때문에 중단.
        while (ptxt != text.length() && ppattern != pattern.length()){
            // 서로 시작점이 같을 때 뒤에도 확인해봐야 하기 때문에, 둘 다 증가 시킴.
            if (text.charAt(ptxt) == pattern.charAt(ppattern)){
                ptxt++;
                ppattern++;
            // 1. text 는 계속 증가하여야하고, pattern 은 계속 0이어야함.
            // 2. 아닐 경우 pattern 의 pointer 를 최초 문자와 같을 때의 +1 을 하여야 한다.
            // ex) text : 12345456
            // ex) pattern : 456
            // pt = 5, pp = 2
            // 5 - 2 + 1 = 4 -> 같은 index 는 3이었기 때문에 pt는 4가 되어야함.
            // 같은 경우 계속 증가하다가, 해당 패턴까지 검사하였기 때문에, 그 것을 빼준 뒤 + 1을 해주는 과정.
            }else {
                ptxt = ptxt - ppattern + 1;
                ppattern = 0;
            }
        }

        //pattern pointer 가 pattern length 와 같게 된다면, 검색이 완료 됐으므로
        // text 를 검사하는 과정중 pattern 만큼 증가했을 것이기 때문에, 시작 지점을 리턴하는 과정.
        if (ppattern == pattern.length()){
            return ptxt - ppattern;
        }

        return -1;
    }

    public static void main(String[] args) {
        int idx = bfMatch("12345456","456");
    }


}
