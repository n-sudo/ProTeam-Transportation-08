package com.example.quicksmart;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.libraries.places.api.model.Place;
import com.google.gson.JsonObject;

import org.json.JSONObject;

public class PlaceFinder {

    private static Place[][] hardcoded = new Place[3][];;

    private static void init(){

        // generate list of bike-share docks
        hardcoded[3] = new Place[4];
        hardcoded[3][1] = Place.builder().setId("1").setName("Monument Circle").setAddress("121 Monument Circle Indianapolis, IN 46201").setLatLng(new LatLng(39.769030, -86.157460)).build();
        hardcoded[3][2] = Place.builder().setId("2").setName("Washington and Meridian").setAddress("2 W. Washington St. Indianapolis, IN 46204").setLatLng(new LatLng(39.767420, -86.158560)).build();
        hardcoded[3][3] = Place.builder().setId("3").setName("Washington and Capitol").setAddress("101 W. Washington St. Indianapolis, IN 46204").setLatLng(new LatLng(39.766580, -86.160420)).build();
        hardcoded[3][4] = Place.builder().setId("4").setName("Ohio St. and Meridian").setAddress("4 E Ohio St. Indianapolis, IN 46204").setLatLng(new LatLng(39.769940, -86.157890)).build();

    }

    /** @Brief gets stop locations for a given mode of transportation
     * @note 1 for bus, 2 for train, 3 for bike-share
     * @param transCode corresponds to the type of transportation requested
     */
    public static Place[] getPlaces(int transCode)
    {

        init();

        Place[] places;

        switch(transCode)
        {

            case 1:
                // buses
                places = hardcoded[1];
                ;

            case 2:
                // trains
                places = hardcoded[2];
                ;

            case 3:
                places = hardcoded[3];
                // bike-share
                ;

            default:
                places = null;
                // do stuff
                ;

        }

        return places;

    }

    /** @brief gets data for a given mode of transportation from an online API
     * @note 1 for bus, 2 for train, 3 for bike-share
     * @param transCode the mode of transportation requested
     * @return a list of places for the given mode of transportation
     */
    private JSONObject getData(int transCode)
    {

        JSONObject data = null;

        // TODO add api functionality

        /* NOTE: this is not really necessary at this stage, but it would be necessary if we were
         * actually pulling data from an online API
         */

        return data;

    }

    /** @brief extracts information related to places from an api.
     * @note this parser looks for address and place name information exclusively.
     * @param input the json-formatted data to parse.
     */
    private void parseJSON(JsonObject input)
    {

        // code later

    }

}