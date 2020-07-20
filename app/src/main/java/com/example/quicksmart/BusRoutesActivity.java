package com.example.quicksmart;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class BusRoutesActivity<schedules> extends AppCompatActivity {

    private int routeNumber = 22;

    private RecyclerView recyclerView;
    private RecyclerView recyclerView2;
    private TextView routeTitle;
    private ImageView routeMap;
    private Button next;
    private Button prev;

    private int[] routeMaps = {
            R.drawable.bus_route__1_,
            R.drawable.bus_route__2_,
            R.drawable.bus_route__3_,
            R.drawable.bus_route__4_,
            R.drawable.bus_route__5_,
            R.drawable.bus_route__6_,
            R.drawable.bus_route__7_,
            R.drawable.bus_route__8_,
            R.drawable.bus_route__9_,
            R.drawable.bus_route__10_,
            R.drawable.bus_route__11_,
            R.drawable.bus_route__12_,
            R.drawable.bus_route__13_,
            R.drawable.bus_route__14_,
            R.drawable.bus_route__15_,
            R.drawable.bus_route__16_,
            R.drawable.bus_route__17_,
            R.drawable.bus_route__18_,
            R.drawable.bus_route__19_,
            R.drawable.bus_route__20_,
            R.drawable.bus_route__21_,
            R.drawable.bus_route__22_,
            R.drawable.bus_route__23_,
            R.drawable.bus_route__24_,
            R.drawable.bus_route__25_,
            R.drawable.bus_route__26_,
            R.drawable.bus_route__27_,
            R.drawable.bus_route__28_,
            R.drawable.bus_route__29_,
            R.drawable.bus_route__30_,
            R.drawable.bus_route__31_
    };

    private String[] routeNames = {
            "E. 34th Street",
            "?",
            "?",
            "?",
            "?",
            "?",
            "?",
            "?",
            "?",
            "?",
            "?",
            "?",
            "?",
            "Minnesota",
            "Castleton",
            "Prospect",
            "Raymond",
            "Minnesota",
            "E. 16th Street",
            "10th Street",
            "Washington",
            "Harding",
            "E. 25th Street",
            "Fort Harrison",
            "?",
            "Michigan Street",
            "?",
            "?",
            "?",
            "?",
            "?"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_routes);

        // setup the route title
        routeTitle = (TextView) findViewById(R.id.routeTitle);
        routeTitle.setText(routeNames[routeNumber]);

        // setup the imageview for the route map
        routeMap = (ImageView) findViewById(R.id.routeMap);
        routeMap.setImageResource(routeMaps[routeNumber]);

        // setup next route button
        next = (Button) findViewById(R.id.nextRoute);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeRoute(1);
            }
        });

        //setup previous route button
        prev = (Button) findViewById(R.id.prevRoute);
        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeRoute(2);
            }
        });

        ScheduleAdapter scheduleAdapter = new ScheduleAdapter(getStopsInbound(routeNumber), getTimesInbound(routeNumber));
        recyclerView = (RecyclerView) findViewById(R.id.inbound);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(scheduleAdapter);

        ScheduleAdapter scheduleAdapter2 = new ScheduleAdapter(getStopsOutbound(routeNumber), getTimesOutbound(routeNumber));
        recyclerView2 = (RecyclerView) findViewById(R.id.outbound);
        recyclerView2.setLayoutManager(new LinearLayoutManager(this));
        recyclerView2.setAdapter(scheduleAdapter2);

    }

    /** @prief updates the information displayed when the user changes route selection
     * @param direction the direction in which to traverse the arrays of information for each route
     * @note 1 is forwards to 30, and 2 is backwards to 0.
     */
    private void changeRoute(int direction){

        switch(direction)
        {

            case 1:
                if(routeNumber < 30){
                    routeNumber++;
                }else{
                    routeNumber = 0;
                }
                break;

            case 2:
                if(routeNumber > 0){
                    routeNumber--;
                }else{
                    routeNumber = 30;
                }
                break;

            default:
                break;

        }

        routeTitle.setText(routeNames[routeNumber]);
        routeMap.setImageResource(routeMaps[(routeNumber)]);
        ScheduleAdapter scheduleAdapter = new ScheduleAdapter(getStopsInbound(routeNumber), getTimesInbound(routeNumber));
        recyclerView.setAdapter(scheduleAdapter);
        ScheduleAdapter scheduleAdapter2 = new ScheduleAdapter(getStopsOutbound(routeNumber), getTimesOutbound(routeNumber));
        recyclerView2.setAdapter(scheduleAdapter2);

    }

    /**
     * @breif given a route number, will return an array of strings with stop and time info
     * @param routeNumber the route number of the schedule to return
     * @return an array of strings with stops and time information
     */

    private String[] getStopsInbound(int routeNumber){

        String[] stops;

        switch(routeNumber){
            case 22:
                stops = new String[] {
                    "38th and Sherman",
                    "25th and Keystone",
                    "16th and College",
                    "Transit Center"
                };
                break;
            case 23:
                stops = new String[] {
                        "Comm. Hospital North",
                        "Ivy Tech Lawrence",
                        "Finance Center South",
                        "Arlington and 46th",
                        "38th and Keystone",
                        "Central and 16th",
                        "Transit Center"
                };
                break;
            default:
                stops = new String[] {
                    "¯\\_(ツ)_/¯",
                };
                break;

        }

        return stops;

    }

    private String[] getStopsOutbound(int routeNumber){

        String[] stops;

        switch(routeNumber){
            case 22:
                stops = new String[] {
                        "Transit Center",
                        "16th and College",
                        "25th and Keystone",
                        "38th and Sherman"
                };
                break;
            case 23:
                stops = new String[] {
                        "Transit Center",
                        "Central and 16th",
                        "38th and Keystone",
                        "Arlington and 46th",
                        "Finance Center South",
                        "Ivy Tech Lawrence",
                        "Comm. Hospital North"
                };
                break;
            default:
                stops = new String[] {
                    "¯\\_(ツ)_/¯",
                };
                break;

        }

        return stops;

    }

    private String[][] getTimesInbound(int routeNumber){

        String[][] dates;

        switch(routeNumber){

            case 22:
                dates = new String[][] {
                        {"454a", "524a", "554a", "624a", "654a", "724a"},
                        {"504a", "534a", "604a", "634a", "704a", "734a"},
                        {"515a", "545a", "615a", "645a", "715a", "745a"},
                        {"525a", "555a", "625a", "655a", "725a", "755a"}
                };
                break;
            case 23:
                dates = new String[][] {
                        {" NA   NA   NA   NA   NA   NA "},
                        {" NA   NA   NA  613a 643a 713a"},
                        {" NA   NA   NA  619a 649a 719a"},
                        {"505a 535a 604a 632a 702a 732a"},
                        {"517a 547a 616a 645a 715a 745a"},
                        {"529a 559a 628a 658a 728a 758a"},
                        {"535a 605a 635a 705a 735a 805a"}
                };
                break;
            default:
                dates = new String[][] {
                    {
                        "no schedule for this route"
                    }
                };
                break;

        }

        return dates;

    }

    /**
     * @breif provides outbound times for stops
     * @param routeNumber
     * @return a string of times for each stop in the route
     */
    private String[][] getTimesOutbound(int routeNumber){

        String[][] dates;

        switch(routeNumber){

            case 22:
                dates = new String[][] {
                        {"515a 545a 615a 645a 715a 745a"},
                        {"522a 552a 622a 652a 722a 752a"},
                        {"533a 603a 633a 703a 733a 803a"},
                        {"544a 614a 644a 714a 744a 814a"}
                };
                break;
            case 23:
                dates = new String[][] {
                        {"515a 545a 615a 645a 715a 815a"},
                        {"521a 551a 621a 651a 721a 821a"},
                        {"534a 605a 635a 705a 735a 835a"},
                        {"547a 618a 648a 718a 748a 848a"},
                        {"559a 630a 700a 730a 800a  NA "},
                        {"606a 637a 707a 737a 807a  NA "},
                        {" NA   NA   NA   NA   NA  902a"}
                };
                break;
            default:
                dates = new String[][] {
                        {
                            "no schedule for this route"
                        }
                };
                break;

        }

        return dates;

    }


}


