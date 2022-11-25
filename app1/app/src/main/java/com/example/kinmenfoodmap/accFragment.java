package com.example.kinmenfoodmap;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


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
                                        System.out.println("AAAA");
                                       // replaceFragment(new accFragment());
                                      //  view = inflater.inflate(R.layout.acc_record, container, false);
                                    }
                                });


    return view;

    }

    private  void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.menu_layout,fragment);
        fragmentTransaction.commit();
    }
}