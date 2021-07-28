package algorithm.inflearn.sortAndSearching;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Point implements Comparable<Point>{
    int x,y;
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point o) {
        if (x == o.x) return this.y - o.y;
        return this.x - o.x;
    }
}

public class 좌표정렬 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < n; i++){
            points.add(new Point(sc.nextInt(),sc.nextInt()));
        }
        Collections.sort(points);
        for (Point p : points){
            System.out.println(p.x + " " + p.y);
        }
    }
}
