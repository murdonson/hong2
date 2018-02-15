package com.designpattern.abstractFactory;

public interface Seat
{
    void message();
}

class LuxurySeat implements Seat
{
    @Override
    public void message()
    {
        System.out.println("�����Զ���Ħ");
    }
}


class CheapSeat implements Seat{
    @Override
    public void message()
    {
        System.out.println("�����Զ���Ħ");
    }
}