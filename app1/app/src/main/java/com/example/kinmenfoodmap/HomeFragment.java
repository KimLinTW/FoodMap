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
    int shop_amount = 10;

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
                new fetchData().start();
            }
        });


        return view;
    }


    private void initialUserlist() {
//        userlist = new ArrayList<>();
        //listAdapter = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.); //.support_simple_spinner_dropdown_item,userlist);
        //userlist = new ArrayList<>();
        //System.out.println("init只會有一次吧");
    }


    class thread2 extends Thread{
        @Override
        public void run() {
            while(userlist.size() == 0){
                try{
                    System.out.println("waiting for db");
                    TimeUnit.SECONDS.sleep(5);
                    new fetchData().start();
                    if (userlist.size() > shop_amount) userlist.subList(0,shop_amount);
                }catch (Exception e){
                    System.out.println("error while creating");
                }
            }
            if (userlist.size() > shop_amount){
                userlist.subList(0,shop_amount);
            }
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

                                              userlist.add(new HomeListMapping("https://i.imgur.com/bLuqfnQ.jpg",shopName,address));
                                           // userlist.add(new HomeListMapping(shopName,address));

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

               /*  這是只找一個的方式
                    query.getFirstInBackground(new GetCallback<ParseObject>() {
                        @Override
                        public void done(ParseObject object, ParseException e) {
                            if(e==null)
                            {
                                String str="";
                                str+=object.getString("shopName");
                                System.out.println("看這裡"+str);
                                //object.getJSONObject("")
                            }
                            else
                            {
                                System.out.println("error");
                            }
                        }
                    });*/


//                url = new URL("");//http://10.0.2.2:5000/api/Books
//                HttpURLConnection httpsURLConnection = (HttpURLConnection) url.openConnection();
//                InputStream inputStream = httpsURLConnection.getInputStream();
//                //System.out.println("Input是什麼"+inputStream);
//
//                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
//                String line;
//                //System.out.println("line是空的？");
//
//                //如果buffReader沒有讀到空的就繼續
//                while ((line = bufferedReader.readLine()) != null) {
//                    System.out.println("有道line" + data);
//                    data = data + line;
//                    System.out.println("data" + data);
//                }
//                //如果data不是空的，就把data抓進Json放到userlist
//
//                if (!data.isEmpty()) {
//                    //System.out.println("");
//                    //JSONObject jsonObject = new JSONObject(data);
//                    JSONArray jsonArray = new JSONArray(data);
//                    userlist.clear();
//                    for (int j = 0; j < jsonArray.length(); j++) {//10上線需要改
//                        JSONObject jsonobject = jsonArray.getJSONObject(j);
//                        String name = jsonobject.getString("name");
//                        System.out.println("這裡要看到name" + name);
//                        userlist.add(name);
//                        System.out.println("這裡的userlist" + userlist);
//                    }
//                    //等等資料近來這裡
//                } else {
//                    System.out.println("到這裡就ＧＧ了");
//                }
//            } catch (MalformedURLException e) {
//                System.out.println("1");
//                e.printStackTrace();
//            } catch (IOException e) {
//                System.out.println("2");
//                e.printStackTrace();
//            } catch (JSONException e) {
//                System.out.println("3");
//                e.printStackTrace();
//            }
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
                        listAdapter.notifyDataSetChanged();
                        //   System.out.println("看得到？"+listAdapter);
                    }
                }
            });
        }
    }


}
//https://stackoverflow.com/questions/313