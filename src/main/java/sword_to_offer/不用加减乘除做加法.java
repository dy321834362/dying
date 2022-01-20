package sword_to_offer;

public class 不用加减乘除做加法 {
    public int add(int a, int b) {
        if (b == 0)return a;
        int he = a ^ b;
        int jinwei = (a & b) << 1;
        while (jinwei != 0) {
            a = he;
            b = jinwei;
            he = a ^ b;
            jinwei = (b & a) << 1;
        }
        return he;
    }
}
