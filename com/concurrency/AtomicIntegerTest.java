package com.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest
{
    //private static volatile int value=0;
    private static AtomicInteger value=new AtomicInteger(0);
    public static void main(String[] args)
    {
        ExecutorService executorService = Executors.newFixedThreadPool(100);

        for (int i = 0; i < 100; i++)
        {
            executorService.submit(new Runnable()
            {
                @Override
                public void run()
                {
                    int i=0;
                    for (int i1 = 0; i1 < 100; i1++)
                    {
                        //value++;
                        i= value.getAndIncrement();

                    }
                    System.out.println(Thread.currentThread().getName()+"  "+i+" :::"+value);

                }
            });
        }

        executorService.shutdown();

    }





}




