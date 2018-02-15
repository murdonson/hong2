package com.concurrency.chapter1.demo03_interrupt;

import java.util.concurrent.TimeUnit;

public class Main
{
    public static void main(String[] args)
    {
        Thread thread=new PrimeGenerator();
        thread.start();

        try
        {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        thread.interrupt();
        try
        {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        System.out.println(thread.getState());

    }
}
