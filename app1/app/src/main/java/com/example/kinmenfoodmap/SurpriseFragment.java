package com.example.kinmenfoodmap;

<<<<<<< HEAD
import android.content.Intent;
=======
>>>>>>> 6e7fe2af14e54ff5c40f3460fc911b9b9fdcce51
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
<<<<<<< HEAD
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.parse.GetCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.text.BreakIterator;
=======
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.ParseObject;
import com.parse.ParseQuery;
>>>>>>> 6e7fe2af14e54ff5c40f3460fc911b9b9fdcce51

import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseGeoPoint;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

<<<<<<< HEAD
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private TextView output;

    private double distance = 0.0;
    private double Latitude1 = 25.298218036200446;
    private double Longitude1 = 121.56814583830808;
    private double Latitude2 = 21.905662893203562;
    private double Longitude2 = 120.85092391581581;

    public SurpriseFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SurpriseFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SurpriseFragment newInstance(String param1, String param2) {
        SurpriseFragment fragment = new SurpriseFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
=======
public class SurpriseFragment extends Fragment implements View.OnClickListener {
    private String latandlng = "";

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
>>>>>>> 6e7fe2af14e54ff5c40f3460fc911b9b9fdcce51


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
<<<<<<< HEAD
        View view = inflater.inflate(R.layout.fragment_surprise, container, false);

        ImageView supbox_btn = (ImageView) view.findViewById(R.id.supbox);
        output = (TextView) view.findViewById(R.id.textView20);
        supbox_btn.setOnClickListener(new View.OnClickListener() {
=======
        View view = inflater.inflate(R.layout.fragment_favorite, container, false);
        // Inflate the layout for this fragment

        Button btn1 = (Button) view.findViewById(R.id.button2);
        Button btn2 = (Button) view.findViewById(R.id.button3);
        Button btn3 = (Button) view.findViewById(R.id.button9);
        TextView btn_add = (TextView) view.findViewById(R.id.add_db);
        TextView btn_show = (TextView) view.findViewById(R.id.show_db);

        TextView output = (TextView) view.findViewById(R.id.result_db);


        btn_add.setOnClickListener(new View.OnClickListener() {
>>>>>>> 6e7fe2af14e54ff5c40f3460fc911b9b9fdcce51
            @Override
            // add shop
            public void onClick(View view) {
<<<<<<< HEAD
                System.out.println("btn ok");
                ParseQuery<ParseObject> query = ParseQuery.getQuery("Shop");
                query.whereEqualTo("shopName", "金食堂");

                System.out.println(query);
                query.getFirstInBackground(new GetCallback<ParseObject>() {
                    public void done(ParseObject player, ParseException e) {
                        if (e == null) {
                            System.out.println("ok:");
                            String response="";// lat = "", lng = "";
                            response += player.getString("shopName");
                            response += "\n";
                            response += player.getString("ID");
                            response += "\n";
                            response += player.getString("address");
                            response += "\n";
                            response += player.getList("menu");
                            response += "\n";
                            response += player.getString("closing");
                            response += "\n";
                            response += player.getString("business");
                            response += "\n";
                            response += player.getParseGeoPoint("latitude_longitude");
                            response += "\n";

                            //lat += player.getParseGeoPoint("latitude_longitude").getLatitude();
                            //lng += player.getParseGeoPoint("latitude_longitude").getLongitude();
                            //latlng += player.getParseGeoPoint("latitude_longitude");

                            System.out.println(response);
                            output.setText(response);
                        } else {
                            System.out.println("error");
                        }

                    }
                });
                //經緯座標距離運算
                double theta = Longitude1 - Longitude2;
                double distance = 60 * 1.1515 * (180/Math.PI) * Math.acos(
                        Math.sin(Latitude1 * (Math.PI/180)) * Math.sin(Latitude2 * (Math.PI/180)) +
                                Math.cos(Latitude1 * (Math.PI/180)) * Math.cos(Latitude2 * (Math.PI/180)) * Math.cos(theta * (Math.PI/180))
                );
                double kilodistance = distance / 0.6214;

                System.out.println("距離: " + kilodistance);
            }
        });
        return view;
    }
}
=======
                ParseQuery<ParseObject> query = ParseQuery.getQuery("FirstClass");
                query.whereEqualTo("objectId", "0mfC6T5HHR");

            }
        });

        btn_show.setOnClickListener(new View.OnClickListener() {
            @Override
            // show app
            public void onClick(View view) {

                ParseQuery<ParseObject> query = ParseQuery.getQuery("Shop");
                query.whereEqualTo("shopName", "金食堂");

                query.getFirstInBackground(new GetCallback<ParseObject>() {
                    public void done(ParseObject player, ParseException e) {
                        if (e == null) {
                            System.out.println("ok:");
                            String response="", lat = "", lng = "";
                            response += player.getString("shopName");
                            response += "\n";
                            response += player.getString("ID");
                            response += "\n";
                            response += player.getString("address");
                            response += "\n";
                            response += player.getList("menu");
                            response += "\n";
                            response += player.getString("closing");
                            response += "\n";
                            response += player.getString("business");
                            response += "\n";
                            response += player.getParseGeoPoint("latitude_longitude");
                            response += "\n";


                            lat += player.getParseGeoPoint("latitude_longitude").getLatitude();
                            lng += player.getParseGeoPoint("latitude_longitude").getLongitude();
                            //latlng += player.getParseGeoPoint("latitude_longitude");

                            System.out.println(response);
                            output.setText(lat + "\n" + lng);
                        } else {
                            System.out.println("error");
                        }
                    }
                });


                System.out.println("^^^^^^^^^^^^^^^^^^^^^^");
                latandlng = output.getText().toString();
                System.out.println(latandlng);
                //output.setText(response);

            }
        });


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                output.setText("Button 1");

            }
        });
        btn2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                output.setText("Button 2");

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
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ParseQuery<ParseObject> query = ParseQuery.getQuery("login");
                query.whereEqualTo("user_name", "test");
                query.getFirstInBackground(new GetCallback<ParseObject>() {
                    public void done(ParseObject player, ParseException e) {
                        if (e == null) {
                            System.out.println("ok:");
                            String response = "";
                            response += player.getString("hash_pass");
                            System.out.println(response);
                        }
                    }
                });

                MessageDigest md = null;
                try {
                    md = MessageDigest.getInstance("SHA-1");
                } catch (NoSuchAlgorithmException e) {
                    e.printStackTrace();
                }
                byte[] passbyte = new byte[0];
                try {
                    passbyte = "abcdef12".getBytes("UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                passbyte = md.digest(passbyte);
                StringBuilder sb = new StringBuilder();
                for (byte b : passbyte) {
                    sb.append(String.format("%02x", b));
                }

            }
        });



        return view;
    }



    public void button_Click(View view){
//        TextView output = (TextView)findViewById(R.id.show_db);
    }

    @Override
    public void onClick(View view) {
        System.out.println("跳跳出來");
        ParseQuery<ParseObject> query = ParseQuery.getQuery("Shop");

        // The query will search for a ParseObject, given its objectId.
        // When the query finishes running, it will invoke the GetCallback
        // with either the object, or the exception thrown
        query.getInBackground("<PARSE_OBJECT_ID>", (object, e) -> {
            if (e == null) {
                //Object was successfully retrieved
            } else {
                // something went wrong
                System.out.println("有東西");
               // Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        //TextView output = (TextView)getView().findViewById(R.id.show_db);
        // 點擊[view]顯示一些東西   問題:找不到findViewById ->  import androidx.appcompat.app.AppCompatActivity;未生效 原因: 不知道??
        // 在MainActivity.java import 有生效 -> findViewById 功能也正常
//        output_db = output_db.findViewById(R.id.show_db);
//        output_db.setText("123");
    }

}
>>>>>>> 6e7fe2af14e54ff5c40f3460fc911b9b9fdcce51
