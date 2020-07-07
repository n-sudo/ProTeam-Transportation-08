package com.example.quicksmart;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.libraries.places.api.model.Place;
import com.google.gson.JsonObject;

import org.json.JSONObject;

public class PlaceFinder {

    private static Place[][] hardcoded = new Place[3][];;

    public PlaceFinder(){

        // generate list of bike-share docks
        hardcoded[2] = new Place[4];


    }

    /** @Brief gets stop locations for a given mode of transportation
     * @note 1 for bus, 2 for train, 3 for bike-share
     * @param transCode corresponds to the type of transportation requested
     */
    public static Place[] getPlaces(int transCode)
    {

        Place[] places;

        switch(transCode)
        {

            case 1: // bus stops
                places = new Place[4];
                places[0] = Place.builder().setName("Ohio St & Pennsylvania St ").setAddress("Ohio St & Pennsylvania St Indianapolis, IN 46201").setLatLng(new LatLng(39.769863, -86.156164)).build();
                places[1] = Place.builder().setName("Downtown Transit Center").setAddress("Downtown Transit Center Indianapolis, IN 46204").setLatLng(new LatLng(39.766509, -86.153565)).build();
                places[2] = Place.builder().setName("Delaware St & Market St").setAddress("Delaware St & Market St Indianapolis, IN 46204").setLatLng(new LatLng(39.768438, -86.154420)).build();
                places[3] = Place.builder().setName("Ohio St & Illinois St").setAddress("4 E Ohio St. Indianapolis, IN 46204").setLatLng(new LatLng(39.769951, -86.159813)).build();
                break;

            case 2: // train stations
                places = new Place[1];
                places[0] = Place.builder().setName("Downtown Train Station").setAddress("350 South Illinois Street Indianapolis, IN 46225-1198").setLatLng(new LatLng(39.762092, -86.160517)).build();
                break;

            case 3: // bike-share docks
                places = new Place[4];
                places[0] = Place.builder().setName("Monument Circle").setAddress("121 Monument Circle Indianapolis, IN 46201").setLatLng(new LatLng(39.769030, -86.157460)).build();
                places[1] = Place.builder().setName("Washington and Meridian").setAddress("2 W. Washington St. Indianapolis, IN 46204").setLatLng(new LatLng(39.767420, -86.158560)).build();
                places[2] = Place.builder().setName("Washington and Capitol").setAddress("101 W. Washington St. Indianapolis, IN 46204").setLatLng(new LatLng(39.766580, -86.160420)).build();
                places[3] = Place.builder().setName("Ohio St. and Meridian").setAddress("4 E Ohio St. Indianapolis, IN 46204").setLatLng(new LatLng(39.769940, -86.157890)).build();
                break;

            default:
                places = null;
                break;

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