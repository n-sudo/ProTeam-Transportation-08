package com.example.quicksmart;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.model.RectangularBounds;
import com.google.android.libraries.places.api.model.TypeFilter;
import com.google.android.libraries.places.api.net.PlacesClient;
import com.google.android.libraries.places.widget.AutocompleteSupportFragment;
import com.google.android.libraries.places.widget.listener.PlaceSelectionListener;
import com.google.maps.DistanceMatrixApi;
import com.google.maps.DistanceMatrixApiRequest;
import com.google.maps.GeoApiContext;
import com.google.maps.errors.ApiException;
import com.google.maps.model.DistanceMatrix;
import com.google.maps.model.TravelMode;

import java.io.IOException;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements
        OnMapReadyCallback,
        GoogleMap.OnMarkerDragListener,
        GoogleMap.OnMarkerClickListener {

    private static final String TAG = "PlacesAPI"; // For place autocomplete
    //private static final GeoApiContext context = new GeoApiContext().setApiKey("AIzaSyA1_YNNgIOgBvnU78_TUVItovD_pRDAIjU"); // For distance calculations
    private static GeoApiContext context = new GeoApiContext.Builder()
            .apiKey("AIzaSyA1_YNNgIOgBvnU78_TUVItovD_pRDAIjU").build();

    private ProgressBar pgsBar;
    private LocationManager locationManager;
    private Switch busSwitch;
    private Switch trainSwitch;
    private Switch bikeSwitch;
    private Marker destination;
    private Marker currentLocation;
    private GoogleMap mMap;
    private PlacesClient placesClient;
    private TextView safetyText;
    private Marker bestBikeRoute;

    private static Place selectedDestination;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize loading bar
        pgsBar = (ProgressBar) findViewById(R.id.pBar);
        // Initialize Places SDK
        Places.initialize(getApplicationContext(), "AIzaSyA1_YNNgIOgBvnU78_TUVItovD_pRDAIjU");

        placesClient = Places.createClient(this);

        //Initialize the AutocompleteSupportFragment
        AutocompleteSupportFragment autocompleteFragment = (AutocompleteSupportFragment)
                getSupportFragmentManager().findFragmentById(R.id.autocomplete_fragment);
        autocompleteFragment.setTypeFilter(TypeFilter.ADDRESS);
        autocompleteFragment.setCountry("US");

        // Specify the types of place data to return
        autocompleteFragment.setPlaceFields(Arrays.asList(Place.Field.ID, Place.Field.NAME, Place.Field.ADDRESS, Place.Field.LAT_LNG));

        // Set to Indianapolis-ish specific region
        autocompleteFragment.setLocationBias(RectangularBounds.newInstance(
                new LatLng(39.632193, -86.324746),
                new LatLng(39.960092, -85.883683)));

        busSwitch = (Switch) findViewById(R.id.switch1);
        busSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                refreshMap();
            }
        });

        trainSwitch = (Switch) findViewById(R.id.switch2);
        trainSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                refreshMap();
            }
        });

        bikeSwitch = (Switch) findViewById(R.id.switch3);
        bikeSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                refreshMap();
            }
        });

        // setup the map fragment
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);

        // call onMapReadyCallback when the map is ready
        mapFragment.getMapAsync(this);

        // Set up a PlaceSelectionListener to handle the response.
        autocompleteFragment.setOnPlaceSelectedListener(new PlaceSelectionListener() {
            @Override
            public void onPlaceSelected(Place place) {
                selectedDestination = place;
                Log.i(TAG, "Place: " + place.getName() + ", " + place.getId());
                setDestination(place);
            }

            @Override
            public void onError(Status status) {
                Log.i(TAG, "An error occurred: " + status);
            }
        });

        ImageButton busRoutes = (ImageButton) findViewById(R.id.bus);
        busRoutes.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                toBusRoutes();

            }

        });

        Button planMyTrip = (Button) findViewById(R.id.planMyTrip);
        planMyTrip.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                toPlanMyTrip();

            }

        });

        safetyText = (TextView) findViewById(R.id.safetyText);
        safetyText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toSafetyInfo();
            }
        });

        ImageButton settings = (ImageButton) findViewById(R.id.settings);
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toSettings();
            }
        });


    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {

        if (requestCode == 1) {

            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                System.out.println(" [31m Location permissions granted, starting location");

            }

        }

    }

    private final LocationListener locationListener = new LocationListener() {

        @Override
        public void onLocationChanged(@NonNull Location location) {

            currentLocation = mMap.addMarker(new MarkerOptions()
                    .position(new LatLng(location.getLatitude(), location.getLongitude()))
                    .title("current location")
                    .draggable(true));

            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(MainActivity.this, "Best Provider update", Toast.LENGTH_SHORT).show();
                }
            });

        }

    };

    /* https://github.com/obaro/SimpleLocationApp/blob/master/app/src/main/java/com/sample/foo/simplelocationapp/MainActivity.java */
    private boolean isLocationEnabled() {
        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) ||
                locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
    }

    private boolean checkLocation() {
        if (!isLocationEnabled())
            showAlert();
        return isLocationEnabled();
    }

    /* https://github.com/obaro/SimpleLocationApp/blob/master/app/src/main/java/com/sample/foo/simplelocationapp/MainActivity.java */
    private void showAlert() {
        final AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("Enable Location")
                .setMessage("Your Locations Settings is set to 'Off'.\nPlease Enable Location to " +
                        "use this app")
                .setPositiveButton("Location Settings", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface paramDialogInterface, int paramInt) {
                        Intent myIntent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                        startActivity(myIntent);
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface paramDialogInterface, int paramInt) {
                    }
                });
        dialog.show();
    }

    private void toBusRoutes() {

        Intent intent = new Intent(this, BusRoutesActivity.class);
        startActivity(intent);
    }

    private void toSafetyInfo() {

        Intent intent = new Intent(this, SafetyActivity.class);
        startActivity(intent);

    }

    private void toSettings() {

        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);

    }

    private void toPlanMyTrip() {

        Intent intent = new Intent(this, PlanMyTripActivity.class);
        startActivity(intent);

    }


    @Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;

        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    1);

            return;

        }

        locationManager.requestLocationUpdates(
                LocationManager.GPS_PROVIDER, 2 * 60 * 1000, 10, locationListener);
        mMap.setMyLocationEnabled(true);
        mMap.getUiSettings().setMyLocationButtonEnabled(true);

        // add a marker at indianapolis
        LatLng indy = new LatLng(39.768402, -86.158066);
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(indy, 13.75f));
        mMap.setOnMarkerClickListener(this);
        mMap.setOnMarkerDragListener(this);

        // add markers for bike-share docks
        if (busSwitch.isChecked())
            addPlaces(1);

        if (trainSwitch.isChecked())
            addPlaces(2);

        if (bikeSwitch.isChecked())
            addPlaces(3);


    }

    public static String getDestination(){

        String destinationString = "";

        if(selectedDestination != null){

            destinationString = selectedDestination.getAddress();

        }else{

            destinationString = "You haven't selected one yet.";

        }

        return destinationString;

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
    private void setDestination(Place place) {

        try {

            if (mMap != null) {

                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(place.getLatLng(), 13.5f));
                destination = mMap.addMarker(new MarkerOptions()
                        .position(place.getLatLng())
                        .title("Destination: " + place.getName())
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));

                // Adds purple mark for best bike
                if(bikeSwitch.isChecked())
                    addBestBikeLoc(place);
                
            } else {

            }

        } catch (Exception ex) {

        }

    }

    public void addBestBikeLoc(Place place) throws InterruptedException, ApiException, IOException {
        pgsBar.setVisibility(View.VISIBLE);
        // Remove previous marker
        if(bestBikeRoute != null)
            bestBikeRoute.remove();
        // For pointing out best bike location
        Place bestBikeLoc = null;
        long bestDur = Integer.MAX_VALUE;
        String walkDur = "";
        String bikeDur = "";
        // Current location of user
        com.google.maps.model.LatLng currentLoc = new com.google.maps.model.LatLng(currentLocation.getPosition().latitude,
                currentLocation.getPosition().longitude);
        for (Place bikeLoc : PlaceFinder.getPlaces(3)) {
            // Since there are two kinds of LatLng and google hates me
            com.google.maps.model.LatLng bikeLocToCheck = new com.google.maps.model.LatLng(bikeLoc.getLatLng().latitude,
                    bikeLoc.getLatLng().longitude);
            com.google.maps.model.LatLng dest = new com.google.maps.model.LatLng(place.getLatLng().latitude,
                    place.getLatLng().longitude);
            // For from current location to bike
            DistanceMatrixApiRequest req1 = DistanceMatrixApi.newRequest(context);
            DistanceMatrix trix1 = req1.origins(currentLoc)
                    .destinations(bikeLocToCheck)
                    .mode(TravelMode.WALKING)
                    .await();
            // For from bike to destination
            DistanceMatrixApiRequest req2 = DistanceMatrixApi.newRequest(context);
            DistanceMatrix trix2 = req2.origins(bikeLocToCheck)
                    .destinations(dest)
                    .mode(TravelMode.BICYCLING)
                    .await();
            long duration = trix1.rows[0].elements[0].duration.inSeconds;
            Log.d("MyApp","Duration 1 " + duration);
            duration += trix2.rows[0].elements[0].duration.inSeconds;
            Log.d("MyApp","Duration 2 " + duration);
            if (duration < bestDur) {
                bestDur = duration;
                bestBikeLoc = bikeLoc;
                walkDur = trix1.rows[0].elements[0].duration.toString();
                bikeDur = trix2.rows[0].elements[0].duration.toString();
            }
            duration = 0;
        } // End for loop
        if (bestBikeLoc != null) {
            Log.d("MyApp","Hey it wasn't null");
            bestBikeRoute = mMap.addMarker(new MarkerOptions()
                    .position(bestBikeLoc.getLatLng())
                    .title("Fastest Bike Route: Walk - " + walkDur + ", Bike - " + bikeDur)
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA)));
        }
        pgsBar.setVisibility(View.GONE);
    }

    /**
     * @param transCode the code of the mode of transportation to get locations for
     * @brief get places for a given mode of transportation
     * @note 1 for bus, 2 for train, 3 for bike-share
     */
    private void addPlaces(int transCode) {

        Place[] places = PlaceFinder.getPlaces(transCode);
        String title;
        float color = BitmapDescriptorFactory.HUE_RED;

        switch (transCode) {

            case 1:
                title = "bus stop: ";
                color = BitmapDescriptorFactory.HUE_GREEN;
                break;

            case 2:
                title = "train station: ";
                color = BitmapDescriptorFactory.HUE_YELLOW;
                break;

            case 3:
                title = "bike-share dock: ";
                color = BitmapDescriptorFactory.HUE_CYAN;
                break;

            default:
                title = "idk what this is: ";
                color = BitmapDescriptorFactory.HUE_MAGENTA;
                break;

        }


        for (int i = 0; i < places.length; i++) {

            try {

                if (mMap != null) {

                    mMap.addMarker(new MarkerOptions()
                            .position(places[i].getLatLng())
                            .title(title + places[i].getName())
                            .icon(BitmapDescriptorFactory.defaultMarker(color)));

                } else {

                }

            } catch (Exception ex) {

            }

        }

    }

    private void refreshMap() {


        mMap.clear();

        if (busSwitch.isChecked())
            addPlaces(1);

        if (trainSwitch.isChecked())
            addPlaces(2);

        if (bikeSwitch.isChecked())
            addPlaces(3);

        mMap.addMarker(new MarkerOptions().title("current location").position(currentLocation.getPosition()));

        if (destination != null) {

            destination = mMap.addMarker(new MarkerOptions().position(destination.getPosition())
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE))
                    .title(destination.getTitle()));

        }


    }


}