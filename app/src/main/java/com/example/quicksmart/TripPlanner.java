package com.example.quicksmart;

import android.location.Location;

import com.google.maps.errors.ApiException;

import java.io.IOException;
import java.util.ArrayList;

public class TripPlanner {

    private Location currentLocation;
    private Location selectedDestination;

    private static ArrayList<String> options = new ArrayList<String>();

    public static String[] getTransportationOptions(int[] preferences){


        if(MainActivity.getDestination().contains("You haven't selected one yet.")){

            return new String[]{"you cannot continue unless you select a\n" +
                    "destination please go back to the home\n" +
                    "screen and select a destination using the search bar"};

        }

        ArrayList<String> options = new ArrayList<String>();

        for(int i = 0; i < preferences.length; i++){

            switch(preferences[i]){


                case 2:
                    options.add(calculateCheapest());
                    break;
                case 3:
                    calculateFastest();
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


    private static String calculateCheapest(){

        /* if the user is within walking distance, and is able to
           do so, tell them to walk. */

        return "Dude, just walk. It's not really that far\n" +
                "Cost: nothing\n" +
                "Benefits: exercise is good for you\n" +
                "Rating: pretty good\n";


    }


    private static void calculateFastest(){

        try {
            String[] optionStrings = MainActivity.getFastestBike();

            for(int i = 0; i < optionStrings.length; i++){

                options.add(new String(optionStrings[i]));

            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ApiException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private int calculateSafest(){

        return 0;

    }

}
