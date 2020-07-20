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
            "idk",
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

        ScheduleAdapter scheduleAdapter = new ScheduleAdapter(getSchedule(routeNumber));
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView2);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(scheduleAdapter);

    }

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
        ScheduleAdapter scheduleAdapter = new ScheduleAdapter(getSchedule(routeNumber));
        recyclerView.setAdapter(scheduleAdapter);

    }

    private String[] getSchedule(int routeNumber){

        String[] schedule;

        switch(routeNumber){

            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
                schedule = new String[] {
                    "placeholder stop 1: time1, time2, time3",
                    "placeholder stop 2: time1, ",
                    "placeholder stop 3: time1, time2",
                };

                /*


                 */

                break;
            case 22:
                schedule = new String[] {
                    "38th and Sherman: 454a 524a 554a 624a 654a 724a...",
                    "25th and Keystone: 5:04a, 5:34a, 6:04a...",
                    "16th and College: 5:15a. 5:55a, 6:25a...",
                    "Transit Center: 5:25a, 5:55a, 6:25a..."
                };
                break;
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            default:
                schedule = new String[] {
                    "placeholder stop 1: time1, time2, time3",
                    "placeholder stop 2: time1, ",
                    "placeholder stop 3: time1, time2",
                };
                break;

        }

        return schedule;

    }

}


