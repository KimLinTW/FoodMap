package com.example.kinmenfoodmap;


import static com.example.kinmenfoodmap.HomeFragment.listAdapter;
import static com.example.kinmenfoodmap.MainActivity.userlist;

import android.app.ProgressDialog;
import android.os.Handler;


import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.net.URL;

import java.util.ArrayList;
import java.util.List;


class fetchData extends Thread{
    Handler handler = new Handler();
    ProgressDialog progressDialog;
    int shop_amount = 11;
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
                                           // String menu = result.getString("ShopPicture");
                                            //System.out.println("感覺在這裡過不了"+menu);
                                            System.out.println("get shop:" + shopName);
                                            //  userlist.add(new HomeListMapping("https://i.imgur.com/bLuqfnQ.jpg",shopName,address));
                                            userlist.add(new HomeListMapping(shopName,address));
                                        }
                                        // Do something with result
                                    }
                                });
                            }
                            System.out.println("以下為店家列表");
                            System.out.println(userlist);

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

