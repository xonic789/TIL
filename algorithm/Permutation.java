package algorithm;

public class Permutation {

    void permutation(char[] array, int k, int n){
        if (k == n){
            for (char a : array){
                System.out.print(a + " ");
            }
            System.out.println();
            return;
        }
        for (int i = k; i < n; i++){
            swap(array, k, i);
            // 현재 k를
            permutation(array, k + 1, n);
            swap(array, k, i);
        }
    }

    void swap(char[] array, int x, int y){
        char tmp = array[x];
        array[x] = array[y];
        array[y] = tmp;
    }

    public static void main(String[] args) {
        Permutation permutation = new Permutation();
        char[] array = {'a','b','c','d'};

        permutation.permutation(array,0,4);
    }
}
