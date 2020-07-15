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

    public static String[] getTimes(){

        return times;

    }

    public static String getTimesString(){

        String timeString = "";

        for(int i = 0; i < times.length; i++){

            timeString = timeString + times[i];

            if((i+1) == times.length){

                timeString = timeString + " ";

            }else{

                timeString = timeString + ", ";

            }

        }

        return timeString;

    }

}
