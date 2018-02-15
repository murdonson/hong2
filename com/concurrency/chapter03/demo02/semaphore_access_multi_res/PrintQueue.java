package com.concurrency.chapter03.demo02.semaphore_access_multi_res;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintQueue
{
    private Semaphore semaphore;

    private boolean freePrinters[];

    private Lock lockPrinters;

    private final SimpleDateFormat sdf=new SimpleDateFormat("mm:ss.SSS");

    public PrintQueue()
    {
        semaphore=new Semaphore(3);
        freePrinters=new boolean[3];
        for (int i = 0; i < freePrinters.length; i++)
        {
            freePrinters[i]=true;
        }
        lockPrinters=new ReentrantLock();
    }



    public void printJob()
    {
        String name=Thread.currentThread().getName();


        try
        {
            semaphore.acquire();
            System.out.println(name+"  获得信号量at "+sdf.format(new Date()));

            int workingPrinter=getPrinter();

            int duration= (int) (Math.random()*15000+8000);

            System.out.printf("%s: Printer print a job in printer %d during %d seconds\r\n",
                    name,workingPrinter,duration/1000);
            TimeUnit.SECONDS.sleep(duration/1000);

            freePrinters[workingPrinter]=true;

        } catch (InterruptedException e)
        {
            e.printStackTrace();

        }
        finally
        {
            System.out.println(name+"  释放信号量 at "+sdf.format(new Date())+"\r\n");
            semaphore.release();
        }
    }

    private int getPrinter()
    {
        int ret=-1;
        try
        {
            lockPrinters.lock();
            for (int i = 0; i < freePrinters.length; i++)
            {
                if(freePrinters[i])
                {
                    ret=i;
                    freePrinters[i]=false;
                    break;
                }
            }

        } catch (Exception e)
        {
            e.printStackTrace();
        } finally
        {
            lockPrinters.unlock();
        }

        return ret;

    }


}
