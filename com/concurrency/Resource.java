package com.concurrency;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;

/**
 *  ʹ�� wait notifyAll �������� ������ ģʽ
 */
public class Resource
{
    private int numbers=0;
    private boolean flag=false;


    public synchronized void create()
    {
        while(flag)
        {
            try
            {
                this.wait();
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }

        numbers++;
        System.out.println(Thread.currentThread().getName()+" ������ "+numbers);
        flag=true;
        notifyAll();

    }




    public synchronized void destroy()
    {
        while(!flag)
        {
            try
            {
                wait();
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }

        numbers--;
        System.out.println(Thread.currentThread().getName()+"������"+numbers);
        flag=false;
        notifyAll();
    }


    public static void main(String[] args)
    {

        Resource resource=new Resource();
        Producer producer=new Producer(resource);
        Consumer consumer=new Consumer(resource);

        new Thread(producer).start();
        new Thread(producer).start();
        new Thread(consumer).start();
        new Thread(consumer).start();

    }

}

class Producer implements Runnable
{
    private Resource resource;

    public Producer(Resource resource) {
        this.resource = resource;
    }


    @Override
    public void run()
    {
        while(true)
        {
            try
            {
                Thread.sleep(1000);
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }

            resource.create();
        }
    }
}


class Consumer implements Runnable
{
    private Resource resource;

    public Consumer(Resource resource) {
        this.resource = resource;
    }
    @Override
    public void run()
    {
        while (true)
        {
            try
            {
                Thread.sleep(1000);
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            resource.destroy();


        }
    }
}
