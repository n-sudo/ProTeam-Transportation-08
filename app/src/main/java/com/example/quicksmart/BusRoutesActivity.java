package com.example.quicksmart;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class BusRoutesActivity extends AppCompatActivity {

    private int routeNumber = 2;

    private TextView routeTitle;
    private ImageView routeMap;
    private Button next;
    private Button prev;

    private int[] routeMaps = {
            R.drawable.route2,
            R.drawable.route3,
            R.drawable.route4,
            R.drawable.route5
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_routes);

        // setup the route title
        routeTitle = (TextView) findViewById(R.id.routeTitle);
        routeTitle.setText("ROUTE " + routeNumber);

        // setup the imageview for the route map
        routeMap = (ImageView) findViewById(R.id.routeMap);
        routeMap.setImageResource(R.drawable.route2);

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

    }

    private void changeRoute(int direction){

        switch(direction)
        {

            case 1:
                if(routeNumber < 5){
                    routeNumber++;
                }else{
                    routeNumber = 2;
                }
                break;

            case 2:
                if(routeNumber > 2){
                    routeNumber--;
                }else{
                    routeNumber = 5;
                }
                break;

            default:
                break;

        }

        routeTitle.setText("ROUTE " + routeNumber);
        routeMap.setImageResource(routeMaps[(routeNumber - 2)]);

    }

}