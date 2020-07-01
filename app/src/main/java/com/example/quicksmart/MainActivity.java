package com.example.quicksmart;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.model.TypeFilter;
import com.google.android.libraries.places.api.net.PlacesClient;
import com.google.android.libraries.places.widget.AutocompleteSupportFragment;
import com.google.android.libraries.places.widget.listener.PlaceSelectionListener;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements
        OnMapReadyCallback,
        GoogleMap.OnMarkerDragListener,
        GoogleMap.OnMarkerClickListener
{

    private static final String TAG = "Tag"; // For place autocomplete
    private Marker destination;
    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize Places SDK
        Places.initialize(getApplicationContext(), "AIzaSyA1_YNNgIOgBvnU78_TUVItovD_pRDAIjU");
        // Create a new Places client instance
        PlacesClient placesClient = Places.createClient(this);

        //Initialize the AutocompleteSupportFragment
        AutocompleteSupportFragment autocompleteFragment = (AutocompleteSupportFragment)
                getSupportFragmentManager().findFragmentById(R.id.autocomplete_fragment);
        autocompleteFragment.setTypeFilter(TypeFilter.ADDRESS);
        autocompleteFragment.setCountry("US");
        // Specify the types of place data to return
        autocompleteFragment.setPlaceFields(Arrays.asList(Place.Field.ID, Place.Field.NAME));
        // Set up a PlaceSelectionListener to handle the response.
        autocompleteFragment.setOnPlaceSelectedListener(new PlaceSelectionListener() {
            @Override
            public void onPlaceSelected(Place place) {
                Log.i(TAG, "Place: " + place.getName() + ", " + place.getId());
                moveDestination(place);
            }
            @Override
            public void onError(Status status) {
                Log.i(TAG, "An error occurred: " + status);
            }
        });

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);



        Button viewMap = (Button) findViewById(R.id.button);
        viewMap.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                toMap();
            }
        });

    }

    private void toMap()
    {

        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);

    }


    @Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;

        // add a marker at indianapolis
        LatLng indy = new LatLng(39.768402, -86.158066);
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom( indy,13.75f ));
        mMap.setOnMarkerClickListener(this);
        mMap.setOnMarkerDragListener(this);

    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        return false;
    }

    @Override
    public void onMarkerDragStart(Marker marker) {

    }

    @Override
    public void onMarkerDrag(Marker marker) {

    }

    @Override
    public void onMarkerDragEnd(Marker marker) {

    }

    /* https://parallelcodes.com/android-google-map-add-autocomplete-place-search/ */
    private void moveDestination(Place place){

        try
        {

            if(mMap != null)
            {

                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(place.getLatLng(), 4));
                destination = mMap.addMarker(new MarkerOptions().position(place.getLatLng())
                        .title("Name:" + place.getName() + ". Address:" + place.getAddress()));

            }

        }
        catch(Exception ex)
        {

        }

    }

}