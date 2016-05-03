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
public class AventuraFragment extends Fragment {

    private GoogleMap mMap;
    MapView mapView;
    public AventuraFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vAven= inflater.inflate(R.layout.fragment_aventura, container, false);
        mapView = (MapView) vAven.findViewById(R.id.mapAventura);
        mapView.onCreate(savedInstanceState);
        mMap = mapView.getMap();
        mMap.getUiSettings().setMyLocationButtonEnabled(true);
        mMap.getUiSettings().setZoomControlsEnabled(true);
        if (ActivityCompat.checkSelfPermission(getContext(), android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getContext(), android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return null;
        }
        mMap.setMyLocationEnabled(true);
        MapsInitializer.initialize(this.getActivity());

        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(new LatLng(6.964020570822741, -75.41935995), 12);
        mMap.animateCamera(cameraUpdate);
        LatLng puente = new LatLng(6.939653461889365,-75.38150861638184);
        mMap.addMarker(new MarkerOptions().position(puente).title("Mallarino - puente piedra").snippet("Balnearios, camping"));
        LatLng llacruz = new LatLng(6.970011, -75.410245);
        mMap.addMarker(new MarkerOptions().position(llacruz).title("Marconi").snippet("Base militar - la cruz"));
        LatLng lboque = new LatLng(6.998905, -75.349645);
        mMap.addMarker(new MarkerOptions().position(lboque).title("Alto de boquerón").snippet("Cerro, aventura"));
        return vAven;

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