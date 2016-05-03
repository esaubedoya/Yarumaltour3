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
public class ReligionFragment extends Fragment {

    private GoogleMap mMap;
    MapView mapView;
    public ReligionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vReligion= inflater.inflate(R.layout.fragment_religion, container, false);
        mapView = (MapView) vReligion.findViewById(R.id.mapReligion);
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
        LatLng liglesia = new LatLng(6.963506723292658,-75.41660666244621);
        mMap.addMarker(new MarkerOptions().position(liglesia).title("Basílica").snippet("Nuestra señora de las Mercedes"));
        LatLng lsemis = new LatLng(6.956171688139505,-75.41830852406616);
        mMap.addMarker(new MarkerOptions().position(lsemis).title("Semisiones").snippet("Seminario de misiones extranjeras"));
        LatLng lsema = new LatLng(6.9462352618147865,-75.42383923905487);
        mMap.addMarker(new MarkerOptions().position(lsema).title("Seminario").snippet("Cristo sacerdote"));
        return vReligion;

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