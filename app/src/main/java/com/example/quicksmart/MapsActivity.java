package com.example.quicksmart;

import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

/* NOTE: code borrows heavily from the tutorial provided in google's online docs, specifically the one found here:
 * https://stackoverflow.com/questions/41613511/my-permissions-request-access-fine-location-permission-android-not-recognised-in */

public class MapsActivity extends FragmentActivity implements
        OnMapReadyCallback,
        GoogleMap.OnMarkerDragListener,
        GoogleMap.OnMarkerClickListener
{

    private FusedLocationProviderClient locationProvider;
    private TextView debug;

    private Marker destination;
    private Marker start;

    private GoogleMap mMap;
    private Location LKL;
    private boolean locationGranted = false;
    private static final int PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION = 1;
    private final LatLng defaultLocation = new LatLng(-33.8523341, 151.2106085);

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        debug = (TextView) findViewById(R.id.text);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);

        if (savedInstanceState == null)
        {
            // retains state across activity restarts
            mapFragment.setRetainInstance(true);
        }

        mapFragment.getMapAsync(this);

        /* get location permission */

    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap)
    {
        mMap = googleMap;

        //getDeviceLocation(); //broken

        // add a marker at indianapolis
        LatLng indy = new LatLng(39.768402, -86.158066);
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom( indy,13.75f ));

        destination = mMap.addMarker(new MarkerOptions().position(indy).title("Destination").draggable(true));
        mMap.setOnMarkerClickListener(this);
        mMap.setOnMarkerDragListener(this);

    }

    @Override
    public boolean onMarkerClick(Marker marker)
    {
        return false;
    }

    @Override
    public void onMarkerDragStart(Marker marker)
    {

    }

    @Override
    public void onMarkerDrag(Marker marker)
    {

        debug.setVisibility(View.VISIBLE);
        debug.setText( marker.getTitle() + ": " + marker.getPosition());

    }

    @Override
    public void onMarkerDragEnd(Marker marker)
    {

        debug.setVisibility(View.INVISIBLE);

    }
}