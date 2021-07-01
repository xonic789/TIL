package algorithm.inflearn.hash;

import java.util.*;
public class 매출액의종류 {
    public static List<Integer> solution(int[] arr, int n, int k){
        List<Integer> answer = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        // 미리 값을 k - 1 까지 넣어준다.
        // k - 1 부터 for 문을 시작하며 하나씩 rt를 늘리기 때문에
        // 미리 넣어줘야 한다.
        for (int i = 0; i < k - 1; i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        // 슬라이딩 윈도우 + 투 포인터스 알고리즘.
        int lt = 0;
        for (int rt = k - 1; rt < n; rt++){
            // k - 1 전까지 map 에 있기 때문에
            // k - 1 부터 참조하게 된다.
            map.put(arr[rt], map.getOrDefault(arr[rt], 0) + 1);
            // rt를 k - 1 전까지 수행하였기 때문에
            // map 에 넣고 바로 map 의 사이즈 answer add
            answer.add(map.size());
            // lt는 무조건 존재하기 때문에 arr[lt] 를 갱신하며
            // 참조한 value 의 - 1 을 해준다.
            // -1 을 해주는 이유는 윈도우가 옮겨가야하기 때문에.
            map.put(arr[lt], map.get(arr[lt]) - 1);
            // 갱신하였는데, lt 의 value 가 0이라면 제거해야함.
            if (map.get(arr[lt]) == 0){
                map.remove(arr[lt]);
            }
            lt++;
        }

        return answer;
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        } 

        for (int kinds : 매출액의종류.solution(arr,n,k)){
            System.out.print(kinds + " ");
        }

        return ;
    }
}
