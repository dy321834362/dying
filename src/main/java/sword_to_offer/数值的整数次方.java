package sword_to_offer;

public class 数值的整数次方 {
    public double myPow(double x, int n) {
        if (x == 0)return 0;
        if (n == 0)return 1;
        double res = 1;
        if (n < 0) {
            x = 1/x;
            n = -n;
        }
        while (n != 1) {
            if ((n & 1) == 1)res *= x;
            x *= x;
            n = n >> 1;
        }
        return res*x;
    }
}
