package com.example.quicksmart;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SafetyActivity extends AppCompatActivity {

    private String safetyText="Riding a bus\n" +
            "indygo.net/health/ has the guidelines on what travelers can do " +
            "while riding on a city bus:\n\n" +
            " - Wear a mask (IndyGo does not require them but it is still a " +
            "   good idea)\n" +
            " - Wash your hands with soap and water for at least 20 seconds " +
            "   or use hand sanitizer if soap and water are not available. \n" +
            " - Avoid touching your face, especially your eyes.  \n" +
            " - Use a tissue when you sneeze, then throw the tissue in the " +
            "   trash. If you don’t have a tissue cover your sleeve. \n" +
            " - Cover your cough with your sleeve. \n" +
            " - Stay home if you are sick\n" +
            "Riding a bike/scooter\n" +
            "https://www.bicycling.com/news/a31469228/cycling-during-coronavirus/ bicycling.com talked to David Nieman, Dr.PH., health professor at Appalachian State University and director of the Human Performance Lab at the North Carolina Research Campus, Brian Labus, Ph.D., MPH, assistant professor in the School of Public Health at the University of Nevada Las Vegas, and Matt Ferrari Ph.D., associate professor of biology in the Eberly College of Science, and a researcher with the Center for Infectious Disease Dynamics.\n" +
            "It is safe to ride outside\n" +
            "the safest way to ride outside is to do it alone\n" +
            "Wear a moisture-wicking face covering while riding\n" +
            "Maintain at least a 6-foot distance from others\n" +
            "Driving\n" +
            "https://www.cdc.gov/coronavirus/2019-ncov/travelers/travel-in-the-us.html\n" +
            "Bring a mask to wear in public places.\n" +
            "Prepare food and water for your trip. Pack non-perishable food in case restaurants and stores are closed.\n" +
            "Take steps to protect yourself from COVID-19 when booking accommodations or planning an overnight stay.\n" +
            "Check travel restrictions to plan out your trip accordingly.\n" +
            "Walking\n" +
            "https://health.clevelandclinic.org/covid-19-how-to-stay-safe-during-outdoor-activities/\n" +
            "Try to stick to walking in local areas, like local parks\n" +
            "If you are hiking with family members or other members of your household, you may stay in close proximity with them.\n" +
            "If you are walking or hiking with neighbors or friends, then you’ll need to maintain a minimum of 6 feet.\n" +
            "If you see that the park or walking route is crowded, it is best to plan the trip for another time.\n" +
            "Check official guidelines to see if the local area on the route is closed.\n";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_safety);

        TextView text = (TextView) findViewById(R.id.safetyText);
        text.setText(safetyText);

    }
}