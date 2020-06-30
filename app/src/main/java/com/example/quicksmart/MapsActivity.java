package com.example.quicksmart;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import android.content.pm.PackageManager;
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

    private boolean locationGranted = false;
    private final int PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION = 1;

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
     *  @notes uses code found here: https://developers.google.com/maps/documentation/android-sdk/current-place-tutorial
     *  @aram: none
     *  @returns none
     */
    private void checkPermissions()
    {

        /* check if location permissions were granted, and if not then ask */
        if (ContextCompat.checkSelfPermission(this.getApplicationContext(),
                android.Manifest.permission.ACCESS_FINE_LOCATION) !=
                PERMISSION_GRANTED )
        {

            /* request location access */
            ActivityCompat.requestPermissions(this,
                    new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION},
                    PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION);


        }
        else
        {

            locationGranted = true;
            /* set current location */

        }

    }

    /* from the code found here: https://stackoverflow.com/questions/41613511/my-permissions-request-access-fine-location-permission-android-not-recognised-in */
    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults)
    {

        switch (requestCode)
        {

            case PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION : {

                if(grantResults.length > 0 && grantResults[0] == PERMISSION_GRANTED)
                {

                    locationGranted = true;
                    /* permission is now granted */

                }else{

                    /* permission still denied, rely on something else for
                     * starting point data
                     */

                }


            }

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

        checkPermissions();

        // Add a marker in Sydney and move the camera
        LatLng indy = new LatLng(39.768402, -86.158066);
        mMap.addMarker(new MarkerOptions().position(indy).title("Indianapolis"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(indy));
        mMap.animateCamera( CameraUpdateFactory.zoomTo( 10.0f ) );

    }
}