package com.designpattern.abstractFactory;

import com.designpattern.factorymethod.Car;

public class LuxuryCarFactory implements CarFactory
{
    @Override
    public Engine createEngine()
    {
        return new LuxuryEngine();
    }

    @Override
    public Seat createSeat()
    {
        return new LuxurySeat();
    }
}
