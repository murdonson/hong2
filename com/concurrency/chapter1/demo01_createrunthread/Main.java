package com.concurrency.chapter1.demo01_createrunthread;

/**
 *  ���̴߳�ӡ�˷���
 */
public class Main
{
    public static void main(String[] args) throws InterruptedException
    {
        for (int i = 1; i <=9; i++)
        {
            Calculator calculator=new Calculator(i);
            new Thread(calculator).start();
            Thread.sleep(1000);
        }
    }
}
