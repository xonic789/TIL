package dataStructure;

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
                return element;
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

}
