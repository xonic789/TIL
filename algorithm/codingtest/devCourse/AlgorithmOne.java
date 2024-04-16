package devCourse;

/**
 * 프로그래머스 데브코스 백엔드 과정 1번
 */
public class AlgorithmOne {

    public int solution(int[] d, int m) {
        int answer = 0;
        int n = d.length;

        int box = 1;
        int boat = 0;
        for (int i = 0; i < n; i++){
            if (m <= 0) {
                break;
            }
            if (d[i] >= box){
                boat++;
                m -= box;
                box *= 2;
            }else {
                box = 1;
                boat++;
            }
        }

        if (m > 0) return -1;

        return boat;
    }

    public static void main(String[] args) {
        int[] d = {2,2,4,3};
        int m = 6;
        System.out.println(new AlgorithmOne().solution(d,m));
    }
}
