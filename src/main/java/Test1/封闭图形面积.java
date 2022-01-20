package Test1;

import java.util.Scanner;

public class 封闭图形面积 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < k; i++) {
            String[] str = sc.nextLine().split(" ");
            double a = Double.parseDouble(str[0]);
            double b = Double.parseDouble(str[1]);
            double c = Double.parseDouble(str[2]);
            if (a <= 2*b*c) {
                System.out.println(0);
            } else {
                double y1 = a/b + Math.sqrt(a*a-2*a*b*c)/b;
                double y2 = a/b - Math.sqrt(a*a-2*a*b*c)/b;
                System.out.println(getResult(a,b,c,y1)-getResult(a,b,c,y2));
            }

        }

    }

    private static double getResult(double a,double b,double c, double y) {
        return -c*y/b + Math.pow(y,2)/(2*b) - Math.pow(y,3)/(6*a);
    }
}
