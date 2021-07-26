package algorithm.inflearn.sortAndSearching;

import java.util.Arrays;
import java.util.Scanner;

public class 뮤직비디오 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(new 뮤직비디오().solution(n,m,arr));
    }

    public int count(int[] arr, int capacity){

        //DVD 첫번째장
        int cnt = 1, sum = 0;
        for (int x : arr){
            // sum 에 곡 길이를 더했더니, 용량보다 크다!
            // 그럼 다음 장으로 넘어가야 한다.
            if (sum + x > capacity){
                cnt++;
                // DVD 다음장으로 넘기고, sum 은 더 했을때 capacity 가 초과된
                // 경우 이므로, 해당 곡을 sum 에 넣어 리셋시킨다.
                sum=x;
            }
            // 그렇지 않을 경우 사용하고 있는 DVD 에 담을 수 있으므로
            // 곡 길이를 sum 에 누적한다.
            else sum += x;
        }
        return cnt;
    }

    public int solution(int n, int m, int[] arr) {
        int answer = 0;
        //반복자, 리덕션
        int lt = Arrays.stream(arr).max().getAsInt();
        int rt = Arrays.stream(arr).sum();
        // 이분검색을 취한다.
        // lt는 해당 배열의 max 값부터
        // rt는 모든 값을 더 했을 때.
        while(lt <= rt){
            // DVD 용량
            int mid = (lt+rt)/2;
            if (count(arr, mid) <= m){
                answer = mid;
                // 좁힘
                rt = mid - 1;
                //
            }else lt = mid + 1;

        }

        return answer;
    }
}
