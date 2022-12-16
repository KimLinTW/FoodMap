package com.example.kinmenfoodmap;


import android.app.Activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.kinmenfoodmap.databinding.ActivityMainBinding;
import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;

import com.parse.ParseObject;
import com.parse.ParseQuery;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;
import java.util.concurrent.TimeUnit;


public class HomeFragment extends Fragment {


    ArrayList<HomeListMapping> userlist = new ArrayList<HomeListMapping>();
    ActivityMainBinding binding;
  //  ArrayList<String> userlist;
    HomeAdapter listAdapter;

    Handler handler = new Handler();
    ProgressDialog progressDialog;
    int shop_amount = 11;
    int threadflag = 0;
    int viewflag = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        Button btn1 = (Button) view.findViewById(R.id.button);
        ListView list1 = (ListView)view.findViewById(R.id.userlist);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        //setContentView(binding.getRoot());
        //items = getActivity().getResources().getString(R.id.userlist);
        userlist = new ArrayList<>();

        listAdapter = new HomeAdapter((Activity) view.getContext(),userlist);
        list1.setAdapter(listAdapter);


        //  initialUserlist();

//        new fetchData().start();
//        while(userlist.size() == 0){
//            try{
//                System.out.println("waiting for db");
//                TimeUnit.SECONDS.sleep(5);
//                new fetchData().start();
//            }catch (Exception e){
//                System.out.println("error while creating");
//            }
//        }
        new thread2().start();
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //listAdapter.notifyDataSetChanged();
            }
        });


        return view;
    }



    class thread2 extends Thread{

        @Override
        public void run() {
            while(userlist.size() == 0){
            try{
                System.out.println("waiting for db");
                TimeUnit.SECONDS.sleep(5);
                if(threadflag==0)
                {
                    System.out.println("thread是給0所以進來");//讓threas2睡一下,東西出來再叫他
                    new fetchData().start();
                    threadflag=1;
                }

            }catch (Exception e){
                System.out.println("error while creating");
            }
            }

            System.out.println("終於跳出來");
            System.out.println("看看這個list是什麼"+userlist);

           // listAdapter.notifyDataSetChanged();
         //  new fetchData().start();

           // listAdapter.notifyDataSetChanged();

        }


    }


    class fetchData extends Thread{
        String data = "";
        @Override
        public void run() {
            // System.out.println("現在跑到這裡沒問題");
            URL url;
            handler.post(new Runnable() {
                @Override
                public void run() {
                    System.out.println("看看handler的狀態");
                        progressDialog = new ProgressDialog(getActivity());
                        progressDialog.setMessage("Fetching");
                        progressDialog.show();
                    }
            });

            try {
                System.out.println("第一個要看到");
                ParseQuery<ParseObject> query = new ParseQuery<>("Shop");
                query.findInBackground(new FindCallback<ParseObject>() {
                    public void done(List<ParseObject> objects, ParseException e) {
                        System.out.println("等這裡吧");
                        if (e == null) {
                            /* System.out.println("object是什"+objects);
                            String str="";
                            str+=objects.toString();
                            System.out.println("看這裡"+str);*/
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


            }catch( Exception e){

                System.out.println(e);

            }


            handler.post(new Runnable() {
                @Override
                public void run() {
                    if(progressDialog.isShowing())
                    {
                        progressDialog.dismiss();

                        //  System.out.println("看得到嗎嗎嗎？"+listAdapter);
                        System.out.println("這裡一定會跑到");
                       listAdapter.notifyDataSetChanged();
                        //   System.out.println("看得到？"+listAdapter);

                    }
                }
            });
        }

    }


}

//https://stackoverflow.com/questions/313

