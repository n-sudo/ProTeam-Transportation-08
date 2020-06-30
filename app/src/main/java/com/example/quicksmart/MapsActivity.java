package com.example.quicksmart;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import android.location.Location;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import static android.content.pm.PackageManager.PERMISSION_GRANTED;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private Location currentLocation;
    private Location destination;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }

    /** @brief: checks if location permissions are enabled
     *  @aram: none
     *  @returns none
     */
    private void checkPermissions(){

        /* check for location permissions */
        int status = ContextCompat.checkSelfPermission(this, "android.permission.ACCESS_FINE_LOCATION");

        /* if they were not granted, then ask */
        if (status != PERMISSION_GRANTED)
        {

            /* request location access */

        }
        else
        {

            /* set current location */

        }

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
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng indy = new LatLng(39.768402, -86.158066);
        mMap.addMarker(new MarkerOptions().position(indy).title("Indianapolis"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(indy));
        mMap.animateCamera( CameraUpdateFactory.zoomTo( 10.0f ) );

    }
}