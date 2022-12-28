package com.example.kinmenfoodmap;

import static com.example.kinmenfoodmap.MainActivity.MapName;
import static com.example.kinmenfoodmap.MainActivity.list;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import com.example.kinmenfoodmap.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

public class searchFragment extends Fragment  {
    private GoogleMap mMap;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search,container,false);
        SupportMapFragment supportMapFragment = (SupportMapFragment)
                getChildFragmentManager().findFragmentById(R.id.map);
        Button searchmapbutton = view.findViewById(R.id.searchmapbutton);
        EditText textView = (EditText) view.findViewById(R.id.searchtext);


        searchmapbutton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                //這裡之後要想辦法清除圖釘
                System.out.println("近來沒問題"+textView.getText().toString());
                int count = 0;
                int get=-1;
                for (String element : MapName){
                    if (element.contains(textView.getText().toString())){
                        get = count;
                        //System.out.println("有找到喔"+list.get(get));
                        //System.out.println("看看get是幾"+get);
                        //System.out.println("要看看MapName有沒有對上"+MapName);
                        //System.out.println("list要看看有沒有對上"+list);
                        newmoveCamara(get);
                        return;
                    }
                    count++;
                }
                if(get==-1)
                    System.out.println("找不到哈哈哈");
            }
        });



        supportMapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(@NonNull GoogleMap googleMap) {
                mMap = googleMap;

                // ArrayList<LatLng> list = MapData.getPositions();//抓MapData(位置)資料
                // ArrayList<String> list_de = MapDataDetail.getPositions();//抓MapDataDetail(內容)資料
                System.out.println("緯度在哪裡"+list);

                int i = 0 ;
                for (LatLng latLng:list)//list有多少撈多少
                {
                    MarkerOptions options = new MarkerOptions();
                    options.position(latLng);//之後位置API要抓這裡//先抓緯度在抓精度
                    options.title("餐館");//之後可以依照餐廳不同來增加類別
                    options.snippet(MapName.get(i));//說明 目前是放餐廳
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
        //ArrayList<LatLng> list = MapData.getPositions();
        for (LatLng latlng : list) {
            builder.include(latlng);
        }
        //
        LatLngBounds bounds = builder.build();
        //
        getMap().animateCamera(CameraUpdateFactory.newLatLngBounds(bounds, 50), 3000, null);
    }

    private void newmoveCamara(int get) {
        LatLng sydney = list.get(get);
        System.out.println("sydney是到這裡嗎？"+sydney);
        mMap.addMarker(new MarkerOptions().position(sydney).title("MapName.get(get)"));//新增圖釘
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

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