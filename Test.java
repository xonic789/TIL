import java.util.*;
public class Test {

    static void Solution(int num, String str){
        str = str+" 0";
        String[] students = str.split(" ");
        int cnt = 1;
        for (int i = 1; i < num; i++) {
            if(Integer.parseInt(students[i]) < Integer.parseInt(students[i+1])){
                cnt++;
            }
        }
        System.out.println(cnt);

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.nextLine();
        String str = sc.nextLine();
        Solution(num,str);

    }

}
