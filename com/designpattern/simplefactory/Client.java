package com.designpattern.simplefactory;

public class Client
{
    public static void main(String[] args)
    {
        Car aodi = CarFactory.getCar("aodi");
        aodi.run();
    }
}
