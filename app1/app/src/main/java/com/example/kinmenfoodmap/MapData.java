package com.example.kinmenfoodmap;

import static com.example.kinmenfoodmap.MainActivity.list;

import android.app.ProgressDialog;

import com.google.android.gms.maps.model.LatLng;
import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
//過渡期的檔案,沒用了
public class MapData {
    // ArrayList<HomeListMapping> userlist = new ArrayList<HomeListMapping>();
    // 台北101
    public static final LatLng POSITION_TAIPEI101 = new LatLng(25.033611, 121.565000);
    // 台北火車站
    public static final LatLng POSITION_TAIPEI_TRAIN_STATION = new LatLng(25.047924, 121.517081);
    // 國立台灣博物館
    public static final LatLng POSITION_NATIONAL_TAIWAN_MUSEUM = new LatLng(25.042902, 121.515030);
    // 墾丁
    public static final LatLng POSITION_KENTING = new LatLng(21.946567, 120.798713);
    // 日月潭
    public static final LatLng POSITION_ZINTUN = new LatLng(23.851676, 120.902008);

    public static ArrayList<LatLng> getPositions() {



        // list.add(POSITION_TAIPEI101);
        //list.add(POSITION_TAIPEI_TRAIN_STATION);
        //list.add(POSITION_NATIONAL_TAIWAN_MUSEUM);
        //list.add(POSITION_KENTING);
        //list.add(POSITION_ZINTUN);
        //System.out.println("看看list"+list);
        return list;
    }





}