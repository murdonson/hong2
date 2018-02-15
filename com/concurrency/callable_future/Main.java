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



        // 利用future监控线程状态 监控工作是否完成

        // 如果所有任务没完成  就循环打印每个任务的完成状况
        while(threadPool.getCompletedTaskCount()<resultlist.size())
        {
            System.out.println("Main Number of completed tasks "+threadPool.getCompletedTaskCount());

            //  就循环打印每个任务的完成状况
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

        System.out.println("所有任务都已经完成，接下来取得结果");


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
