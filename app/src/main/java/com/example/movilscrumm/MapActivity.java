package com.example.movilscrumm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.preference.PreferenceManager;

import org.osmdroid.config.Configuration;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapController;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.Marker;


public class MapActivity extends AppCompatActivity {
    private MapView map;
    private MapController mapController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        Configuration.getInstance().load(this, PreferenceManager.getDefaultSharedPreferences(this));
        map = (MapView) findViewById(R.id.mapView);
        map.setTileSource(TileSourceFactory.MAPNIK);

        map.setBuiltInZoomControls(true);
        mapController = (MapController) map.getController();
        GeoPoint UNAB = new GeoPoint(7.116674895419581, -73.1054494179268);
        Marker marker = new Marker(map);
        marker.setPosition(UNAB);
        marker.setTextLabelFontSize(48);
        marker.setTextIcon("UNAB");
        map.getOverlays().add(marker);
        mapController.setCenter(UNAB);
        mapController.setZoom(17);
        map.setMultiTouchControls(true);
    }
}