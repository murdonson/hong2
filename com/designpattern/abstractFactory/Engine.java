package com.designpattern.abstractFactory;

import java.util.Map;

public interface Engine
{
    void run();
}

class LuxuryEngine implements Engine
{
    @Override
    public void run()
    {
        System.out.println("ת�Ŀ�");
    }
}

class CheapEngine implements Engine
{
    @Override
    public void run()
    {
        System.out.println("ת����");
    }
}
