package com.example.kinmenfoodmap;
//首頁的個人資料
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class accFragment extends Fragment {






   @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_acc, container, false);
        // Inflate the layout for this fragment
        System.out.println("這裡嗎");
        Button btn1 = (Button) view.findViewById(R.id.button5);

        System.out.println("還是這裡嗎");
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("到這裡對嗎");
               Intent intent = new Intent(getActivity(),ActivityGood.class);
               startActivity(intent);
            }
        });

        return view;


    }
}