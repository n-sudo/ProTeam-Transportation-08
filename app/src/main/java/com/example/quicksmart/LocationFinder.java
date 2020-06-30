package com.example.quicksmart;

import android.location.Location;
import android.location.LocationManager;
import android.location.LocationListener;
import android.content.Intent;

/* 
 * Description:
 * the purpose of this class is to monitor geographical location data
 * for the user. The idea behind this feature is to eliminate the need to specify
 * a starting point manually (although this option should still be available).
 * 
 * Notes: 
 *  - this feature will make asking for location permission necessary. more details
 *    here: https://developers.google.com/maps/documentation/android-sdk/current-place-tutorial  
 */

public class LocationFinder{

    protected void onCreate(){
        
        super.onCreate(savedInstanceState); 
        setContentView(R.layout.activity_main); 

    }

    

}
