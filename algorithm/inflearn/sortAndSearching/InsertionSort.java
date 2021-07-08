package algorithm.inflearn.sortAndSearching;

public class InsertionSort {

    public int[] sort(int[] arr, int n){

        for (int i = 1; i < n; i++){
            // 자기 자리 찾기 위해
            int tmp = arr[i];
            int j;
            for (j = i - 1; j >= 0; j--){
                // 뒤로 밀려야함 tmp가
                if (arr[j] > tmp)arr[j + 1] = arr[j];
                else break;
            }
            arr[j + 1] = tmp;
        }
        return arr;
    }


}
