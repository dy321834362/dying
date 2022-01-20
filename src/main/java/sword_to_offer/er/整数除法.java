package sword_to_offer.er;

public class 整数除法 {
    public static int divide(int a, int b) {
        if (a == Integer.MIN_VALUE && b == -1)
            return Integer.MAX_VALUE;
        boolean bo = true;
        if (a>0 && b<0 || a<0&&b>0){
            bo = false;
        }
        if (a == 0)return 0;
        a = a>0 ? -a :a;
        b = b>0 ? -b :b;
        int count = 0;
        int tmp = b;
        int t = 1;
        while (a <= b) {
            while (a <= tmp) {
                a = a - tmp;
                count += t;
                if (tmp < Integer.MIN_VALUE - tmp) break;
                tmp = tmp + tmp;
                t += t;
            }
            tmp = b;
            t = 1;
        }
        return bo ? count : -count;
    }

    public static void main(String[] args) {
        int divide = divide(1100540749, -1090366779);
        System.out.println(divide);
    }
}
