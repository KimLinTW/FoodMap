package com.example.kinmenfoodmap;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.kinmenfoodmap.databinding.FragmentSearchBinding;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

import java.util.ArrayList;

public class searchFragment extends Fragment  {
    private GoogleMap mMap;
    private FragmentSearchBinding binding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search,container,false);
         SupportMapFragment supportMapFragment = (SupportMapFragment)
                getChildFragmentManager().findFragmentById(R.id.map);

         supportMapFragment.getMapAsync(new OnMapReadyCallback() {
             @Override
             public void onMapReady(@NonNull GoogleMap googleMap) {
                 mMap = googleMap;
                 ArrayList<LatLng> list = MapData.getPositions();//抓MapData(位置)資料
                 ArrayList<String> list_de = MapDataDetail.getPositions();//抓MapDataDetail(內容)資料

                int i = 0 ;
                 for (LatLng latLng:list)//list有多少撈多少
                 {
                     MarkerOptions options = new MarkerOptions();
                     options.position(latLng);//之後位置API要抓這裡
                     options.title("餐館");//之後可以依照餐廳不同來增加類別
                     options.snippet(list_de.get(i));
                     options.alpha(0.9f);
                     options.anchor(0.5f,0.5f);
                     options.draggable(false);
                     options.flat(false);
                     options.icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_bus));//地點圖標之後可以改
                     googleMap.addMarker(options);
                     i++;
                 }

                moveCamara();
             }
         });
         return  view;

          }


    protected GoogleMap getMap() {
        return mMap;
    }


    private void moveCamara() {
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        //
        ArrayList<LatLng> list = MapData.getPositions();
        for (LatLng latlng : list) {
            builder.include(latlng);
        }
        //
        LatLngBounds bounds = builder.build();
        //
        getMap().animateCamera(CameraUpdateFactory.newLatLngBounds(bounds, 50), 3000, null);
    }


}

   /* @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        googleMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(@NonNull LatLng latLng) {
                MarkerOptions markerOptions = new MarkerOptions();
                markerOptions.position(latLng);
                markerOptions.title("GGGGGGG");
                googleMap.clear();
                googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(
                        latLng ,10
                ));
                googleMap.addMarker(markerOptions);
            }
        });
    }*/