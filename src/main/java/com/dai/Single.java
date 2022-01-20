package com.dai;


public class Single {
    private static Single single;

    private Single(){}
    public static Object object = new Object();
    public static Single getSingle() {
        if (single == null) {
            synchronized(object) {
                if (single == null) {
                    single = new Single();
                }
            }
        }
        return single;
    }

}
