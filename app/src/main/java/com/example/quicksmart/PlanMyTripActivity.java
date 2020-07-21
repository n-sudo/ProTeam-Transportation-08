package com.example.quicksmart;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PlanMyTripActivity extends AppCompatActivity {

    private static Transportation[] options;

    private Switch enjoy;
    private Switch cheap;
    private Switch fast;
    private Switch safe;

    private TextView info;

    private Button getOptions;

    private String enjoyText = "when selected, the Trip Planner will look at user ratings to select the most pleasant way to get from A to B.";
    private String cheapText = "when selected, the Trip Planner will factor in fares and fees to select the most cost-effective option.";
    private String fastText = "when selected, the Trip Planner will consider wait times and estimated travel time to find the fastest trip to your chosen destination.";
    private String safeText = "Presently we don't have data to back any assessments of how \"safe\" an option is; so we won't. That in mind, the " +
                              "general idea is to assign a safety score based on how feasible precautions like social distancing are.";
    private String defaultText = "I'm not sure how you got here, but this is the default text.";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan_my_trip);

        info = (TextView) findViewById(R.id.moreInfo);

        enjoy = (Switch) findViewById(R.id.enjoySwitch);
        enjoy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setInfoText(1);
            }
        });

        cheap = (Switch) findViewById(R.id.cheapSwitch);
        cheap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setInfoText(2);
            }
        });

        fast = (Switch) findViewById(R.id.fastSwitch);
        fast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setInfoText(3);
            }
        });

        safe = (Switch) findViewById(R.id.safeSwitch);
        safe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setInfoText(4);
            }
        });

        getOptions = findViewById(R.id.getOptions);
        getOptions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getTransportationOptions();
            }
        });

    }

    private void setInfoText(int selection){

        switch(selection){

            case 1:
                info.setText(enjoyText);
                break;
            case 2:
                info.setText(cheapText);
                break;
            case 3:
                info.setText(fastText);
                break;
            case 4:
                info.setText(safeText);
                break;
            default:
                info.setText(defaultText);
                break;

        }

    }

    private void getTransportationOptions(){

        int[] preferences = {
                (1 * (enjoy.isChecked() ? 1 : 0)),
                (2 * (cheap.isChecked() ? 1 : 0)),
                (3 * (fast.isChecked() ? 1 : 0)),
                (4 * (safe.isChecked() ? 1 : 0))
        };

       options = TripPlanner.getTransportationOptions(preferences);

    }

}