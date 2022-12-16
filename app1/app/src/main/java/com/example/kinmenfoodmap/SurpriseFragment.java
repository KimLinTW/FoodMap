package com.example.kinmenfoodmap;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
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

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SurpriseFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SurpriseFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

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
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_surprise, container, false);
        ImageView btn_ImageView = (ImageView) view.findViewById(R.id.supbox);
        TextView output = (TextView) view.findViewById(R.id.textView20);
        btn_ImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
            }
        });

        return inflater.inflate(R.layout.fragment_surprise, container, false);
    }
}
