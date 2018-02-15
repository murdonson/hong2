package com.concurrency.chapter03.demo02.semaphore_access_multi_res;

public class Job implements Runnable
{

    private PrintQueue printQueue;

    public Job(PrintQueue printQueue)
    {
        this.printQueue=printQueue;
    }

    @Override
    public void run()
    {
        printQueue.printJob();
    }
}
