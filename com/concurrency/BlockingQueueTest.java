package com.concurrency;

import com.sun.xml.internal.bind.v2.model.annotation.RuntimeAnnotationReader;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * ʹ�� blockingqueue �������� ������
 */
public class BlockingQueueTest
{
    final static BlockingQueue bq=new ArrayBlockingQueue(2);

    public static void main(String[] args)
    {
        MyProducer myProducer=new MyProducer(bq);
        MyConsumer myConsumer=new MyConsumer(bq);

        new Thread(myProducer).start();
        new Thread(myProducer).start();
        new Thread(myConsumer).start();
        new Thread(myConsumer).start();
    }


}


class MyProducer implements Runnable
{
    private BlockingQueue bq;
    AtomicInteger i=new AtomicInteger(0);
    public MyProducer(BlockingQueue bq)
    {
        this.bq=bq;
    }

    @Override
    public void run()
    {
        while(true)
        {
            try
            {



                System.out.println(Thread.currentThread().getName()+"������"+i.addAndGet(1));
                Thread.sleep(1000);

                bq.put(i);
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
}


class MyConsumer implements Runnable
{
    private BlockingQueue bq;

    public MyConsumer(BlockingQueue bq)
    {
        this.bq=bq;
    }
    @Override
    public void run()
    {
        while(true)
        {
            try
            {
                AtomicInteger e= (AtomicInteger) bq.take();
                System.out.println(Thread.currentThread().getName()+"������"+e.get());
                Thread.sleep(1000);
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
}
