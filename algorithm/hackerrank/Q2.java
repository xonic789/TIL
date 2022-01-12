package algorithm.hackerrank;

public class Q2 {

  static final String PRO = "programmer";
  public static int programmerStrings(String s) {
    // Write your code here
    int N = s.length();
    int[] visit = new int[26];

    int index = 0;
    int start = 0;
    for (int i = 0; index < 10; i++) {
      char ch = s.charAt(i);
      if (isContains(ch)) {
        if (visit[ch - 97] == 0) {
          index++;
          visit[ch - 97]++;
        } else {
          if (ch == 'm') {
            if (visit[ch - 97] < 2) {
              index++;
              visit[ch - 97]++;
            }
          }
          if (ch == 'r') {
            if (visit[ch - 97] < 3) {
              index++;
              visit[ch - 97]++;
            }
          }
        }
      }
      if (index == 10) {
        start = i;
      }
    }

    index = 0;
    int end = 0;
    visit = new int[26];
    for (int i = N - 1; index < 10; i--) {

      char ch = s.charAt(i);
      if (isContains(ch)) {
        if (visit[ch - 97] == 0) {
          index++;
          visit[ch - 97]++;
        } else {
          if (ch == 'm') {
            if (visit[ch - 97] < 2) {
              index++;
              visit[ch - 97]++;
            }
          }
          if (ch == 'r') {
            if (visit[ch - 97] < 3) {
              index++;
              visit[ch - 97]++;
            }
          }
        }
      }
      if (index == 10) {
        end = i - 1;
      }
    }


    System.out.println(start);
    System.out.println(end);
    return end - start;
  }

  public static boolean isContains(char ch) {
    return PRO.indexOf(ch) != -1;
  }



  public static void main(String[] args) {
    System.out.println(programmerStrings("progxrammerrxproxgrammer"));
    System.out.println(programmerStrings("xprogxrmaxemrppprmmograeiruu"));
  }
}
