package com.designpattern.abstractFactory;

public class CheapCarFactory implements  CarFactory
{
    @Override
    public Engine createEngine()
    {
        return new CheapEngine();
    }

    @Override
    public Seat createSeat()
    {
        return new CheapSeat();
    }
}
