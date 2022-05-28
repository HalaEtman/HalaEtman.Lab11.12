package com.company;

enum ShapeType{
    Square, Rectangle, Circle, Trapezium, Rhombus, Triangle, Oval, Hexagon
}

public class ShowEnum {
    public static void main(String[] args) {
        for (ShapeType ST : ShapeType.values())
            System.out.println(ST + " order value " + ST.ordinal());
    }
}