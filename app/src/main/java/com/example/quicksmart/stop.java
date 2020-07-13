package com.example.quicksmart;

public class stop {

    private static String name;
    private static String[] times;

    public stop(String name, String[] times){

        this.name = name;
        this.times = times;

    }

    public static String getName(){

        return name;

    }

}
