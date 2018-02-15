package com.concurrency.chapter03.demo02.semaphore_access_multi_res;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main
{
    public static void main(String[] args)
    {
        PrintQueue printQueue=new PrintQueue();

        ExecutorService threadPool = Executors.newFixedThreadPool(12);

        for (int i = 0; i < 12; i++)
        {
            threadPool.submit(new Job(printQueue));
        }

        threadPool.shutdown();
    }
}
