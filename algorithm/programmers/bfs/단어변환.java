package algorithm.Programmers.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class 단어변환 {

    public int solution(String begin, String target, String[] words) {
        int pos = 0;
        for (int i = 0; i < words.length; i++){
            if(target.equals(words[i])) pos++;
        }

        if (pos == 0) return 0;

        int answer = BFS(begin,target,words);
        return answer;
    }

    public int BFS(String begin, String target, String[] words){
        Queue<String> queue = new LinkedList<>();
        queue.offer(begin);
        int L = 1;
        int n = target.length();

        while (!queue.isEmpty()){
            int len = queue.size();
            for (int i = 0; i < len; i++){
                String str = queue.poll();
                if (str.equals(target)) return L - 1;
                for (int j = 0; j < words.length; j++){
                    String word = words[j];
                    int cnt = 0;
                    for (int k = 0; k < n; k++){
                        if (str.charAt(k) != word.charAt(k)) cnt++;
                    }
                    if (cnt == 1) queue.offer(word);
                }
            }
            L++;
        }


        return 0;
    }

    public static void main(String[] args) {


        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
        System.out.println(new 단어변환().solution(begin,target,words));
    }
}
