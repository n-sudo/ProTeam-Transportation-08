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

        // places[] = Place.builder().setName("").setAddress("").setLatLng(new LatLng(,)).build();

        Place[] places;

        switch(transCode)
        {

            case 1: // bus stops (incomplete)
                places = new Place[30];
                places[0] = Place.builder().setName("Ohio St & Pennsylvania St ").setAddress("Ohio St & Pennsylvania St Indianapolis, IN 46201").setLatLng(new LatLng(39.769863, -86.156164)).build();
                places[1] = Place.builder().setName("Downtown Transit Center").setAddress("Downtown Transit Center Indianapolis, IN 46204").setLatLng(new LatLng(39.766509, -86.153565)).build();
                places[2] = Place.builder().setName("Delaware St & Market St").setAddress("Delaware St & Market St Indianapolis, IN 46204").setLatLng(new LatLng(39.768438, -86.154420)).build();
                places[3] = Place.builder().setName("Ohio St & Illinois St").setAddress("4 E Ohio St. Indianapolis, IN 46204").setLatLng(new LatLng(39.769951, -86.159813)).build();
                places[4] = Place.builder().setName("Crossroads").setAddress("Crossroads Indianapolis, IN 46225-1198").setLatLng(new LatLng(39.649492,-86.115290)).build();
                places[5] = Place.builder().setName("30th and Richardt").setAddress("30th and Richardt Indianapolis, IN 46225").setLatLng(new LatLng(39.811065,-86.036181)).build();
                places[6] = Place.builder().setName("Western Select").setAddress("Western Select Indianapolis, IN 46225").setLatLng(new LatLng(39.748383,-86.153562)).build();
                places[7] = Place.builder().setName("34th and Sherman").setAddress("34th and Sherman Indianapolis, IN 46225").setLatLng(new LatLng(39.818171,-86.102677)).build();
                places[8] = Place.builder().setName("30th and College").setAddress("30th and College Indianapolis, IN 46225").setLatLng(new LatLng(39.810365,-86.144925)).build();
                places[9] = Place.builder().setName("Central and 16th").setAddress("Central and 16th Indianapolis, IN 46225").setLatLng(new LatLng(39.788423,-86.149455)).build();
                places[10] = Place.builder().setName("Alabama and 16th").setAddress("Alabama and 16th Indianapolis, IN 46225").setLatLng(new LatLng(39.788430,-86.152205)).build();
                places[11] = Place.builder().setName("Sutherland and 30th").setAddress("Sutherland and 30th Indianapolis, IN 46225").setLatLng(new LatLng(39.810615,-86.141607)).build();
                places[12] = Place.builder().setName("Mickley and Rockville").setAddress("Mickley and Rockville Indianapolis, IN 46225").setLatLng(new LatLng(39.765037,-86.260135)).build();
                places[13] = Place.builder().setName("Michigan and Holt").setAddress("Michigan and Holt Indianapolis, IN 46225").setLatLng(new LatLng(39.773834,-86.228198)).build();
                places[14] = Place.builder().setName("Michigan and Belmont").setAddress("Michigan and Belmont Indianapolis, IN 46225").setLatLng(new LatLng(39.774686,-86.196934)).build();
                places[15] = Place.builder().setName("Michigan and University").setAddress("Michigan and University Indianapolis, IN 46225").setLatLng(new LatLng(39.774535,-86.175554)).build();
                places[16] = Place.builder().setName("New York and East").setAddress("New York and East Indianapolis, IN 46225").setLatLng(new LatLng(39.771110,-86.148858)).build();
                places[17] = Place.builder().setName("New York and Rural").setAddress("New York and Rural Indianapolis, IN 46225").setLatLng(new LatLng(39.771824,-86.116462)).build();
                places[18] = Place.builder().setName("Ellenberger Park").setAddress("Ellenberger Park Indianapolis, IN 46225").setLatLng(new LatLng(39.776544,-86.076669)).build();
                places[19] = Place.builder().setName("Comm. Hospital East").setAddress("Comm. Hospital East Indianapolis, IN 46225").setLatLng(new LatLng(39.741075,-86.158276)).build();
                places[20] = Place.builder().setName("Arlington and 21st").setAddress("Arlington and 21st Indianapolis, IN 46225").setLatLng(new LatLng(39.796291, -86.064418)).build();
                places[21] = Place.builder().setName("Staughton and Arlington").setAddress("Staughton and Arlington Indianapolis, IN 46225").setLatLng(new LatLng(39.842256,-86.065112)).build();
                places[22] = Place.builder().setName("Ivy Tech Lawrence").setAddress("Ivy Tech Lawrence Indianapolis, IN 46225").setLatLng(new LatLng(39.741075,-86.158276)).build();
                places[23] = Place.builder().setName("Finance Center South").setAddress("Finance Center South Indianapolis, IN 46225").setLatLng(new LatLng(39.759203,-86.158811)).build();
                places[24] = Place.builder().setName("Arlington and 46th").setAddress("Arlington and 46th Indianapolis, IN 46225").setLatLng(new LatLng(39.840420,-86.065078)).build();
                places[25] = Place.builder().setName("38th and Keystone").setAddress("38th and Keystone Indianapolis, IN 46225").setLatLng(new LatLng(39.825330,-86.121796)).build();
                places[26] = Place.builder().setName("25th and Keystone").setAddress("25th and Keystone Indianapolis, IN 46225").setLatLng(new LatLng(39.803418, -86.121538)).build();
                places[27] = Place.builder().setName("16th and College").setAddress("16th and College Indianapolis, IN 46225").setLatLng(new LatLng(39.788460,-86.144742)).build();
                places[28] = Place.builder().setName("36th and Totem").setAddress("36th and Totem Indianapolis, IN 46225").setLatLng(new LatLng(39.817320,-86.184657)).build();
                places[29] = Place.builder().setName("Clifton and 30th").setAddress("Clifton and 30th Indianapolis, IN 46225").setLatLng(new LatLng(39.810071,-86.180466)).build();
                break;

            case 2: // train stations (incomplete)
                places = new Place[1];
                places[0] = Place.builder().setName("Downtown Train Station").setAddress("350 South Illinois Street Indianapolis, IN 46225-1198").setLatLng(new LatLng(39.762092, -86.160517)).build();
                break;

            case 3: // Pacers bike-share docks (incomplete)
                places = new Place[37];
                places[0] = Place.builder().setName("Monument Circle").setAddress("121 Monument Circle Indianapolis, IN 46201").setLatLng(new LatLng(39.769030, -86.157460)).build();
                places[1] = Place.builder().setName("Washington and Meridian").setAddress("2 W. Washington St. Indianapolis, IN 46204").setLatLng(new LatLng(39.767420, -86.158560)).build();
                places[2] = Place.builder().setName("Washington and Capitol").setAddress("101 W. Washington St. Indianapolis, IN 46204").setLatLng(new LatLng(39.766580, -86.160420)).build();
                places[3] = Place.builder().setName("Ohio St. and Meridian").setAddress("4 E Ohio St. Indianapolis, IN 46204").setLatLng(new LatLng(39.769940, -86.157890)).build();
                places[4] = Place.builder().setName("One America Building").setAddress("202 N. Illinois St. Indianapolis, IN 46204").setLatLng(new LatLng(39.770492,-86.160405)).build();
                places[5] = Place.builder().setName("Indiana Government Center").setAddress("364 W. Washington St. Indianapolis, IN 46204").setLatLng(new LatLng(39.767370,-86.164579)).build();
                places[6] = Place.builder().setName("City County Building").setAddress("200 E. Washington St. Indianapolis, IN 46204").setLatLng(new LatLng(39.767963,-86.153559)).build();
                places[7] = Place.builder().setName("Bankers Life Fieldhouse").setAddress("169 S. Pennsylvania St. Indianapolis, IN 46204").setLatLng(new LatLng(39.764609,-86.156145)).build();
                places[8] = Place.builder().setName("Convention Center at Georgia Street").setAddress("151 W. Georgia St. Indianapolis, IN 46225").setLatLng(new LatLng(39.764079,-86.160943)).build();
                places[9] = Place.builder().setName("City Market").setAddress("108 N. Alabama St. Indianapolis, IN 46204").setLatLng(new LatLng(39.768646,-86.152832)).build();
                places[10] = Place.builder().setName("Victory Field").setAddress("99 S. West St. Indianapolis, IN 46225").setLatLng(new LatLng(39.765987,-86.166830)).build();
                places[11] = Place.builder().setName("Convention Center - Maryland and Capitol").setAddress("50 S. Capitol Ave. Indianapolis, IN 46225").setLatLng(new LatLng(39.766144,-86.163585)).build();
                places[12] = Place.builder().setName("Mass Ave. and Alabama").setAddress("372 N. Alabama St. Indianapolis, IN 46225").setLatLng(new LatLng(39.772001,-86.152708)).build();
                places[13] = Place.builder().setName("Glick Peace Walk").setAddress("625 N. Capitol Ave. Indianapolis, IN 46225").setLatLng(new LatLng(39.776443,-86.160880)).build();
                places[14] = Place.builder().setName("Michigan St. and Senate").setAddress("300 N. Michigan St. Indianapolis, IN 46225").setLatLng(new LatLng(39.7743932215,-86.1634757867)).build();
                places[15] = Place.builder().setName("Gibson Building").setAddress("433 N. Capitol Ave. Indianapolis, IN 46225").setLatLng(new LatLng(39.774135,-86.152281)).build();
                places[16] = Place.builder().setName("White River State Park").setAddress("650 S. Washington St. Indianapolis, IN 46225").setLatLng(new LatLng(39.764742,-86.176865)).build();
                places[17] = Place.builder().setName("IUPUI Campus Center").setAddress("401 University Blvd. Indianapolis, IN 46225").setLatLng(new LatLng(39.773469,-86.175384)).build();
                places[18] = Place.builder().setName("Michigan St. and Blackford").setAddress("525 N. Blackford St. Indianapolis, IN 46225").setLatLng(new LatLng(39.775912,-86.168460)).build();
                places[19] = Place.builder().setName("North and Alabama").setAddress("605 N. Alabama St. Indianapolis, IN 46225").setLatLng(new LatLng(39.775468,-86.152129)).build();
                places[20] = Place.builder().setName("Virginia and Louisiana").setAddress("388 E Louisiana St. Indianapolis, IN 46225").setLatLng(new LatLng(39.762867,-86.152185)).build();
                places[21] = Place.builder().setName("South St. and Delaware").setAddress("176 E South St. Indianapolis, IN 46225").setLatLng(new LatLng(39.761565,-86.156676)).build();
                places[22] = Place.builder().setName("Fletcher Place - Virginia and Merrill").setAddress("531 Virginia Ave. Indianapolis, IN 46225").setLatLng(new LatLng(39.759150,-86.147429)).build();
                places[23] = Place.builder().setName("Fletcher Place - Virginia and Norwood").setAddress("749 Virginia Ave. Indianapolis, IN 46225").setLatLng(new LatLng(39.757167,-86.145356)).build();
                places[24] = Place.builder().setName("13th St. and Delaware").setAddress("1303 N Delaware St. Indianapolis, IN 46225").setLatLng(new LatLng(39.753766,-86.154722)).build();
                places[25] = Place.builder().setName("16th St. and Monon Trail").setAddress("1066 E 16th St. Indianapolis, IN 46225").setLatLng(new LatLng(39.788664,-86.140134)).build();
                places[26] = Place.builder().setName("Michigan St. and Highland").setAddress("450 N Highland Ave. Indianapolis, IN 46225").setLatLng(new LatLng(39.773900,-86.137417)).build();
                places[27] = Place.builder().setName("16th St. and Delaware - Harrison Center").setAddress("1515 N Delaware St. Indianapolis, IN 46225").setLatLng(new LatLng(39.753766,-86.154722)).build();
                places[28] = Place.builder().setName("Central Library").setAddress("40 E. St. Clair St. Indianapolis, IN 46225").setLatLng(new LatLng(39.778274,-86.156788)).build();
                places[29] = Place.builder().setName("North End of Canal").setAddress("1325 Canal Walk Indianapolis, IN 46225").setLatLng(new LatLng(39.777907,-86.166894)).build();
                places[30] = Place.builder().setName("Eskenazi Health").setAddress("720 Eskenazi Ave. Indianapolis, IN 46225").setLatLng(new LatLng(39.777283,-86.184087)).build();
                places[31] = Place.builder().setName("Michigan St. and N White River Pkwy.").setAddress("1481 W Michigan St Indianapolis, IN 46225").setLatLng(new LatLng(39.774552,-86.189980)).build();
                places[32] = Place.builder().setName("North End of Mass Ave.").setAddress("949 Massachusetts Ave. Indianapolis, IN 46225").setLatLng(new LatLng(39.785000,-86.132827)).build();
                places[33] = Place.builder().setName("Mass Ave. and College").setAddress("798 Massachusetts Ave. Indianapolis, IN 46225").setLatLng(new LatLng(39.777677,-86.145506)).build();
                places[34] = Place.builder().setName("Mass Ave. and Park").setAddress("680 Massachusetts Ave. Indianapolis, IN 46225").setLatLng(new LatLng(39.776335,-86.147479)).build();
                places[35] = Place.builder().setName("Fountain Square").setAddress("1066 Virginia Ave. Indianapolis, IN 46225").setLatLng(new LatLng(39.752583,-86.140055)).build();
                places[36] = Place.builder().setName("Fountain Square - Cottage and Shelby").setAddress("1460 Shelby St. Indianapolis, IN 46225").setLatLng(new LatLng(39.686935,-86.139121)).build();
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