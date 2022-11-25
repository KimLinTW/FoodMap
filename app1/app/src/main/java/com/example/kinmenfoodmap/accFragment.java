package com.example.kinmenfoodmap;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link accFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class accFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public accFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment accFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static accFragment newInstance(String param1, String param2) {
        accFragment fragment = new accFragment();
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

        View view = inflater.inflate(R.layout.fragment_acc, container, false);
        // Inflate the layout for this fragment
        System.out.println("這裡嗎");
        Button btn1 = (Button) view.findViewById(R.id.btn_record);
        Button btn2 = (Button) view.findViewById(R.id.btn_person);
        Button btn3 = (Button) view.findViewById(R.id.btn_discount);
        Button btn4 = (Button) view.findViewById(R.id.btn_background);
        Button btn5 = (Button) view.findViewById(R.id.btn_scoreapp);
        Button btn6 = (Button) view.findViewById(R.id.btn_aboutus);

        System.out.println("還是這裡嗎");

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view = inflater.inflate(R.layout.fragment_surprise, container, false);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener(){
             @Override
             public void onClick(View view) {
                 view = inflater.inflate(R.layout.fragment_surprise, container, false);
             }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view = inflater.inflate(R.layout.fragment_surprise, container, false);
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view = inflater.inflate(R.layout.fragment_surprise, container, false);
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view = inflater.inflate(R.layout.fragment_surprise, container, false);
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view = inflater.inflate(R.layout.fragment_surprise, container, false);
            }
        });
    return view;

    }
}