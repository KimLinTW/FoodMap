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
import android.widget.LinearLayout;
import android.widget.TextView;
import com.parse.GetCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;


import java.lang.reflect.Array;
import java.text.BreakIterator;

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
    private String name, shopname;
    private double distance = 0.0;
    private double Latitude1 = 24.44986207000755;
    private double Longitude1 = 118.32255103916933;

    private double lat = 0.0, lng = 0.0, gap = Integer.MAX_VALUE;

    private TextView shop;
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


        supbox_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            // add shop
            public void onClick(View view) {
                System.out.println("btn ok");
                supbox_btn.setVisibility(View.GONE);
                for (int n = 1; n <= 11; n++){
                    ParseQuery<ParseObject> query = ParseQuery.getQuery("Shop");
                    query.whereEqualTo("ID",n);

                    System.out.println(query);
                    query.getFirstInBackground(new GetCallback<ParseObject>() {
                        public void done(ParseObject player, ParseException e) {
                            if (e == null) {
                                System.out.println("ok:");

                                name = player.getString("shopName");
                                System.out.println(name);
                                lat = player.getParseGeoPoint("latitude_longitude").getLatitude();
                                lng = player.getParseGeoPoint("latitude_longitude").getLongitude();

                                double theta = Longitude1 - lng;
                                double distance = 60 * 1.1515 * (180/Math.PI) * Math.acos(
                                        Math.sin(Latitude1 * (Math.PI/180)) * Math.sin(lat * (Math.PI/180)) +
                                                Math.cos(Latitude1 * (Math.PI/180)) * Math.cos(lat * (Math.PI/180)) * Math.cos(theta * (Math.PI/180))
                                );
                                double kilodistance = distance / 0.6214;

                                System.out.println("距離: " + kilodistance);

                                if (kilodistance <= gap){
                                    gap = kilodistance;
                                    shopname = name;

                                    Intent intent = new Intent(getActivity(), show_restaurant.class);
                                    intent.putExtra("shopName", shopname);
                                    startActivity(intent);
                                }
                                System.out.println("最近店家:　" +shopname + "/" + gap);
                            }
                            else {
                                System.out.println("error");
                            }

                        }
                    });
                }

                //經緯座標距離運算
//                double theta = Longitude1 - Longitude2;
//                double distance = 60 * 1.1515 * (180/Math.PI) * Math.acos(
//                        Math.sin(Latitude1 * (Math.PI/180)) * Math.sin(Latitude2 * (Math.PI/180)) +
//                                Math.cos(Latitude1 * (Math.PI/180)) * Math.cos(Latitude2 * (Math.PI/180)) * Math.cos(theta * (Math.PI/180))
//                );
//                double kilodistance = distance / 0.6214;
//
//                System.out.println("距離: " + kilodistance);
            }
        });
        return view;
    }
}
