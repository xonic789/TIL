package algorithm.codingtest.bucketplace2021;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test1 {

    public int solution(String[][] rounds) {
        int answer = 0;
        Map<String, List<String>> map = new HashMap<>();
        for (char i = 'a'; i <= 'd'; i++) {
            map.put(i + "", new ArrayList<>());
        }
        int length = rounds.length;
        boolean[][] isRoundCoupled = new boolean[length][4];
        String[] abcd = {"a", "b", "c", "d"};

        for (int i = 0; i < length; i++) {
            // round에 따른 선택한 사람 보기
            // 커플이 되면 다음 선택하면 안됨
            // 커플이 안되면 다음 선택해도 되지만, 자기 자신을 선택하면 안됨.
            String[] round = rounds[i];
            for (int j = 0; j < 4; j++) {
                String my = abcd[j];
                String select = round[j];
                List<String> selectedList = map.get(my);
                // 0번일 경우 그냥 넣기만 하기
                selectedList.add(select);
            }
            // 커플이 되었는지 확인하기.
            for (int j = 0; j < 4; j++) {
                String my = abcd[j];
                List<String> mySelectedList = map.get(my);
                // 라운드에 선택했던 사람 들고 오기.
                String mySelected = mySelectedList.get(i);
                List<String> yourSelectedList = map.get(mySelected);
                String yourSelected = yourSelectedList.get(i);
                if (!my.equals(mySelected) && my.equals(yourSelected)) {
                    isRoundCoupled[i][j] = true;
                }
            }
            // 전라운드 대비 잘못 선택한 사람 조건 정의하기.
            if (i != 0) {
                for (int j = 0; j < 4; j++) {
                    String my = abcd[j];
                    List<String> mySelectedList = map.get(my);
                    String select = round[j];
                    // 라운드에 선택했던 사람 들고 오기.
                    String mySelected = mySelectedList.get(i - 1);
                    // 커플이 된 사람이 똑같은 사람을 선택하면?
                    if (isRoundCoupled[i - 1][j]) {
                        if (mySelected.equals(select)) {
                            answer++;
                        }
                    }
                    if (mySelected.equals(my)) {
                        answer++;
                    }
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String[][] rounds1 = {{"b", "a", "a", "d"}, {"b", "c", "a", "c"}, {"b", "a", "d", "c"}};
        String[][] rounds2 = {{"b", "a", "d", "c"}, {"b", "a", "c", "d"}};
        String[][] rounds3 = {{"b", "a", "d", "c"}, {"d", "c", "b", "a"},{"b", "a", "d", "c"}};

        System.out.println(new Test1().solution(rounds1));
        System.out.println(new Test1().solution(rounds2));
        System.out.println(new Test1().solution(rounds3));

    }
}
