package com.company;

enum colors{Red, Yellow, Green}

class TrafficLights {
    colors Tfc = colors.Red;

    public void changeColor(){
        switch (Tfc){
            case Red:
                Tfc = colors.Green;
                break;
            case Yellow:
                Tfc = colors.Red;
                break;
            case Green:
                Tfc = colors.Yellow;
                break;

        }
    }
    public String toString(){return "" + Tfc;}
}

public class TrafficLightColor {

    public static void main(String[] args) {
        TrafficLights T = new TrafficLights();
        for (int i = 0; i < 9; i++){
            System.out.println(T.toString());
            T.changeColor();
        }
    }
}