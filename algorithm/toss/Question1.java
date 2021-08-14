package algorithm.toss;

public class Question1 {
    public long solution(long orderAmount, long taxFreeAmount, long serviceFee) {
        // orderAmount : 주문금액
        // taxFreeAmount : 비과세금액
        // serviceFee : 봉사료
        long answer = 0;
        long supplyPrice = orderAmount - taxFreeAmount - serviceFee;
        if (supplyPrice == 1) return 0;


        return (long)Math.ceil(supplyPrice * 0.1);
    }
    public static void main(String[] args) {
        System.out.println(new Question1().solution(120,0,10));
    }
}
