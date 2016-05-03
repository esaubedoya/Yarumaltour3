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
public class CorregimientosFragment extends Fragment {

    private GoogleMap mMap;
    MapView mapView;
    public CorregimientosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vCor= inflater.inflate(R.layout.fragment_corregimientos, container, false);
        mapView = (MapView) vCor.findViewById(R.id.mapCor);
        mapView.onCreate(savedInstanceState);
        mMap = mapView.getMap();
        mMap.getUiSettings().setMyLocationButtonEnabled(true);
        mMap.getUiSettings().setZoomControlsEnabled(true);
        if (ActivityCompat.checkSelfPermission(getContext(), android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getContext(), android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return null;
        }
        mMap.setMyLocationEnabled(true);
        MapsInitializer.initialize(this.getActivity());

        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(new LatLng(6.964020570822741, -75.41935995), 10);
        mMap.animateCamera(cameraUpdate);
        LatLng lced = new LatLng(7.070745869959349,-75.3540392857056);
        mMap.addMarker(new MarkerOptions().position(lced).title("Cedeño").snippet("Corregimiento - población"));
        LatLng lllanos = new LatLng(6.814514961656428,-75.486314141922);
        mMap.addMarker(new MarkerOptions().position(lllanos).title("Llanos de Cuivá").snippet("Corregimiento - población"));
        LatLng lochali = new LatLng(7.0031896427557125,-75.61163305611267);
        mMap.addMarker(new MarkerOptions().position(lochali).title("Ochalí").snippet("Corregimiento - población"));
        return vCor;

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
