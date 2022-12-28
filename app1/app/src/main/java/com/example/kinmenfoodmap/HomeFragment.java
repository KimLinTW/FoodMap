package com.example.kinmenfoodmap;


import static com.example.kinmenfoodmap.MainActivity.userlist;

import android.app.Activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

<<<<<<< HEAD
=======
import android.os.Handler;
>>>>>>> 27ac072c81b4b22ddb24740b2c864dfdc44a6961
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
<<<<<<< HEAD
import android.widget.TextView;

import com.parse.ParseObject;
=======
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

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

>>>>>>> 27ac072c81b4b22ddb24740b2c864dfdc44a6961

public class HomeFragment extends Fragment {





    ActivityMainBinding binding;
  //  ArrayList<String> userlist;
   public static HomeAdapter listAdapter;




   public static int threadflag = 0;

    int viewflag = 0;

    @Override
<<<<<<< HEAD
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//      vvvvvvvvvvvvvvvvvvvvvv  example: add something to remoted database   vvvvvvvvvvvvvvvvvvvvvvvvvvvv
        ParseObject firstObject = new ParseObject("FirstClass");
        firstObject.put("message","Hey ! First message from android. Parse is now connected");
        firstObject.saveInBackground(e -> {
            if (e != null){
                Log.e("MainActivity", e.getLocalizedMessage());
            }else{
                Log.d("MainActivity","Object saved.");
            }
        });
//      ^^^^^^^^^^^^^^^^^^^^^^  example: add something to remoted database   ^^^^^^^^^^^^^^^^^^^^^^^^^^^

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
=======
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);


        Button btn1 = (Button) view.findViewById(R.id.button);
        Button btn_add = (Button) view.findViewById(R.id.add_shop_btn);
        ListView list1 = (ListView)view.findViewById(R.id.userlist);
//        ExpandableListView list1 = (ExpandableListView) view.findViewById(R.id.userlist);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        //setContentView(binding.getRoot());
        //items = getActivity().getResources().getString(R.id.userlist);


        listAdapter = new HomeAdapter((Activity) view.getContext(),userlist);
        list1.setAdapter(listAdapter);
        System.out.println("讓我看看userlist狀態"+userlist.size());
        if(userlist.size()==0)
        {
            new fetchData().start();//userlist沒東西時才需要去抓資料
>>>>>>> 27ac072c81b4b22ddb24740b2c864dfdc44a6961
        }



        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("看看"+userlist.size());
                listAdapter.notifyDataSetChanged();
            }
        });

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), add_store.class);
                startActivity(intent);
            }
        });





        // 獲取 ListView 的引用
        ListView listView = (ListView) view.findViewById(R.id.userlist);
// 設置點擊事件的監聽器
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                View test_view = inflater.inflate(R.layout.fragment_home,null);
//                String item = (String) parent.getItemAtPosition(position).toString();
//                System.out.println(item.toString());
                TextView textView19 = (TextView) test_view.findViewById(R.id.textView19);
                System.out.println(textView19);
                String shop_name = userlist.get(position).getmName();
                Toast.makeText(getContext(), "You clicked on: " + shop_name, Toast.LENGTH_SHORT).show();
                textView19.setText(shop_name);
                textView19.setText("123");
                System.out.println("19:");
                System.out.println(textView19.getText().toString());
                TextView textView2 = (TextView) view.findViewById(R.id.textView19); //null
                System.out.println(textView2);

            }

        });
        TextView textView2 = (TextView) view.findViewById(R.id.textView19);
        System.out.println(textView2);




//        ExpandableListView listView = (ExpandableListView) view.findViewById(R.id.userlist);
//
//
//        listView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
//            @Override
//            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) { //childPosition代表著要接收的數組的列數
//                if (groupPosition==0){//groupPosition代表著要接收的數組的行數
//                    System.out.println("113");
//                }else if (groupPosition==1){
//                    System.out.println("115");
//                }
//                return true;
//            }
//        });

        return view;
    }


<<<<<<< HEAD
}
=======


    /*class thread2 extends Thread{


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

           new fetchData().start();


           // listAdapter.notifyDataSetChanged();

        }




    }*/


    /*class fetchData extends Thread{
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


    }*/



}

//https://stackoverflow.com/questions/313

>>>>>>> 27ac072c81b4b22ddb24740b2c864dfdc44a6961
