package com.designpattern.abstractFactory;

public class Client
{
    public static void main(String[] args)
    {
        Engine engine = new LuxuryCarFactory().createEngine();
        Seat seat = new LuxuryCarFactory().createSeat();
        engine.run();
        seat.message();
    }
}
