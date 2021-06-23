package algorithm.boostcamp;

import java.util.*;

public class Question6 {
    private int[] arr;
    private List<Integer> list;
    public void setArr(int[] arr) {
        this.arr = arr;
    }
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 3, 3, 3, 4, 4};
        int[] arr2 = {3, 2, 4, 4, 2, 5, 2, 5, 5};
        int[] arr3 = {3, 5, 7, 9, 1};
        Question6 q1 = new Question6();
        System.out.println(q1.solution(arr1));
        Question6 q2 = new Question6();
        System.out.println(q2.solution(arr2));
        Question6 q3 = new Question6();
        System.out.println(q3.solution(arr3));

    }
    /**
     * HashMap을 이용한 방법
     * @param arr
     * @return
     */
    public List<Integer> solution(int[] arr){
        List<Integer> answer = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int a : arr){
            if (map.get(a) != null){
                int tmp = map.get(a);
                map.put(a, ++tmp);
            }else {
                map.put(a, 1);
            }
        }

        for (int key : map.keySet()){
            if (map.get(key) > 1){
                answer.add(map.get(key));
            }
        }

        if (answer.size() == 0){
            answer.add(-1);
        }

        return answer;
    }

    /**
     * Set을 직접 구현하는 방법 (Hash 를 활용하면 더 좋을겁니다)
     * @return
     */
    public List<Integer> solutionSet() {
        list = set();
        List<Integer> answer = new ArrayList<>();
        int n = arr.length;
        int listN = list.size();
        for (int i = 0; i < listN; i++){
            int cnt = 0;
            for (int j = 0; j < n; j++){
                if (list.get(i) == arr[j]) {
                    cnt++;
                }
            }
            if (cnt > 1) {
                answer.add(cnt);
            }
        }

        if (answer.size() == 0) answer.add(-1);

        return answer;
    }
    public boolean contains(int element){
        return (indexOf(element) != -1) ? true : false;
    }

    public int indexOf(int element){
        int n = list.size();
        for (int i = 0; i < n; i++){
            if (list.get(i) == element){
                return element;
            }
        }
        return -1;
    }

    public List<Integer> set(){
        int n = arr.length;
        list = new ArrayList<>(n);
        for (int i = 0; i < n; i ++){
            if(!contains(arr[i])) list.add(arr[i]);
        }
        return list;
    }
}
