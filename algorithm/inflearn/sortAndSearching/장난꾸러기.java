package algorithm.inflearn.sortAndSearching;


import java.util.*;
public class 장난꾸러기 {

    public int[] solution(int[] arr, int n){
        int[] answer = new int[2];
        int[] tmp = new int[n];
        for (int i = 0; i < n; i++){
            tmp[i] = arr[i];
        }
        Arrays.sort(arr);
        int p = 0;
        for (int i = 0; i < n; i++){
            if (tmp[i] != arr[i]){
                answer[p++] = i + 1;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        for (int a : new 장난꾸러기().solution(arr,n)){
            System.out.print(a + " ");
        }

    }
}
