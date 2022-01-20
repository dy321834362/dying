package sword_to_offer;

public class 求1_n的和 {
    public int sumNums(int n) {
        if (n == 0) return 0;
        return n + sumNums(n - 1);
    }
}
