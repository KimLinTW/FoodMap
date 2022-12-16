package com.example.kinmenfoodmap;

import android.app.ProgressDialog;

import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.net.URL;
import java.util.List;


/*class fetchData extends Thread{
    String data = "";
    @Override
    public void run() {
        // System.out.println("現在跑到這裡沒問題");
        URL url;


        try {
            System.out.println("第一個要看到");
            ParseQuery<ParseObject> query = new ParseQuery<>("Shop");
            query.findInBackground(new FindCallback<ParseObject>() {
                public void done(List<ParseObject> objects, ParseException e) {
                    if (e == null) {
                            /* System.out.println("object是什"+objects);
                            String str="";
                            str+=objects.toString();
                            System.out.println("看這裡"+str);
                        if (userlist.size() > shop_amount)

                            userlist.clear();

                        for (int k = 0; k < shop_amount; k++) {
                            ParseObject parseObject = objects.get(k); // Get the object
                            parseObject.fetchIfNeededInBackground(new GetCallback<ParseObject>() {
                                public void done(ParseObject result, ParseException e) {
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

//            }
        }catch( Exception e){

            System.out.println(e);

        }



    }
}*/
