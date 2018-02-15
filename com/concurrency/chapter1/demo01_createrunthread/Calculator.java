package com.concurrency.chapter1.demo01_createrunthread;

public class Calculator implements Runnable
{
    private int number;

    public Calculator(int number)
    {
        this.number=number;

    }

    @Override
    public void run()
    {
        synchronized (this){
            for (int i = 1; i <=9; i++)
            {
                System.out.printf("%s:%d * %d = %d\n",Thread.currentThread().getName(),number,i,number*i);
            }

    }

    }
}
