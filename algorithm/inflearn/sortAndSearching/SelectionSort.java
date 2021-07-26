package algorithm.inflearn.sortAndSearching;

public class SelectionSort {

    public int[] sort(int[] arr){

        int n = arr.length;

        for (int i = 0; i < n; i++){
            int min = i;
            for (int j = i + 1; j < n; j++){
                if (arr[min] > arr[j]){
                    min = j;
                }
            }
            swap(arr,i,min);
        }
        return arr;
    }

    public void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {5,2,4,6,8,1,9};
        for (int a : new SelectionSort().sort(arr)){
            System.out.println(a + " ");
        }
    }
}
