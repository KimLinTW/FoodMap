package com.example.kinmenfoodmap;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;


import com.google.android.gms.maps.model.LatLng;
import com.example.kinmenfoodmap.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements LocationListener {
    private static final int PERMISSION_REQUEST_GPS = 101;
    public static ArrayList<HomeListMapping> userlist = new ArrayList<HomeListMapping>();
    public  static  ArrayList<LatLng> list = new ArrayList<>();
    public  static  ArrayList<String> MapName = new ArrayList<>();
    //public  static
    private LocationManager lc;
    private Double lat = 0.0;
    private Double lng = 0.0;

    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //GPS位置取得
        lc = (LocationManager) getSystemService(LOCATION_SERVICE);
        if(!lc.isProviderEnabled(LocationManager.GPS_PROVIDER)){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("定位管理").setMessage("GPS目前未啟用").setPositiveButton("確定", null).create().show();
        }
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M &&
                checkSelfPermission(
                        Manifest.permission.ACCESS_FINE_LOCATION) !=
                        PackageManager.PERMISSION_GRANTED){
            requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    PERMISSION_REQUEST_GPS);
        }

        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new HomeFragment());


        binding.menu.setOnItemSelectedListener(item -> {

            switch (item.getItemId())
            {
                case R.id.item1:
                    replaceFragment(new HomeFragment());
                    break;
                case  R.id.item2:
                    replaceFragment(new searchFragment());
                    break;
                case  R.id.item3:
                    replaceFragment(new SurpriseFragment());
                    break;
                case  R.id.item4:
                    replaceFragment(new favoriteFragment());
                    break;
                case  R.id.item5:
                    replaceFragment(new accFragment());
                    break;

            }
            return  true;
        });
    }

    private  void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.menu_layout,fragment);
        fragmentTransaction.commit();
    }

    @Override //詢問GPS使用權限
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == PERMISSION_REQUEST_GPS){}
    }

    @Override //更新GPS座標位置
    protected void onResume() {
        super.onResume();
        int minTime = 1000;
        float minDistance = 1;
        try{
            String best = lc.getBestProvider(new Criteria(), true);
            if(best != null){
                lc.requestLocationUpdates(best, minTime, minDistance, this);
            }
            else{}
        }catch (SecurityException ex){Log.e("GPS位置", "GPS權限失敗" + ex.getMessage());}
    }
    @Override
    protected void onPause() {
        super.onPause();
        try{lc.removeUpdates(this);}
        catch (SecurityException ex){Log.e("GPS位置", "GPS權限失敗" + ex.getMessage());}
    }

    @Override
    public void onLocationChanged(@NonNull Location location) {
        if(location != null){
            lat = location.getLatitude();
            lng = location.getLongitude();
        }

    }

}

// 到這邊 分配工作
/*
1. xml設計
    a. 分頁功能 ------------------------------- Done
    b. 基本元件(id)
    c. 美觀

2. 主程式
    a. 實作每個元件對應的功能
    b. 跟地圖連接
    c. 跟資料庫連接 (58 林廣哲)
    d. 把東西(喜愛店家)存在使用者的裝置上?
    e. 實作一個可以方便建立大量店家的API
    f. 紀錄店家被查看的次數 並 統計

*/