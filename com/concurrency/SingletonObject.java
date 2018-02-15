package com.concurrency;

/**
 *  ��̬�ڲ���ʵ�ֵ���ģʽ
 */
public class SingletonObject
{
    private SingletonObject(){}

    private static class InstanceHolder
    {
        private static final SingletonObject intance=new SingletonObject();
    }

    // �����������ʱ�Żᴥ�� ��̬�ڲ���ļ��� ��ʼ��  jvm����ػ��Ʊ�֤���ʱ���ǵ��̵߳� ����������������
    public static SingletonObject getInstance()
    {
        return InstanceHolder.intance;
    }
}
