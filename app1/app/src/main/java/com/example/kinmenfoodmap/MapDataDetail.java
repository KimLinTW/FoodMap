package com.example.kinmenfoodmap;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

public class MapDataDetail {

    public static final String POSITION_TAIPEI101 = new String("101");
    // 台北火車站
    public static final String POSITION_TAIPEI_TRAIN_STATION = new String("轉運站");
    // 國立台灣博物館
    public static final String POSITION_NATIONAL_TAIWAN_MUSEUM = new String("博物館");
    // 墾丁
    public static final String POSITION_KENTING = new String("墾丁");
    // 日月潭
    public static final String POSITION_ZINTUN = new String("阿災");

    public static ArrayList<String> getPositions() {

        ArrayList<String> list = new ArrayList<>();
        list.add(POSITION_TAIPEI101);
        list.add(POSITION_TAIPEI_TRAIN_STATION);
        list.add(POSITION_NATIONAL_TAIWAN_MUSEUM);
        list.add(POSITION_KENTING);
        list.add(POSITION_ZINTUN);
        return list;
    }
}
