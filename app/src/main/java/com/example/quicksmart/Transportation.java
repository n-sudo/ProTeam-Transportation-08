package com.example.quicksmart;

public class Transportation {

    private int transCode;
    private String name;
    private String departure;
    private String departLocation;
    private String arrival;
    private String arrivalLocation;
    private String travelTime;

    public Transportation(int tc, String name, String dep, String depLoc, String arr, String arrLoc){

        this.transCode = tc;
        this.name = name;
        this.departure = dep;
        this.departLocation = depLoc;
        this.arrival = arr;
        this.arrivalLocation = arrLoc;

    }

    public String getName(){

        return name;

    }

    public String getDeparture(){

        return departure;

    }

    public String getDepartLocation() {

        return departLocation;

    }

    public String getArrival(){

        return arrival;

    }

    public String getArrivalLocation(){

        return arrivalLocation;

    }

    public String getTravelTime(){


        return travelTime;

    }

    private int estimateTravelTime(){


        return 0;

    }


}
