package com.example.kinmenfoodmap;


import static com.example.kinmenfoodmap.HomeFragment.listAdapter;
import static com.example.kinmenfoodmap.MainActivity.MapName;
import static com.example.kinmenfoodmap.MainActivity.list;
import static com.example.kinmenfoodmap.MainActivity.userlist;

import android.app.ProgressDialog;
import android.os.Handler;


import com.google.android.gms.maps.model.LatLng;
import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseGeoPoint;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.net.URL;

import java.util.ArrayList;
import java.util.List;


class fetchData extends Thread{
    Handler handler = new Handler();
    ProgressDialog progressDialog;
    int shop_amount = 10;
    String data = "";
    @Override
    public void run() {
        System.out.println("現在跑到這裡沒問題");
        URL url;

        try {
            System.out.println("第一個要看到");
            ParseQuery<ParseObject> query = new ParseQuery<>("Shop");//這邊抓很久,要考慮如果抓不到的時候要讓他重新抓一次
            query.findInBackground(new FindCallback<ParseObject>() {
                public void done(List<ParseObject> objects, ParseException e) {
                    System.out.println("等這裡吧");
                    if (e == null) {
                        System.out.println("object是什"+objects);
                        String str="";
                        str+=objects.toString();
                        System.out.println("看這裡"+str);
                        if (userlist.size() > shop_amount)
                            userlist.clear();
                        for (int k = 0; k < shop_amount; k++) {
                            ParseObject parseObject = objects.get(k); // 所以這邊被拖到
                            parseObject.fetchIfNeededInBackground(new GetCallback<ParseObject>() {
                                public void done(ParseObject result, ParseException e) {
                                    System.out.println("這邊跑比較久");
                                    if (e == null) {
                                        String shopName = result.getString("shopName");
                                        String address = result.getString("address");
                                        LatLng storelocation = new LatLng(parseObject.getParseGeoPoint("latitude_longitude").getLatitude(),parseObject.getParseGeoPoint("latitude_longitude").getLongitude());
                                        // String pos = result.getString("latitude_longitude");
                                        // String menu = result.getString("ShopPicture");
                                        //System.out.println("感覺在這裡過不了"+menu);
                                        // System.out.println("pos抓的到？:" + storelocation);
                                        System.out.println("get shop:" + shopName);
                                        list.add(storelocation);
                                        MapName.add(shopName);
                                        //  userlist.add(new HomeListMapping("https://i.imgur.com/bLuqfnQ.jpg",shopName,address));
                                        userlist.add(new HomeListMapping(shopName,address));
                                    }
                                    // Do something with result
                                }
                            });
                        }
                        System.out.println("以下為店家列表");
                        // System.out.println(userlist);

                    } else {
                        //objectRetrievalFailed();
                        System.out.println("GGGGGGG");
                    }
                }
            });


        }catch( Exception e){

            System.out.println(e);

        }



    }

}
//看看list[lat/lng: (25.033611,121.565), lat/lng: (25.047924,121.517081), lat/lng: (25.042902,121.51503), lat/lng: (21.946567,120.798713), lat/lng: (23.851676,120.902008)]