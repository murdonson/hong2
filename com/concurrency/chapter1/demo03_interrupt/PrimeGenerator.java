package com.concurrency.chapter1.demo03_interrupt;

public class PrimeGenerator extends Thread
{
    @Override
    public void run()
    {
        int number=1;
        while(true)
        {
            if(isPrime(number))
            {
                System.out.printf("Number %d is prime\n",number);
            }

            if(isInterrupted())
            {
                System.out.println("interrupt");
                return;
            }
            try
            {
                Thread.sleep(1000);
            } catch (InterruptedException e)
            {
                e.printStackTrace();
                return;
            }
            number++;
        }
    }

    private boolean isPrime(int number)
    {
        if(number<=2) return false;

        for(int i=2;i<number;i++)
        {
            if(number%2==0)
            {
                return false;
            }
        }
        return true;
    }
}
