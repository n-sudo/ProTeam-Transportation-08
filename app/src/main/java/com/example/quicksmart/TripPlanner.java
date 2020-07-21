package com.example.quicksmart;

import android.location.Location;

import java.util.ArrayList;

public class TripPlanner {

    private Location currentLocation;
    private Location selectedDestination;

    public static String[] getTransportationOptions(int[] preferences){

        ArrayList<String> options = new ArrayList<String>();

        for(int i = 0; i < preferences.length; i++){

            switch(preferences[i]){

                case 2:
                    options.add("Dude, just walk. It's not really that far\n" +
                            "Cost: nothing\n" +
                            "Benefits: exercise is good for you\n" +
                            "Rating: pretty good\n");
                    break;
                default:
                    break;

            }

        }

        String[] transOpts = new String[options.size()];

        for(int i = 0; i < transOpts.length; i++){

            transOpts[i] = options.get(i);

        }

        return transOpts;

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
