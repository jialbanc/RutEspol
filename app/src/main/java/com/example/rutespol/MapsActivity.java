package com.example.rutespol;

import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.widget.SlidingPaneLayout;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.List;

public class MapsActivity extends FragmentActivity {

    private GoogleMap mMap; // Might be null if Google Play services APK is not available.
    Lectura leer;
    LatLng latlng;
    PolylineOptions line = new PolylineOptions();
    private static final int PARALLAX_SIZE = 30;

    private SlidingPaneLayout mPanes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        this.findViewById(R.id.header_maps).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MapsActivity.this,MainMenu.class);
                startActivity(i);
            }
        });

        mPanes = (SlidingPaneLayout) findViewById(R.id.slidingPanel_maps);
        mPanes.setParallaxDistance(PARALLAX_SIZE);
        mPanes.setShadowResource(R.drawable.background);

        mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                .getMap();
        leer=new Lectura();
        Bundle b=this.getIntent().getExtras();
        System.out.println("\t\t\t\t"+b.getString("name"));
        leer.leer(b.getString("name"));

        line.width(4);
        line.color(Color.RED);


        for (int i = 0; i < leer.map.length; i++) {
           // System.out.println(leer.map[i]);
            latlng=new LatLng(Double.parseDouble(leer.lng.get(i)),Double.parseDouble(leer.lat.get(i)));
            line.add(latlng);
        }
        mMap.addPolyline(line);
        latlng=new LatLng(Double.parseDouble(leer.lng.get(leer.map.length/2)),Double.parseDouble(leer.lat.get(leer.map.length/2)));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latlng, 25));
        // Zoom in, animating the camera.
        mMap.animateCamera(CameraUpdateFactory.zoomIn());
        // Zoom out to zoom level 10, animating with a duration of 2 seconds.
        mMap.animateCamera(CameraUpdateFactory.zoomTo(13), 2000, null);
        for (int i = 0; i < leer.paraderos.size(); i++) {
            if(i==0){
                mMap.addMarker(new MarkerOptions()
                        .position(leer.paraderos.get(i))
                        .title(leer.paraderoNombre.get(i))
                        .snippet(leer.paraderoMensaje.get(i))
                        .icon(BitmapDescriptorFactory
                                .fromResource(R.drawable.icono_bus))
                        .anchor(0.5f, 0.5f));
            }else {
                mMap.addMarker(new MarkerOptions()
                        .position(leer.paraderos.get(i))
                        .title(leer.paraderoNombre.get(i))
                        .snippet(leer.paraderoMensaje.get(i))
                        .icon(BitmapDescriptorFactory
                                .fromResource(R.drawable.icono_paradero))
                        .anchor(0.5f, 0.5f));
            }

        }



    }



    private void openPane() {
        mPanes.openPane();
    }

    private void closePane() {
        mPanes.closePane();
    }

    @Override
    protected void onResume() {
        super.onResume();
        //setUpMapIfNeeded();
    }

    /**
     * Sets up the map if it is possible to do so (i.e., the Google Play services APK is correctly
     * installed) and the map has not already been instantiated.. This will ensure that we only ever
     * call {@link #setUpMap()} once when {@link #mMap} is not null.
     * <p>
     * If it isn't installed {@link SupportMapFragment} (and
     * {@link com.google.android.gms.maps.MapView MapView}) will show a prompt for the user to
     * install/update the Google Play services APK on their device.
     * <p>
     * A user can return to this FragmentActivity after following the prompt and correctly
     * installing/updating/enabling the Google Play services. Since the FragmentActivity may not
     * have been completely destroyed during this process (it is likely that it would only be
     * stopped or paused), {@link #onCreate(Bundle)} may not be called again so we should call this
     * method in {@link #onResume()} to guarantee that it will be called.
     */
    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                setUpMap();
            }
        }
    }

    /**
     * This is where we can add markers or lines, add listeners or move the camera. In this case, we
     * just add a marker near Africa.
     * <p>
     * This should only be called once and when we are sure that {@link #mMap} is not null.
     */
    private void setUpMap() {
        mMap.addMarker(new MarkerOptions().position(new LatLng(0, 0)).title("Marker"));
    }


}
