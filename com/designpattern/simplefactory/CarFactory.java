package com.designpattern.simplefactory;

public class CarFactory
{
    public static Car getCar(String type)
    {
        if(type.equals("aodi"))
        {
            return new Audi();
        }
        if(type.equals("byd"))
        {
            return new Byd();
        }
        return null;
    }
}
