package algorithm.codingtest.programmers;

public class Question3 {
    boolean[] dx;
    boolean[] dy;
    int answer;

    public static void main(String[] args) {
        String word = "BAB";
        String[] cards = {"ZZBZ", "BAZB","XBXB","XBAX"};
        long sum = 0;
        for (int i = 79999; i >= 0; i--){
            sum += i;
        }
        System.out.println(sum);
        System.out.println(new Question3().solution(word, cards));
    }

    public int solution(String word, String[] cards) {

        dx = new boolean[cards.length];
        dy = new boolean[cards.length];
        DFS(0, 0, word,"",cards);
        return answer / 2;
    }

    public void DFS(int index, int y, String word, String res, String[] cards){
        if (res.equals(word)) {
            answer++;
            return;
        }

        for (int i = 0; i < cards.length; i++){
            int n = cards[i].length();
            if (!dx[i] && cards[i].contains(String.valueOf(word.charAt(index)))){
                // 방문처리 한다.
                dx[i] = true;
                for (int j = 0; j < n; j++){
                    // 해당 카드 방문처리한다.
                    if (!dy[j] && word.charAt(index) == cards[i].charAt(j)){
                        dy[j] = true;
                        DFS(index + 1, j, word,res + word.charAt(index), cards);
                        dy[j] = false;
                    }
                }
                dx[i] = false;
            }
        }
    }
}
