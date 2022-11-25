package com.example.kinmenfoodmap;
//這是不要用的Account
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class accountFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_favorite, container, false);
        // Inflate the layout for this fragment
        System.out.println("這裡嗎");
        Button btn1 = (Button) view.findViewById(R.id.button2);

        System.out.println("還是這裡嗎");
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("跳出來");
            }
        });

        return view;


    }
}