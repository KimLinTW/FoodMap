package com.example.kinmenfoodmap;

import android.location.Location;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.parse.Parse;
import com.parse.ParseObject;

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
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_surprise, container, false);

        ImageView img_btn = (ImageView) view.findViewById(R.id.supbox);

        img_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double theta = Longitude1 - Longitude2;
                double distance = 60 * 1.1515 * (180/Math.PI) * Math.acos(
                        Math.sin(Latitude1 * (Math.PI/180)) * Math.sin(Latitude2 * (Math.PI/180)) +
                                Math.cos(Latitude1 * (Math.PI/180)) * Math.cos(Latitude2 * (Math.PI/180)) * Math.cos(theta * (Math.PI/180))
                );
                double kilodistance = distance / 0.6214;

                System.out.println("距離" + kilodistance);
            }
        });

        return view;
    }

    public void onClick(View view){
        return ;
    }


}