package algorithm.barkingdog.array;

public class Practice1 {

    public static void main(String[] args) {
        int[] arr = {1, 52, 48};
        int N = 3;
        System.out.println(new Practice1().func2(arr,N));
    }

    public int func2(int[] arr, int N){
        int[] tmp = new int[10000];
        for (int i = 0; i < N; i++){
            int a = 100 - arr[i];
            if (tmp[arr[i]] == 1)
                return 1;
            tmp[a] = 1;
        }
        return 0;
    }
}
