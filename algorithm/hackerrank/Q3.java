package algorithm.hackerrank;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Q3 {

  static int answer;
  static int minP;

  public static int countTeams(List<Integer> skills, int minPlayers, int minLevel, int maxLevel) {
    // Write your code here


    minP = minPlayers;
    skills = skills.stream().filter(a -> a >= minLevel).filter(a -> a <= maxLevel).collect(Collectors.toList());
    System.out.println("----------------------------");
    skills.forEach(System.out::println);
    System.out.println("----------------------------");
    int N = skills.size();
    boolean[] visited = new boolean[N];
    // minPlayers 부터
    for (int i = 1; i <= N; i++) {
      combination(skills, visited, 0, N, i);
    }
    return answer;
  }

  static void combination(List<Integer> skills, boolean[] visited, int start, int n, int r) {
    if (r == 0) {
      int cnt = 0;
      for (int i = 0; i < n; i++) {
        if (visited[i]) cnt++;
      }
      if (cnt >= minP) answer++;
      return;
    }

    for (int i = start; i < n; i++) {
      visited[i] = true;
      combination(skills, visited, i + 1, n, r - 1);
      visited[i] = false;
    }
  }

  public static void main(String[] args) {
    List<Integer> skills = new ArrayList<>();
    skills.add(4);
    skills.add(8);
    skills.add(5);
    skills.add(6);
    int minPlayers = 1;
    int minLevel = 5;
    int maxLevel = 7;
    System.out.println("answer = " + countTeams(skills, minPlayers, minLevel, maxLevel));
    skills = new ArrayList<>();
    skills.add(12);
    skills.add(4);
    skills.add(6);
    skills.add(13);
    skills.add(5);
    skills.add(10);
    minPlayers = 3;
    minLevel = 4;
    maxLevel = 10;
    answer = 0;
    System.out.println("answer = " + countTeams(skills, minPlayers, minLevel, maxLevel));
  }
}
