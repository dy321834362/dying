package sword_to_offer.er;

import java.util.ArrayList;

public class 深拷贝 {
    public static void main(String[] args) throws CloneNotSupportedException {
        ArrayList<Object> objects = new ArrayList<>();
        Class<Object[]> newType = Object[].class;
        boolean b = (Object)newType == (Object)Object[].class;
        new 深拷贝().test();
    }
    public void test() throws CloneNotSupportedException {
        T t = new T(1);
        T clone = t.clone();
        t.arr[0] = 5;
        System.out.println(t.id +"-----" + clone.id);
        System.out.println(t.arr[0] +"-----"+ clone.arr[0]);
    }
}
class T implements Cloneable{
    int id ;
    int[] arr = new int[3];

    public T (int id) {
        this.id = id;
    }

    public T clone() throws CloneNotSupportedException {
        T t = (T) super.clone();
        t.arr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            t.arr[i] = arr[i];
        }
        return t;
    }
}
