package com.concurrency.callable_future;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class Main
{

    public static void main(String[] args)
    {
        ThreadPoolExecutor threadPool = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);

        List<Future<Integer>> resultlist=new ArrayList<>();

        Random random=new Random();

        for (int i = 0; i < 10; i++)
        {
            int number = random.nextInt(10);
            FactorialCalculator factorialCalculator=new FactorialCalculator(number);
            Future<Integer> result = threadPool.submit(factorialCalculator);
            resultlist.add(result);
        }



        // ����future����߳�״̬ ��ع����Ƿ����

        // �����������û���  ��ѭ����ӡÿ����������״��
        while(threadPool.getCompletedTaskCount()<resultlist.size())
        {
            System.out.println("Main Number of completed tasks "+threadPool.getCompletedTaskCount());

            //  ��ѭ����ӡÿ����������״��
            for (int i = 0; i < resultlist.size(); i++)
            {
                Future<Integer> future = resultlist.get(i);
                System.out.println("task "+i+"  "+future.isDone());
            }

            try
            {
                Thread.sleep(300);
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }

        }

        System.out.println("���������Ѿ���ɣ�������ȡ�ý��");


        for (int i = 0; i < resultlist.size(); i++)
        {
            Future<Integer> future = resultlist.get(i);
            Integer number=null;

            try
            {
                number=future.get();
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            } catch (ExecutionException e)
            {
                e.printStackTrace();
            }

            System.out.println("core task "+i+"  result:"+number);


        }

        threadPool.shutdown();
    }
}
