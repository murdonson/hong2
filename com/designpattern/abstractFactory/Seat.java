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
        System.out.println("可以自动按摩");
    }
}


class CheapSeat implements Seat{
    @Override
    public void message()
    {
        System.out.println("不能自动按摩");
    }
}