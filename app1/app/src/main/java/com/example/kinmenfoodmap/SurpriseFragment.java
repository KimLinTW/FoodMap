package com.example.kinmenfoodmap;


import android.content.Intent;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.parse.GetCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.text.BreakIterator;

import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.ParseObject;
import com.parse.ParseQuery;


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
public class SurpriseFragment extends Fragment {
    // TODO: Rename and change types of parameters
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
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



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_surprise, container, false);

        ImageView supbox_btn = (ImageView) view.findViewById(R.id.supbox);
        output = (TextView) view.findViewById(R.id.textView20);
        supbox_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            // add shop
            public void onClick(View view) {
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
