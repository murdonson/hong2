package com.designpattern.factorymethod;

public class Client
{
    public static void main(String[] args)
    {
        Car car = new AudiFactory().getCar();
        car.run();
        Car car1 = new BydFactory().getCar();
        car1.run();

    }
}
