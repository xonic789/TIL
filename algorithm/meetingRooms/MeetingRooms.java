package algorithm.meetingRooms;
   
import java.util.Arrays;
import java.util.Comparator;

class Interval{
    int start;
    int end;
    Interval(){
        this.start = 0;
        this.end =0;
    }
    Interval(int s, int e){
        this.start = s;
        this.end = e;
    }
}
public class MeetingRooms {

    public static void main(String[] args){
        MeetingRooms a = new MeetingRooms();

        Interval in1 = new Interval(15,20);
        Interval in2 = new Interval(5,10);
        Interval in3 = new Interval(0,30);

        Interval[] intervals = {in1,in2,in3};
        System.out.println(a.solve(intervals));

    }

    public boolean solve(Interval[] intervals) {
        //1
        if(intervals == null){
            return false;
        }
        print(intervals);
        Arrays.sort(intervals, comp);
        System.out.println("=========================");
        print(intervals);

        //2
        for(int i=1; i<intervals.length; i++){
            if(intervals[i-1].end > intervals[i].start){
                return false;
            }
        }
        return true;
    }

    Comparator<Interval> comp = new Comparator<Interval>() {
        @Override
        public int compare(Interval o1, Interval o2) {
            return o1.start - o2.start;
        }
    };

    public void print(Interval[] intervals){
        for (Interval interval : intervals) {
            System.out.println(interval.start + " " + interval.end);
        }
    }
}
