package com.dai;

import javax.imageio.metadata.IIOMetadataFormatImpl;
import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.*;

public class Test1 {
    static int count = 0;

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService e = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            int finalI = i;
            FutureTask<String> ft = new FutureTask<String>(() -> {
                for (int j = 0; j < 1000; j++) {
                    System.out.println(Thread.currentThread().getName() + "--" + j);
                }
                return String.valueOf(finalI);
            });
            Future<?> submit = e.submit(ft);
//            System.out.println(submit.get()+"------"+Thread.currentThread().getName());
            if (submit.isDone()) {
                count++;
            }
        }
        Thread.sleep(1000);
        System.out.println(count);

    }



}
