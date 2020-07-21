package com.example.quicksmart;

import android.location.Location;

import java.util.ArrayList;

public class TripPlanner {

    private Location currentLocation;
    private Location selectedDestination;

    public static Transportation[] getTransportationOptions(int[] preferences){

        ArrayList<Transportation> options = new ArrayList<Transportation>();

        for(int i = 0; i < preferences.length; i++){

            switch(preferences[i]){

                default:
                    options.add(new Transportation(-1,
                            "your guess is as good as mine",
                            "",
                            "",
                            "",
                            ""));
                    break;

            }

        }

        return (Transportation[]) options.toArray();

    }

    private int calculateMostEnjoyable(){

        return 0;

    }

    private int calculateFastest(){

        return 0;

    }

    private int calculateCheapest(){

        /* if the user is within walking distance, and is able to
           do so, tell them to walk. */

        return 0;

    }

    private int calculateSafest(){

        return 0;

    }

}
