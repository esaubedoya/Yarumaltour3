package com.bedoya.esau.yarumaltour3;


import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


/**
 * A simple {@link Fragment} subclass.
 */
public class AmajariFragment extends Fragment {

    private GoogleMap mMap;
    MapView mapView;
    public AmajariFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vAmajari=inflater.inflate(R.layout.fragment_amajari, container, false);
        mapView = (MapView) vAmajari.findViewById(R.id.mapAmajari);
        mapView.onCreate(savedInstanceState);
        mMap = mapView.getMap();
        mMap.getUiSettings().setMyLocationButtonEnabled(true);
        mMap.getUiSettings().setZoomControlsEnabled(true);
        if (ActivityCompat.checkSelfPermission(getContext(), android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getContext(), android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return null;
        }
        mMap.setMyLocationEnabled(true);
        MapsInitializer.initialize(this.getActivity());

        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(new LatLng(6.962694017695108,-75.41726849752064), 15);
        mMap.animateCamera(cameraUpdate);
        LatLng lamaja = new LatLng(6.962694017695108,-75.41726849752064);
        mMap.addMarker(new MarkerOptions().position(lamaja).title("Hotel Amajari").snippet("Hotel  y restaurante"));
        return vAmajari;

    }

    @Override
    public void onResume() {
        mapView.onResume();
        super.onResume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

}