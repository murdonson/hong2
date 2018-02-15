package com.concurrency.callable_future;

import java.util.concurrent.Callable;

public class FactorialCalculator implements Callable<Integer>
{

    private Integer number;

    public FactorialCalculator(Integer number)
    {
        this.number = number;
    }

    @Override
    public Integer call() throws Exception
    {
        int result=1;
        if(number<=1) return number;
        for(int i=2;i<=number;i++)
        {
            result*=i;
            Thread.sleep(50);
        }
        System.out.println(Thread.currentThread().getName()+"   number:"+number);
        return result;
    }


}
