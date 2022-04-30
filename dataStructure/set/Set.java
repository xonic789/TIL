package datastructure.set;

/**
 * 기본적인 집합 자료구조 입니다.
 */
public class Set  {
    private int max;
    private int[] set;
    private int num;


    public Set(int[] array){
        this(array.length);
        for (int i = num; i < max; i++){
           if (!contains(array[i])){
               set[num] = array[i];
               num++;
           }
        }
    }

    public Set(int capacity){
        max = capacity;
        num = 0;
        try {
            set = new int[max];
        }catch (OutOfMemoryError e){
            max = 0;
        }
    }

    // default size is 10
    public Set(){
        max = 10;
        num = 0;
        try {
            set = new int[max];
        }catch (OutOfMemoryError e){
            max = 0;
        }
    }

    public boolean add(int element){
        if (num + 1 == max){
            copyArray();
        }
        if (!contains(element)){
            set[num++] = element;
            return true;
        }
        return false;
    }

    /**
     * remove 는 element 가 set[num - 1] 안에 포함되어 있다면 삭제하는 메서드이기 때문에
     * 해당 element 가 num - 1 부분 즉 끝 부분일 경우와 끝 부분이 아닐 경우로 나뉜다.
     * 왜냐하면 배열의 깊은 복사가 이루어져야 하는데,
     * 해당 element 를 제외하고 복사해야하기 때문이다.
     * 내가 생각하는 방법은
     * 1. 끝 부분이 아닐 경우 element Index 의 바로 다음 인덱스부터 tmp 배열에 넣는다.
     * 2. 끝 부분일 경우 해당 index 를 0으로 초기화 하고, num--를 해준다.
     * @param element
     * @return
     */
    public boolean remove(int element){
        // max size == 0
        if (max == 0) return false;

        if (!contains(element)) return false;

        int index = indexOf(element);
        // num 은 set 의 크기이기 때문이다.
        if (index + 1 < num){
            int[] tmp = new int[max];
            int pt = 0;
            for (int i = 0; i < num; i++){
                if (index == i) tmp[i] = set[++pt];
                else tmp[i] = set[pt];
                pt++;
            }
            num--;
            set = tmp;
        // num 과 같은 경우
        }else {
            set[index] = 0;
            num--;
        }

        return true;
    }

    public void copyArray(){
        max *= 2;
        int[] tmp = new int[max];
        for (int i = 0; i < max; i++){
            tmp[i] = set[i];
        }
        set = tmp;
    }

    public boolean contains(int element){
        return (indexOf(element) != -1) ? true : false;
    }

    public int indexOf(int element){
        for (int i = 0; i < num; i++){
            if (set[i] == element){
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < num; i++){
            sb.append(set[i] + ",");
        }
        String string = sb.substring(0,sb.length()-1);
        string += "]";
        return string;

    }

    public int getNum() {
        return num;
    }
}
